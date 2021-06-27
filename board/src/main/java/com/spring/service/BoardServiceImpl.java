package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.domain.AttachFileDTO;
import com.spring.domain.BoardVO;
import com.spring.domain.Criteria;
import com.spring.mapper.BoardAttachMapper;
import com.spring.mapper.BoardMapper;
import com.spring.mapper.ReplyMapper;


@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper mapper;
	
	@Autowired
	private BoardAttachMapper attachMapper;
	
	@Autowired
	private ReplyMapper replyMapper;
	
	@Transactional
	@Override
	public boolean insert(BoardVO vo) {

		//���� ���
		boolean result = mapper.insert(vo) >0 ? true: false;
		
		//÷������ ���
		if(vo.getAttachList()==null || vo.getAttachList().size()<=0) {
			return result;
		}
		
		vo.getAttachList().forEach(attach ->{
			attach.setBno(vo.getBno());
			attachMapper.insert(attach);
		});
		
		return result;
	}

	@Transactional
	@Override
	public boolean delete(int bno) {
		
		//��� ����
		replyMapper.deleteAll(bno);
		
		//÷������ ����
		attachMapper.delete(bno);
		//�Խñ� ����
		return mapper.delete(bno) >0? true:false;
	}

	
	@Transactional
	@Override
	public boolean update(BoardVO vo) {
		//������ ÷������ ���� ��� ���� �� ����
		
		attachMapper.delete(vo.getBno());
		
		//�Խñ� ����
		boolean modifyResult = mapper.update(vo) > 0? true: false;
		
		//÷������ ����
		if(modifyResult && vo.getAttachList().size() > 0) {
			for(AttachFileDTO dto:vo.getAttachList()) {
				dto.setBno(vo.getBno());
				attachMapper.insert(dto);
				
			}
		}
		return modifyResult;
	}

	@Override
	public List<BoardVO> list(Criteria cri) {
		return mapper.list(cri);
	}

	@Override
	public BoardVO read(int bno) {
		return mapper.read(bno);
	}

	@Override
	public int total(Criteria cri) {
		return mapper.totalCnt(cri);
	}

	@Override
	public List<AttachFileDTO> getattachList(int bno) {
		return attachMapper.findByBno(bno);
	}

}
