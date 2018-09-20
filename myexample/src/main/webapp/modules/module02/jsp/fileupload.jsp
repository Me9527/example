<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/modules/commons/jsp/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <form action="<%=request.getContextPath()%>/module02/FileUpload/doUpload.do" method="POST" enctype="multipart/form-data">  
        属性二: <input type="text" name="att2"/><br/>  
        属性三: <input type="text" name="att3"/><br/>  
        文件一: <input type="file" name="myfiles"/><br/>  
        文件二: <input type="file" name="myfiles"/><br/>  
        文件三: <input type="file" name="myfiles"/><br/>  
        <input type="submit" value="上传保存"/>  
    </form> 
</body>
</html>