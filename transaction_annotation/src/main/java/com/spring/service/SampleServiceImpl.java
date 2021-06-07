package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mapper.SampleMapper1;
import com.spring.mapper.SampleMapper2;


@Service("sample")
public class SampleServiceImpl implements SampleService {
	
	//autowired 개별로 붙여야함
	
	@Autowired
	private SampleMapper1 mapper1;
	@Autowired
	private SampleMapper2 mapper2;
	
	@Override
	@Transactional
	public void addData(String data) {
		mapper1.insertCol(data);
		mapper2.insertCol(data);	
	}

}
