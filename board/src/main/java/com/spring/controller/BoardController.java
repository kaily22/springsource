package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		log.info("�Խ��� ��ü ��� �����ֱ� : ");
		
		
		//����ڰ� ������ ������ �Խù�
		List<BoardVO> list = service.list(cri);
		//��ü �Խù� ��
		int total = service.total(cri);
		
		model.addAttribute("list", list);
		model.addAttribute("pageVO", new PageVO(cri, total));
	}

	@GetMapping("/register")
	public void register() {
		log.info("���� ��� �� ��û");
	}
	@PostMapping("/register")
	public String registerPost(BoardVO vo,RedirectAttributes rttr) {
		log.info("�Խñ� ����ϱ�" + vo);
		if (service.insert(vo)) {
			//log.info("�Էµ� �� ��ȣ" +vo.getBno());
			rttr.addFlashAttribute("result", vo.getBno());
			return "redirect:/board/list";
		} else {
			return "redirect:/board/register";
		}
	}

	// read? bno=22 ������ �о�� �� read.jsp

	@GetMapping({ "/read", "/modify" })
	public void read(int bno, @ModelAttribute("cri") Criteria cri, Model model) {
		log.info("������ �о���� "+bno+" ������ ������ " +cri);

		BoardVO vo = service.read(bno);
		model.addAttribute("vo", vo); //board/read or /board/modify

	}

	// /board/modify? bno=7 -> modify.jsp�� �ѹ� �� �ѷ���
	// modify+post ������ �� list
	@PostMapping("/modify")
	public String modify(BoardVO vo, Criteria cri, RedirectAttributes rttr) {
		log.info("�Խ��� �����ϱ� "+vo+"������ ������ " +cri);

		service.update(vo);
		rttr.addFlashAttribute("result", "����");
		
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		
		return "redirect:list";
	}

	//�Խñ� ����
	@PostMapping("/remove")
	public String remove(int bno, Criteria cri, RedirectAttributes rttr) {
		log.info("�Խñ� �����ϱ� " + bno);
		service.delete(bno);
		rttr.addFlashAttribute("result", "����");
		
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		
		return "redirect:list";
	}
}
