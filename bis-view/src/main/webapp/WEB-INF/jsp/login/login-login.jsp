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
             <input class="captcha" type="text" name="captcha" placeholder="请输入验证码" onkeypress="enter()" id="j_captcha" />
              <img id="captcha" alt="验证码" src="${baseUrl}/captcha/captchaImage!execute" title="看不清？换一张" class="img">
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

            //更换验证码
            $("#captcha").click(function(e) {
                changeCaptcha(e.target);
            });
            showMsg();

        });

        function changeCaptcha(obj){
            obj.src = "${baseUrl}/captcha/captchaImage!execute?d=" +  new Date();
        }

        function login() {
            var captcha = $("#j_captcha").val();
            if(captcha == "") {
                showMsg(captcha);
                return false;
            }
            var captchaFlag = false;
            $.ajax({
                async:false,
                type: 'POST',
                dataType : "text",
                url: '${baseUrl}/test!test1?captcha=' + captcha ,

                success:function(data){
                    captchaFlag = data;
                    if(captchaFlag == "false") {
                        changeCaptcha(document.getElementById("captcha"));
                        showMsg(captchaFlag);
                    }
                },
                error :function(){
                    alert("系统异常请联系管理员！");
                }
            });

           if(captchaFlag != "false"){
               document.getElementById("loginform").submit();
           } else {
               return captchaFlag;
           }

        }

        function showMsg(obj) {
            var error = '${param.error}';
            var html = '';

            if(obj == ""){
                html = '<div class="light-info"><div class="light-tip icon-tip"></div><div>验证码不能为空，请输入验证码！</div></div>';
                $.messager.show({
                    title:'提示',
                    msg:html,
                    showType:'show',
                    timeout: 5000
                });
            }
            if(error != "") {
                if(error == "1") {
                    html = '<div class="light-info"><div class="light-tip icon-tip"></div><div>用户不存在！</div></div>';
                }
                error = obj;
                if(error == "false") {
                    html = '<div class="light-info"><div class="light-tip icon-tip"></div><div>验证码错误,请重新输入！</div></div>';
                }
                $.messager.show({
                    title:'提示',
                    msg:html,
                    showType:'show',
                    timeout: 5000
                });
            }
        }

        //按回车键查询
        function enter() {
            if(event.keyCode == "13") {
                login();
            }

        }



    </script>
</head>


</html>
