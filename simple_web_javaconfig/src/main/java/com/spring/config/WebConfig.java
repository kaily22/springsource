package com.spring.config;

import javax.servlet.Filter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


@Configuration
//dispatcherServlet : √ ±‚»≠
public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	//context-param
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {RootConfig.class};
	}

	@Override
	//servlet-context
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {ServletConfig.class};
	}

	@Override
	//servlet-mapping
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
	
	@Override
	
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("utf-8");
		encodingFilter.setForceEncoding(true);
		
		return new Filter[] {encodingFilter};
		
		
	}
}
