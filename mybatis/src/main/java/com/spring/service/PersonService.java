package com.spring.service;

import java.util.List;

import com.spring.domain.PersonVO;

public interface PersonService {
   public void insertPerson(String id, String name);
   public boolean updatePerson(String id, String name);
   public boolean deletePerson(String id);
   public String select(String id);
   public List<PersonVO> getList();
   
}