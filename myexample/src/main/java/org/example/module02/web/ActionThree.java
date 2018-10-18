package org.example.module02.web;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.example.module02.services.IBizTwo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import china.dream.every.framework.security.vo.UserInfoVO;

@Controller
public class ActionThree {

	private Integer abc;
	private IBizTwo bizTwo;
	private Logger logger = Logger.getLogger(this.getClass());
	
	@RequestMapping("/actionTwo.do")	//不应该有这个URL配置，框架会默认取方法名组成URL路径
	public String actionTwo(@RequestParam(value = "username", required = false, defaultValue = "钟馗") String username,
			Model model) {
		
		model.addAttribute("username", username);
		logger.info("page02:" + model);
		bizTwo.addBiz01(username);
		@SuppressWarnings("unused")
		List<Map<String, Object>>  rs = bizTwo.getBiz01(username);
		return "page02";
	}

	@RequestMapping
	@ResponseBody
	public UserInfoVO getUserInfo(@RequestParam(value = "username", required = false, defaultValue = "钟馗") String username,
			Model model) {
		
		//bizTwo.addBiz01(username);
		logger.info("getUserInfo:" + model);
		UserInfoVO user = new UserInfoVO(123L, "山胖子", "象牙山");
		return user;
	}

	@RequestMapping("/invokeService.do")	//不应该有这个URL配置，框架会默认取方法名组成URL路径
	public String invokeService(@RequestParam(value = "username", required = false, defaultValue = "钟馗") String username,
			Model model) {
		
		logger.info("invokeService:" + username);
		@SuppressWarnings("unused")
		List<Map<String, Object>>  rs = bizTwo.invokeService(username);
		return "page02";
	}
	
	public void anConttrolMethod() {
		logger.info("anConttrolMethod");
	}
	
	public Integer getAbc() {
		return abc;
	}

	public void setAbc(Integer abc) {
		this.abc = abc;
	}

	public IBizTwo getBizTwo() {
		return bizTwo;
	}

	public void setBizTwo(IBizTwo bizTwo) {
		this.bizTwo = bizTwo;
	}
}
