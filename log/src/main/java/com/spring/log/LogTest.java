package com.spring.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogTest {

	private static final Logger logger = LogManager.getLogger(LogTest.class);
	
	
	public static void main(String[] args) {
		
		logger.error("error ����");
		logger.warn("warn ����");
		logger.info("info ����");
		logger.debug("debug ����");
		logger.trace("trace ����");
		
	}

}
