

<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
    <#include "common/baseProperties.ftl"/>
    <link href="${basePath}/css/module/login/signin.css" rel="stylesheet">
</head>
<body style="min-height: auto!important;">

<div class="htmleaf-container" id="loginBody" v-cloak>
    <div class="signin">
        <div class="signin-head"><img src="${basePath}/img/login/login.gif" alt="" class="img-circle"></div>
        <form class="form-signin" role="form" id="loginForm" onsubmit="return false;">
            <input type="text" name="username" id="username" class="form-control t-show" placeholder="<@spring.message code="login.username" />" autofocus/>
            <input type="password" name="password" id="password" class="form-control t-show" placeholder="<@spring.message code="login.password" />"/>
            <button class="btn btn-lg btn-warning btn-block ladda-button" data-style="zoom-out"  type="submit" id="submit"><@spring.message code="login.login" /></button>
            <label class="checkbox">
                <!--<input type="checkbox" value="remember-me"> 记住我-->
            </label>
        </form>
        <div class="form-signin"><@spring.message code="login.copy.right" /></div>
    </div>
<#--<alert-msg></alert-msg>-->
</div>
</body>
<script src="${basePath}/js/module/login/login.js"></script>
</html>
