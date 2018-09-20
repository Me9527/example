package org.example.module02.web;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUpload {
	private Logger logger = Logger.getLogger(this.getClass());
	
//	@Value("#{module02.uploadFilePath}") 
	private String uploadPath = "D:/dir06/tmp/upload"; 
	
	@RequestMapping(produces = "application/json; charset=utf-8")
	@ResponseBody
	public String doUpload(@RequestParam MultipartFile[] myfiles, HttpServletRequest request,
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
				// 如果用的是Tomcat服务器，则文件会上传到\\%TOMCAT_HOME%\\webapps\\YourWebProject\\WEB-INF\\upload\\文件夹中
				String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF/upload");
				// 这里不必处理IO流关闭的问题，因为FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO流关掉
				FileUtils.copyInputStreamToFile(myfile.getInputStream(), new File(uploadPath, myfile.getOriginalFilename()));
			}
		}
		return "上传完成";
	}

	public String getUploadPath() {
		return uploadPath;
	}

	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}

	
}