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
@RequestMapping("/modules/module02/")
public class ActionTwo {

	private Integer abc;
	private IBizTwo bizTwo;
	private Logger logger = Logger.getLogger(this.getClass());
	
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

	//http://localhost:8000/myexample/modules/module02/actionTwo.do?username=zhouyunlong 
	//注解配置方式
	@RequestMapping("/actionTwo.do")
	public String actionTwo(@RequestParam(value = "username", required = false, defaultValue = "钟馗") String username,
			Model model) {
		
		model.addAttribute("username", username);
		logger.info("page02:" + model);
		bizTwo.addBiz01(username);
		@SuppressWarnings("unused")
		List<Map<String, Object>>  rs = bizTwo.getBiz01(username);
		return "page02";
	}

	//定制框架功能，MVC请求URL模式为模块名/类名/方法名
	//http://localhost:8000/myexample/modules/module02/ActionTwo/aabbcc.do
	@RequestMapping
	@ResponseBody
	public UserInfoVO aabbcc(@RequestParam(value = "username", required = false, defaultValue = "钟馗") String username,
			Model model) {
		
		//bizTwo.addBiz01(username);
		logger.info("aabbcc:" + model);
		UserInfoVO user = new UserInfoVO(123L, "山胖子", "象牙山");
		return user;
	}
	
}
