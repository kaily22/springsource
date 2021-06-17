package com.spring.mapper;

import java.util.List;

import com.spring.domain.AttachFileDTO;

public interface BoardAttachMapper {
	
	public int insert(AttachFileDTO attach);
	public int delete(String uuid);
	public List<AttachFileDTO> findByBno();
	

}
