<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<%@ include file="/commons/global.jsp" %>--%>
<!DOCTYPE html>
<html>
<head>
    <title>用户登录</title>
    <meta name="viewport" content="width=device-width">
    <link rel="stylesheet" type="text/css" href="${baseUrl}/common/themes/css/login.css" />
    <link rel="stylesheet" type="text/css" href="${baseUrl}/common/themes/css/dreamlu.css" />
    <link rel="stylesheet" type="text/css" href="${baseUrl}/common/themes/gray/easyui.css" />
    <link rel="stylesheet" type="text/css" href="${baseUrl}/common/themes/icons/icon.css" />
   <script type="text/javascript" src="${baseUrl }/common/js/jquery.min.js" charset="utf-8"></script>
   <script type="text/javascript" src="${baseUrl }/common/js/jquery.easyui.min.js" charset="utf-8"></script>

    <script type="text/javascript" src="${baseUrl }/common/js/login.js" charset="utf-8"></script>
     <%--<script type="text/javascript" src="${baseUrl }/common/js/extJs.js" charset="utf-8"></script>--%>
    <script type="text/javascript">
        $(document).ready(function(){

        });

    </script>
</head>
<body>


<div class="top_div"></div>
<div class="first_div" >

    <form method="post" id="loginform" action="${baseUrl}/j_spring_security_check">
        <div class="second_div">
            <div class="tou"></div>
            <div class="initial_left_hand" id="left_hand"></div>
            <div class="initial_right_hand" id="right_hand"></div>
        </div>
        <P class="first_p">
            <span class="u_logo"></span>
            <input class="ipt" type="text" name="username" placeholder="请输入用户名或邮箱"  />
        </P>
        <P class="second_p">
            <span class="p_logo"></span>
            <input class="ipt" id="password" type="password" name="password" placeholder="请输入密码" value="" />
        </P>
        <div class="third_div">
            <P class="third_p">
                <span class="span_left">
                    <a class="span_left a" href="javascript:;">忘记密码?</a>
                </span>
                <span class="span_right">
                    <a class="span_right_first_a" href="javascript:;">注册</a>
                    <input class="span_right_second_a"  type="button" value="登录" />
                </span>
            </P>
        </div>
    </form>
</div>
<div class="panel window"style="right: 0px; z-index: 9003; bottom: -124px; display: block; width: 246px;">
    <div class="panel-header panel-header-noborder window-header"style="width: 246px;">
        <div class="panel-tool">
            <a href="javascript:void(0)"class="panel-tool-close"></a>
        </div>
    </div>
     <div class="messager-body panel-body panel-body-noborder window-body"title=""style="width: 224px; height: 52px;">
        <div class="light-info">
            <div class="light-tip icon-tip"></div>
        </div>
     </div>
</div>
</body>
</html>
