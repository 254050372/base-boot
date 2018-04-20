[#--公共参数存放--]
[#if Session["user"]??]
    [#assign user=Session["user"] /]
[/#if]
[#--静态资源版本号--]
[#if Session["staticVersion"]??]
    [#assign staticVersion=Session["staticVersion"] /]
[/#if]
[#assign basePath=request.contextPath /]
[#assign baseResourcePath=basePath+springMacroRequestContext.getWebApplicationContext().getEnvironment().getProperty("local.static-path-pattern") /]

[#--公共宏定义存放--]
[#macro jsImport path isExternal=false]
    [#if (isExternal)??&&isExternal]
        <script src="${path}?ver=${staticVersion!}"></script>
    [#else]
        <script src="${baseResourcePath}${path}?ver=${staticVersion!}"></script>
    [/#if]
[/#macro]
[#macro cssImport path isExternal=false]
    [#if (isExternal)??&&isExternal]
        <link rel="stylesheet" href="${path}?ver=${staticVersion!}">
    [#else]
        <link rel="stylesheet" href="${baseResourcePath}${path}?ver=${staticVersion!}">
    [/#if]
[/#macro]