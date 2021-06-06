package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.PersonVO;
import com.spring.mapper.PersonMapper;

@Service("person")
public class PersonServiceImpl implements PersonService {
	
	@Autowired
   private PersonMapper mapper;
   
	@Override
   public void insertPerson(String id, String name) {
		mapper.insertPerson(id, name);
	}
	@Override
	   public boolean deletePerson(String id) {
			return mapper.deletePerson(id)> 0 ? true:false;
		}
	@Override
	   public boolean updatePerson(String id, String name) {
			return mapper.updatePerson(id, name)> 0 ? true:false;
		}
	@Override
	   public String select(String id){
			return mapper.selectPerson(id);
		}
	@Override
	   public List<PersonVO> getList() {
		return mapper.selectAll();
		}
	

}