package com.spring.domain;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class ReplyPageVO {
	private int replyCnt; //��� ��ü ����
	private List<ReplyVO> list;
}
