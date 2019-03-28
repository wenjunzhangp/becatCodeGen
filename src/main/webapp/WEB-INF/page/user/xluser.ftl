<!-- Copyright becat代码生成器 -->
<!-- author zhangwenjun -->
<!-- version V1.0 -->
<!-- date 2019-03-28 15:21:00 -->
<link rel="stylesheet" type="text/css" href="/resource/plugin/layui/css/layui.css" media="all">
<form class="layui-form">
    <blockquote class="layui-elem-quote quoteBox">
        <form class="layui-form">
            <div class="layui-inline">
                <div class="layui-input-inline">
                    <input type="text" class="layui-input searchVal" placeholder="请输入查询条件"/>
                </div>
                <a class="layui-btn search_btn" data-type="reload">搜索</a>
            </div>
            <div class="layui-inline">
                <a class="layui-btn layui-btn-normal add_btn">添加</a>
            </div>
            <div class="layui-inline">
                <a class="layui-btn layui-btn-danger layui-btn-normal del_btn">批量删除</a>
            </div>
        </form>
    </blockquote>
    <table id="XlUserList" lay-filter="XlUserList"></table>

    <!--操作-->
    <script type="text/html" id="XlUserListBar">
        <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
        <a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="del">删除</a>
    </script>
</form>
<script type="text/javascript" src="/resource/plugin/layui/layui.js"></script>
<script type="text/javascript" src="/resource/js/user/xluser.js"></script>