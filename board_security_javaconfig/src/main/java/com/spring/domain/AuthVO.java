package com.spring.domain;

import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;

import lombok.Setter;
import lombok.ToString;
import lombok.Getter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class AuthVO {
	private String userid;
	private String auth;

}
