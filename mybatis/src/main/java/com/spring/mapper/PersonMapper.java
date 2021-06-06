package com.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import com.spring.domain.PersonVO;

public interface PersonMapper {
//	//xml¾øÀÌ
//	@Insert("insert into person(id,name) values(#{id},#{name})")
//	public int insertPerson(@Param("id")String id,  @Param("name")String name) ;

	
	public int insertPerson(@Param("id")String id,  @Param("name")String name);
	public int deletePerson(String id);
	public int updatePerson(@Param("id")String id,  @Param("name")String name);
	public List<PersonVO> selectAll();
	public String selectPerson(String id);
	
	}
