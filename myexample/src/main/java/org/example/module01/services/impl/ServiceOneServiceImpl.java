package org.example.module01.services.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.example.module01.dao.UserInfoMapper;
import org.example.module01.model.UserInfo;
import org.example.module01.services.IServiceOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestTemplate;

import com.baomidou.mybatisplus.plugins.Page;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

public class ServiceOneServiceImpl implements IServiceOne {

	private JdbcTemplate jdbcTemplate;
	private String namePrefix;
	private Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	private DiscoveryClient eurekaClient;

	@Autowired
    private ILoadBalancer ribbonLoadBalancer;
    
	@Autowired
	private UserInfoMapper UserInfoMapper;
	
	@Override
	public void addUser(String param) {
		String insert = "insert into test_user (name) values (?)";
		jdbcTemplate.update(insert, namePrefix + param);
	}

	public Object testMybatis(String param) {
		//Mybatis 查询
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("nickname", null == param ? "郭靖" : param);
		List<UserInfo> tmp = UserInfoMapper.selectData(params);
		logger.info(tmp);
		
		//Mybatis 插入数据
		UserInfo nn = new UserInfo();
		nn.setAddress("牛家村"); nn.setNickname("郭靖");	nn.setUid(99999999L);
		if(null != param) nn.setNickname(param);
		UserInfoMapper.insert(nn);
		
		//Mybatis 分页查询
        Page<UserInfo> page = new Page<UserInfo>(1,10);
        @SuppressWarnings("unused")
		List<UserInfo> lstUser = UserInfoMapper.selectData(page, params);
		logger.info(page);
		
		return page;
	}
	
	public Object testEurekaClient(String param) {
		String vipAddress = "service-provide-01";
		InstanceInfo nextServerInfo = null;
		try {
			nextServerInfo = eurekaClient.getNextServerFromEureka(vipAddress, false);
			// String url = "http://" + nextServerInfo.getHost() + ":" +
			// nextServerInfo.getPort() + "/user/getUser/2";
			String url = nextServerInfo.getHomePageUrl() + "/user/getUser/2";
			Object obj = restTemplate.getForObject(url, String.class);
			logger.info(obj);
			return obj;
		} catch (Exception e) {
			logger.info("Cannot get an instance of example service to talk to from eureka");
		}
		return "testEurekaClient";
	}

	public Object testRibbonClient(String param) {
		Server server = ribbonLoadBalancer.chooseServer("service-provide-01");
		String url = "http://" + server.getHost() + ":" + server.getPort() + "/user/getUser/2";
		logger.info(url);
		Object obj = restTemplate.getForObject(url, String.class);
		logger.info(obj);
		return obj;
	}

	@HystrixCommand(fallbackMethod = "fallback")
	public Object testHystrix(String param, Integer uid){
		Server server = ribbonLoadBalancer.chooseServer("service-provide-01");
		String url = "http://" + server.getHost() + ":" + server.getPort() + "/user/getUser/" + uid;
		logger.info(url);
		Object obj = restTemplate.getForObject(url, String.class);
		logger.info(obj);
		return obj;
	}
	
	public Object fallback(String param, Integer uid) {
		return "fallbck123";
	}
	
	
	@SuppressWarnings("unused")
	private void sendRequestToServiceUsingEureka(EurekaClient eurekaClient, String param) {
		// initialize the client
		// this is the vip address for the example service to talk to as defined in
		// conf/sample-eureka-service.properties
		String vipAddress = "service-provide-01";
		InstanceInfo nextServerInfo = null;
		try {
			nextServerInfo = eurekaClient.getNextServerFromEureka(vipAddress, false);
		} catch (Exception e) {
			logger.error("Cannot get an instance of example service to talk to from eureka");
		}

		logger.info("Found an instance of example service to talk to from eureka: " + nextServerInfo.getVIPAddress()
				+ ":" + nextServerInfo.getPort());

		logger.info("healthCheckUrl: " + nextServerInfo.getHealthCheckUrl());
		logger.info("override: " + nextServerInfo.getOverriddenStatus());

		Socket s = new Socket();
		int serverPort = nextServerInfo.getPort();
		try {
			s.connect(new InetSocketAddress(nextServerInfo.getHostName(), serverPort));
		} catch (IOException e) {
			logger.error("Could not connect to the server :" + nextServerInfo.getHostName() + " at port " + serverPort);
		} catch (Exception e) {
			logger.error("Could not connect to the server :" + nextServerInfo.getHostName() + " at port "+ serverPort + "due to Exception " + e);
		} finally {
			try {
				s.close();
			} catch (IOException e) {
				logger.error(e);
			}
		}
		try {
			String request = "FOO " + new Date();
			logger.info("Connected to server. Sending a sample request: " + request);

			PrintStream out = new PrintStream(s.getOutputStream());
			out.println(request);

			logger.info("Waiting for server response..");
			BufferedReader rd = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String str = rd.readLine();
			if (str != null) {
				logger.info("Received response from server: " + str);
				logger.info("Exiting the client. Demo over..");
			}
			rd.close();
		} catch (IOException e) {
			logger.error(e);
		}
	}

	public String getNamePrefix() {
		return namePrefix;
	}

	public void setNamePrefix(String namePrefix) {
		this.namePrefix = namePrefix;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
