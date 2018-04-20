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