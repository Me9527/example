package org.example.module01.services;

public interface IServiceOne {
	public void addUser(String param);
//	public void loadUser(String param);
	public Object testMybatis(String param);
	
	public Object testEurekaClient(String param);
	public Object testRibbonClient(String param);
	
	public Object testHystrix(String param, Integer uid);
}
