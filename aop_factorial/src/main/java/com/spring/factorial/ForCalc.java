package com.spring.factorial;

import org.springframework.stereotype.Component;

@Component("fact")
public class ForCalc implements Calculator {

	@Override
	public long factorial(long num) {
		
		//long start = System.currentTimeMillis();
		long result = 1;
		for(int i=1; i<=num; i++) {
			result *= i;
		}
		//long end = System.currentTimeMillis();
		//System.out.println("걸린 시간: " +(end-start));
		return result;
	}

}
