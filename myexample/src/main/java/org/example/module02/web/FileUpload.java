package org.example.module02.web;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import china.dream.every.framework.json.JsonResult;

//定制框架功能，MVC请求URL模式为模块名/类名/方法名
@Controller
public class FileUpload {
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Value("${module02.uploadFilePath:/tmp}")
	private String uploadPath; 
	
	@RequestMapping(produces = "application/json; charset=utf-8")
	@ResponseBody
	public JsonResult doUpload(@RequestParam MultipartFile[] myfiles, HttpServletRequest request,
			@RequestParam(value = "att2") String att2, @RequestParam(value = "att3") String att3, Model model)
			throws IOException {
		// 如果只是上传一个文件，则只需要MultipartFile类型接收文件即可，而且无需显式指定@RequestParam注解
		// 如果想上传多个文件，那么这里就要用MultipartFile[]类型来接收文件，并且还要指定@RequestParam注解
		// 并且上传多个文件时，前台表单中的所有<input type="file"/>的name都应该是myfiles，否则参数里的myfiles无法获取到所有上传的文件
		for (MultipartFile myfile : myfiles) {
			if (myfile.isEmpty()) {
				logger.info("文件未上传");
			} else {
				logger.info("文件长度: " + myfile.getSize() + ",文件类型: " + myfile.getContentType() + ",文件名称: " + myfile.getName()
					+ "文件原名: " + myfile.getOriginalFilename());
				// 这里不必处理IO流关闭的问题，因为FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO流关掉
				FileUtils.copyInputStreamToFile(myfile.getInputStream(), new File(uploadPath, myfile.getOriginalFilename()));
			}
		}
		
		return new JsonResult(true, "上传完成");
//		return "上传完成";
	}

	public String getUploadPath() {
		return uploadPath;
	}

	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}

	
}