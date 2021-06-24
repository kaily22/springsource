package com.spring.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.domain.AttachFileDTO;
import com.spring.domain.BoardVO;
import com.spring.domain.Criteria;
import com.spring.domain.PageVO;
import com.spring.service.BoardService;

import lombok.extern.log4j.Log4j2;
import oracle.jdbc.proxy.annotation.Post;

@Controller
@Log4j2
@RequestMapping("/board/*")
public class BoardController {

	@Autowired
	private BoardService service;

	@GetMapping("/list")
	public void listGet(Model model, Criteria cri) {
		log.info("게시판 전체 목록 보여주기 : ");
		
		
		//사용자가 선택한 페이지 게시물
		List<BoardVO> list = service.list(cri);
		//전체 게시물 수
		int total = service.total(cri);
		
		model.addAttribute("list", list);
		model.addAttribute("pageVO", new PageVO(cri, total));
	}

	@GetMapping("/register")
	public void register() {
		log.info("새글 등록 폼 요청");
	}
	
	@PostMapping("/register")
	public String registerPost(BoardVO vo,RedirectAttributes rttr) {
		log.info("게시글 등록하기" + vo);
		
		//첨부 파일 확인
		if(vo.getAttachList()!=null) {
			vo.getAttachList().forEach(attach -> log.info(""+attach));
			
		}
		
		if (service.insert(vo)) {
			//log.info("입력된 글 번호" +vo.getBno());
			rttr.addFlashAttribute("result", vo.getBno());
			return "redirect:/board/list";
		} else {
			return "redirect:/board/register";
		}
	}

	// read? bno=22 데이터 읽어온 후 read.jsp

	@GetMapping({ "/read", "/modify" })
	public void read(int bno, @ModelAttribute("cri") Criteria cri, Model model) {
		log.info("데이터 읽어오기 "+bno+" 페이지 나누기 " +cri);

		BoardVO vo = service.read(bno);
		model.addAttribute("vo", vo); //board/read or /board/modify

	}

	// /board/modify? bno=7 -> modify.jsp에 한번 더 뿌려줌
	// modify+post 수정한 후 list
	@PostMapping("/modify")
	public String modify(BoardVO vo, Criteria cri, RedirectAttributes rttr) {
		log.info("게시판 수정하기 "+vo+"페이지 나누기 " +cri);

		
		//첨부 파일 확인
		if(vo.getAttachList()!=null) {
		     vo.getAttachList().forEach(attach -> log.info(""+attach));
					
		}
				
		service.update(vo);
		
		rttr.addFlashAttribute("result", "성공");
		
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		
		return "redirect:list";
	}

	//게시글 삭제
	@PostMapping("/remove")
	public String remove(int bno, Criteria cri, RedirectAttributes rttr) {
		log.info("게시글 삭제하기 " + bno);
		service.delete(bno);

		
		//서버에 저장된 첨부파일 삭제
		//1) bno 해당하는 첨부파일 목록 알아내기
		
		List<AttachFileDTO> attachList = service.getattachList(bno);
		
		//게시글 삭제+첨부파일 삭제
		if(service.delete(bno)) {
		
		//2) 폴더 파일 삭제
		deleteFiles(attachList);
		rttr.addFlashAttribute("result","성ㅇ공");
		}
		
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		
		return "redirect:list";
	}
	
	//첨부물 가져오기
	@GetMapping("/getAttachList")
	public ResponseEntity<List<AttachFileDTO>> getAttachList(int bno){
	log.info("첨부물 가져오기 "+bno);
		
		return new ResponseEntity<List<AttachFileDTO>>(service.getattachList(bno),HttpStatus.OK);
	}

	private void deleteFiles(List<AttachFileDTO> attachList) {
		log.info("첨부파일 삭제" +attachList);
		
		if(attachList==null || attachList.size()<=0) {
			return;
		}
		
		for(AttachFileDTO dto:attachList) {
		    Path path = Paths.get("c:\\upload\\", dto.getUploadPath()+"\\"+dto.getUuid()+"_"+dto.getFileName());		
		
		try {
			Files.deleteIfExists(path);
			
			if(Files.probeContentType(path).startsWith("image")) {
				Path thumbnail = Paths.get("c:\\upload\\",
						dto.getUploadPath()+"\\s_"+dto.getUuid()+"_"+dto.getFileName());
				Files.delete(thumbnail);
			}
		} catch (IOException e) {
				e.printStackTrace();
		}
	}
 }
}
