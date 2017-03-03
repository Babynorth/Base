<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/3
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
        <sitemesh:write property='title' /> - ltcms
    </title>
    <sitemesh:write property='head' />
</head>
<body>
    <header>header</header>
    demo.html的title将被填充到这儿222：
    <sitemesh:write property='title' />
    demo.html的body将被填充到这儿：
    <sitemesh:write property='body' />
    <footer>footer</footer>
</body>
</html>
