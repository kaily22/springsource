package com.spring.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogTest {

	private static final Logger logger = LogManager.getLogger(LogTest.class);
	
	
	public static void main(String[] args) {
		
		logger.error("error 레벨");
		logger.warn("warn 레벨");
		logger.info("info 레벨");
		logger.debug("debug 레벨");
		logger.trace("trace 레벨");
		
	}

}
