<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>removeHtmlVar</title>
</head>
<body>
<c:set var="dateEL" value="<%= new Date() %>" />
<tf:removeHtmlVar trim="true" var="removed">
  <font size="10"> 현재 시간은 ${dateEL} 입니다. </font>
</tf:removeHtmlVar>

처리결과: ${removed }

</body>
</html>