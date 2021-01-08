
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <!-- 优先使用 IE 最新版本和 Chrome -->
  <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
  <!-- 为移动设备添加响应式设计 -->
  <meta name="viewport" content="width=device-width, initial-scale=1"/>
  <link rel="icon" href="img/2.jpg" type="img/x-ico" />

  <title>首页</title>
  <!--1.导入CSS的全局样式-->
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <!--2.导入jQuery-->
  <script src="js/jquery-2.1.0.min.js"></script>
  <!--3.导入bootstrap的js文件-->
  <script src="js/bootstrap.min.js"></script>

</head>


<%--${pageContext.request.contextPath}--%>
<%--当前项目的名称--%>
<div  align="center" style="color: deeppink">
  <h2>${user.name},欢迎您登陆后台管理系统</h2>
</div>
<div align="center" id="query" >
  <a href="${pageContext.request.contextPath}/findUserByPageServlet" style="text-decoration: none;font-size: 60px">
    点击查询所有学生信息
  </a>
</div>

<body>

</body>
</html>
