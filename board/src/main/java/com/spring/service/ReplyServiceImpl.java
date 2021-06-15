package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.Criteria;
import com.spring.domain.ReplyVO;
import com.spring.mapper.ReplyMapper;


@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired 
	private ReplyMapper mapper;
	
	@Override
	public boolean replyInsert(ReplyVO reply) {
		return mapper.insert(reply)>0? true: false;
	}

	@Override
	public ReplyVO replyGet(int rno) {
		return mapper.read(rno);
	}

	@Override
	public boolean replyUpdate(ReplyVO reply) {
		return mapper.update(reply)>0? true : false;
	}

	@Override
	public boolean replyDelete(int rno) {
		return mapper.delete(rno) >0 ?true : false;
	}

	@Override
	public List<ReplyVO> getList(Criteria cri, int bno) {
		return mapper.list(cri, bno);
	}

}
