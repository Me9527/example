package org.example.module02.web;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.example.module01.services.IServiceOne;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import china.dream.every.framework.security.util.UserConstants;
import china.dream.every.framework.security.vo.UserInfoVO;


//定制框架功能，MVC请求URL模式为模块名/类名/方法名 
//module01.web 下不能存在同名的ActionOne类问题。 解决办法 @Controller("ActionOne2")
//@Controller("ActionOne2")
public class ActionOne {

	private Integer propertiesParams;
	private IServiceOne serviceOne;
	private JdbcTemplate jdbcTemplate;
	private Logger logger = Logger.getLogger(this.getClass());
/*	@Autowired
	private ServiceTwoServiceImpl serviceTwoServiceImpl;*/
    
	@RequestMapping
	public String greeting(@RequestParam(value = "username", required = false, defaultValue = "World") String username,
			Model model) {
		
		//直接在Controller查询数据库数据。
//		String query = "select id, name from test_user";
//		List<Map<String, Object>> rs = jdbcTemplate.queryForList(query);
//		logger.info(rs);
		
		//事务控制是在service层的， 这里的insert 操作应不会commit到数据库。
//		String insert = "insert into test_user (name) values (?)";
//		jdbcTemplate.update(insert, username);
		
		//下面的方式必须请求url必须被安全拦截器拦截才有效，否则抛出null异常。
//		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		logger.info( userDetails.getName()+ "----------------------------------------" + userDetails.getUsername());
		
		return "page01";	// /modules/module01/jsp/page01.jsp
	}

	@RequestMapping
	public String addUser(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {

		logger.info("addUser:" + name);
		serviceOne.addUser(name);
		return "page02";
	}

	@RequestMapping
	@ResponseBody
	public Object testMybatis(@RequestParam(value = "name", required = false) String name,
			Model model) {

		logger.info("testMybatis:" + name);
		Object obj = serviceOne.testMybatis(name);
		return obj;
	}
	
	@RequestMapping
	public String index(HttpSession session, Model model) {
		Object obj = session.getAttribute(UserConstants.UserInfoInHttpSession);
		if(obj != null && obj instanceof UserInfoVO)
			return "index";
		else
			return "Not login";
		//下面的方式必须请求url必须被安全拦截器拦截才有效，否则抛出null异常。
//		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		logger.info("index:" + userDetails.getName()+ "-" + userDetails.getUsername());
	}
	
	@RequestMapping
	@ResponseBody
	public Object testEurekaClient(String param) {
		
		Object rs = serviceOne.testEurekaClient(param);
		return rs;
	}
	
	@RequestMapping
	@ResponseBody
	public Object testRibbonClient(String param) {
		
		Object rs = serviceOne.testRibbonClient(param);
		return rs;
	}
	
	@RequestMapping
	@ResponseBody
	public Object testHystrix(@RequestParam(value = "uid", required = true, defaultValue = "2") Integer uid, 
			@RequestParam(value = "param", required = true) String param, Model model) {
		
//		Object rs = serviceTwoServiceImpl.testHystrix(param, uid);
		Object rs = serviceOne.testHystrix(param, uid);
		return rs;
	}

	public Integer getPropertiesParams() {
		return propertiesParams;
	}

	public void setPropertiesParams(Integer propertiesParams) {
		this.propertiesParams = propertiesParams;
	}

	public IServiceOne getServiceOne() {
		return serviceOne;
	}

	public void setServiceOne(IServiceOne serviceOne) {
		this.serviceOne = serviceOne;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
