<#import "/spring.ftl" as spring/>
<#assign basePath=request.contextPath />
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->
<!-- REQUIRED JS SCRIPTS -->

<!-- jQuery 3 -->
<script src="${basePath}/adminLTE/bower_components/jquery/dist/jquery.min.js"></script>
<#--<script src="https://cdn.bootcss.com/jquery-validate/1.17.0/jquery.validate.min.js"></script>-->
<#--jquery 验证-->
<script src="${basePath}/js/validate/jquery.validate.min.js"></script>
<script src="${basePath}/js/validate/validate_local.js"></script>
<script src="${basePath}/js/validate/jquery.metadata.js"></script>

<!-- Bootstrap 3.3.7 -->
<script src="${basePath}/adminLTE/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="${basePath}/adminLTE/dist/js/adminlte.min.js"></script>
<!-- Google Font -->
<link rel="stylesheet"
      href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
<link rel="stylesheet" href="${basePath}/adminLTE/bower_components/bootstrap/dist/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet" href="${basePath}/adminLTE/bower_components/font-awesome/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet" href="${basePath}/adminLTE/bower_components/Ionicons/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="${basePath}/adminLTE/dist/css/AdminLTE.min.css">
<!-- AdminLTE Skins. We have chosen the skin-blue for this starter
      page. However, you can choose any other skin. Make sure you
      apply the skin class to the body tag so the changes take effect. -->
<link rel="stylesheet" href="${basePath}/adminLTE/dist/css/skins/skin-blue.min.css">
<#--动态标签页-->
<script src="${basePath}/js/base/closable-tab-div.js"></script>
<#--<script src="https://cdn.bootcss.com/toastr.js/2.1.4/toastr.min.js"></script>-->
<script src="${basePath}/js/base/toastr.min.js"></script>
<#--<link href="https://cdn.bootcss.com/toastr.js/2.1.4/toastr.min.css" rel="stylesheet">-->
<link href="${basePath}/css/base/toastr.min.css" rel="stylesheet">
<#--<script src="https://cdn.bootcss.com/vue/2.5.13/vue.min.js"></script>-->
<script src="${basePath}/js/base/vue.min.js"></script>

<#--ladda按钮加载样式，api：http://www.htmleaf.com/jQuery/Buttons-Icons/201506232089.html-->
<link rel="stylesheet" href="${basePath}/css/base/ladda-themeless.min.css">
<script src="${basePath}/js/base/spin.min.js"></script>
<script src="${basePath}/js/base/ladda.min.js"></script>

<#--自定义js-->
<script src="${basePath}/js/base/main.js"></script>


<style type="text/css">
    /*渲染完成vue组件前不展示元素{{}}，在vue渲染元素内标记 v-cloak即可*/
    [v-cloak] {
        display: none;
    }
</style>
