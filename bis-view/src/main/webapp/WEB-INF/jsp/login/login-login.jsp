<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>用户登录</title>
    <meta name="viewport" content="width=device-width">
   <link rel="stylesheet" type="text/css" href="${baseUrl}/common/themes/css/login.css" />
   <link rel="stylesheet" type="text/css" href="${baseUrl}/common/themes/css/captcha.css" />
    <link rel="stylesheet" type="text/css" href="${baseUrl}/common/themes/css/dreamlu.css" />
     <link rel="stylesheet" type="text/css" href="${baseUrl}/common/themes/gray/easyui.css" />
     <link rel="stylesheet" type="text/css" href="${baseUrl}/common/themes/icons/icon.css" />
   <script type="text/javascript" src="${baseUrl }/common/js/jquery.min.js" charset="utf-8"></script>
   <script type="text/javascript" src="${baseUrl }/common/js/jquery.easyui.min.js" charset="utf-8"></script>

    <script type="text/javascript" src="${baseUrl }/common/js/login.js" charset="utf-8"></script>
     <%--<script type="text/javascript" src="${baseUrl }/common/js/extJs.js" charset="utf-8"></script>--%>
<body>

<div class="top_div"></div>
<div class="first_div">
   <form method="post" id="loginform" action="${baseUrl}/j_spring_security_check">
        <div class="form_fir_div">
            <div class="tou"></div>
            <div class="initial_left_hand" id="left_hand"></div>
            <div class="initial_right_hand" id="right_hand"></div>
        </div>
        <P class="form_fir_p">
            <span class="u_logo"></span>
            <input class="ipt" type="text" name="username" placeholder="请输入用户名或邮箱"  />
        </P>
        <P class="form_sec_p">
            <span class="p_logo"></span>
            <input class="ipt" id="password" type="password" name="password" placeholder="请输入密码" value="" />
        </P>
        <P class="fir_captcha">
             <input class="captcha" type="text" name="captcha" placeholder="请输入验证码"/>
             <img id="captcha" alt="验证码" src=""  style="vertical-align:middle;border-radius:4px;width:94.5px;height:35px;cursor:pointer;">
         </P>
        <div class="form_sec_div">
            <P class="form_thir_p">
                    <span class="form_p_firSpan">
                        <a class="form_fir_a" href="javascript:;">忘记密码?</a>
                    </span>
                    <span class="form_p_secSpan">
                        <a class="form_sec_a" href="javascript:;">注册</a>
                        <input class="form_fir_button"  type="button" value="登录" />
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



<script type="text/javascript">
        $(document).ready(function(){

            $(".form_fir_button").click(function() {
                login();

            });
            showMsg();

        });

        function login() {
            $.ajax({
                async:false,
                type: 'POST',
                dataType : "text",
                url: '${baseUrl}/test!test',

                success:function(data){

                },
                error :function(){
                    alert(123);
                }
            });
            document.getElementById("loginform").submit();
        }

        function showMsg() {
            var error = '${param.error}';
            var html = '';

            if(error != "") {
                if(error == "1") {
                    html = '<div class="light-info"><div class="light-tip icon-tip"></div><div>用户不存在！</div></div>';
                }
                $.messager.show({
                    title:'提示',
                    msg:html,
                    showType:'show',
                    timeout: 5000
                });
            }
        }


    </script>
</head>


</html>
