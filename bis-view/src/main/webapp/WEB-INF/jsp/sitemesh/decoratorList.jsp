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
    <link href="${baseUrl}/theme/style/base.css" rel="stylesheet" type="text/css" />
    <!--引用JQuery-->
    <script type="text/javascript" src="${baseUrl}/theme/script/jquery.js"></script>
    <!--其他样式-->
    <script type="text/javascript" src="${baseUrl}/theme/script/Other.js"></script>
</head>
<body>

<div class="top">
    <apan class="site_info">
        郑北&nbsp;|
        <span id="_dtp"></span>
        <a href="${baseUrl}/j_spring_security_logout">退出</a>
    </apan>
    <div class="w t_cen">
        <div class="t_c_logo"><a href="index.html"><img src="${baseUrl}/theme/images/logo.png" /></a></div>
        <div class="t_c_lr t_c_left"></div>
        <div class="t_c_cen">
            <div class="t_c_top">
            </div>
            <div class="t_c_bottom">
                <ul>
                    <li class="thisli">
                        <a href="#"><em>官方首页</em><i>Home</i></a>
                    </li>
                    <li>
                        <a href="#"><em>集团概况</em><i>About Us</i></a>
                        <div class="Nodes">
                            <img src="${baseUrl}/theme/images/menu_top.png" />
                            <ul>
                                <li><a href="#">公司简介</a></li>
                                <li><a href="#">总部扶持</a></li>
                                <li><a href="#">服务团队</a></li>
                            </ul>
                            <img src="${baseUrl}/theme/images/menu_bottom.png" />
                        </div>
                    </li>
                    <li>
                        <a href="#"><em>品牌中心</em><i>Brand</i></a>
                        <div class="Nodes">
                            <img src="${baseUrl}/theme/images/menu_top.png" />
                            <ul>
                                <li><a href="#">品牌文化</a></li>
                                <li><a href="#">市场前景</a></li>
                                <li><a href="#">品牌形象</a></li>
                                <li><a href="#">店面形象</a></li>
                            </ul>
                            <img src="${baseUrl}/theme/images/menu_bottom.png" />
                        </div>
                    </li>
                    <li>
                        <a href="#"><em>产品中心</em><i>Product </i></a>
                        <div class="Nodes">
                            <img src="${baseUrl}/theme/images/menu_top.png" />
                            <ul>
                                <li><a href="#">产品案例</a></li>
                                <li><a href="#">核心产品</a></li>
                                <li><a href="#">主流产品</a></li>
                            </ul>
                            <img src="${baseUrl}/theme/images/menu_bottom.png" />
                        </div>
                    </li>
                    <li>
                        <a href="#"><em>项目优势</em><i>Advantages</i></a>
                        <div class="Nodes">
                            <img src="${baseUrl}/theme/images/menu_top.png" />
                            <ul>
                                <li><a href="#">产品优势</a></li>
                                <li><a href="#">投资优势</a></li>
                                <li><a href="#">店面优势</a></li>
                                <li><a href="#">总部优势</a></li>
                            </ul>
                            <img src="${baseUrl}/theme/images/menu_bottom.png" />
                        </div>
                    </li>
                    <li>
                        <a href="#"><em>加盟我们</em><i>Join Us</i></a>
                        <div class="Nodes">
                            <img src="${baseUrl}/theme/images/menu_top.png" />
                            <ul>
                                <li><a href="#">加盟模式</a></li>
                                <li><a href="#">加盟流程</a></li>
                                <li><a href="#">成功案例</a></li>
                            </ul>
                            <img src="${baseUrl}/theme/images/menu_bottom.png" />
                        </div>
                    </li>
                    <li>
                        <a href="#"><em>新闻中心</em><i>News</i></a>
                        <div class="Nodes">
                            <img src="${baseUrl}/theme/images/menu_top.png">
                            <ul>
                                <li><a href="#">品牌新闻</a></li>
                                <li><a href="#">行业新闻</a></li>
                            </ul>
                            <img src="${baseUrl}/theme/images/menu_bottom.png" />
                        </div>
                    </li>
                    <li>
                        <a href="#"><em>联系我们</em><i>Contact</i></a>
                    </li>

                </ul>
                <div class="thisMenu" id="thisMenu"></div>
            </div>
        </div>
        <div class="t_c_lr t_c_right"></div>
    </div>
</div>
    <sitemesh:write property='body' />

</body>
</html>
