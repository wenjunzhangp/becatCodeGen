<!-- Copyright becat代码生成器 -->
<!-- author zhangwenjun -->
<!-- version V1.0 -->
<!-- date 2019-03-28 15:21:00 -->
<link rel="stylesheet" type="text/css" href="/resource/plugin/layui/css/layui.css" media="all">
<form class="layui-form layui-row XlRoleForm">
    <div class="layui-col-md12 layui-col-xs12">

                         <input type="hidden" class="idval" name="roleId" value="">
                        <div class="layui-form-item layui-row layui-col-xs12">
                            <label class="layui-form-label">职位名称</label>
                            <div class="layui-input-block">
                                <input type="text" class="layui-input role_name" name="roleName" lay-verify="required" placeholder="请输入内容职位名称">
                            </div>
                        </div>
                        <div class="layui-form-item layui-row layui-col-xs12">
                            <label class="layui-form-label">是否删除</label>
                            <div class="layui-input-block">
                                <input type="text" class="layui-input role_isdeleted" name="roleIsdeleted" lay-verify="required" placeholder="请输入内容是否删除">
                            </div>
                        </div>
                        <div class="layui-form-item layui-row layui-col-xs12">
                            <label class="layui-form-label">所属店铺</label>
                            <div class="layui-input-block">
                                <input type="text" class="layui-input store_id" name="storeId" lay-verify="required" placeholder="请输入内容所属店铺">
                            </div>
                        </div>

        <div class="layui-form-item layui-row layui-col-xs12">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit="" lay-filter="XlRolemodify">发布</button>
                <button type="reset" class="layui-btn layui-btn-primary">取消</button>
            </div>
        </div>
    </div>
</form>
<script type="text/javascript" src="/resource/plugin/layui/layui.js"></script>
<script type="text/javascript" src="/resource/js/role/xlrolemodify.js"></script>