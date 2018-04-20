[#include "common/head.ftl"/]
<body class="hold-transition skin-blue sidebar-mini">
[#include "common/base/baseJSAttribute.ftl"/]
<div class="wrapper">
[#include "common/top.ftl"/]
[#include "common/left.ftl"/]
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        [#--<section class="content-header">
            <h1>
                欢迎来到sbs 中间件平台
                <small>请在左侧菜单选取你想要查看的功能吧！</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="${basePath}"><i class="fa fa-dashboard"></i>主页</a></li>
                <li class="active">当前位置</li>
            </ol>
        </section>--]
        <!-- 主要内容区域 -->
        <section class="content container-fluid">
            <div class="col-md-12">
                <!-- 此处是相关代码 -->
                <ul class="nav nav-tabs" role="tablist">
                </ul>
                <div class="tab-content" style="width:100%;">

                </div>
                <!-- 相关代码结束 -->
            </div>
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

[#include "common/bottom.ftl"/]
    <script type="text/javascript">
        //tab窗口
        $(function () {
            var item = {'id': 'a', 'name': '首页', 'url': 'son.html', 'closable': false};
            closableTab.addTab(item);

            $(".sidebar-menu .show-tab").click(function () {
                var id = $(this).attr("id");
                var name = $(this).data("name");
                var url = $(this).data("url");
                //是否能关闭
                var closable = $(this).data("closable");
                var item = {'id': id, 'name': name, 'url': url, 'closable': closable == 1 ? true : false};
                if ($("i[tabclose='tab_seed_" + id + "']").length > 0) {
                    closableTab.closeTab($("i[tabclose='tab_seed_" + id + "']")[0]);
                }
                closableTab.addTab(item);
            });
        });
    </script>