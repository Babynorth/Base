<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/2/17
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String url = request.getContextPath() + "/login/login!main.action";
    response.sendRedirect(url);
%>
