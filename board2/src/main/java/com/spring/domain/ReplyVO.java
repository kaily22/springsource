package com.spring.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class ReplyVO {
	
	private int rno;
	private int bno;
	private String reply;
	private String replyer;
	private Date replydate;
	private Date updatedate;

}
