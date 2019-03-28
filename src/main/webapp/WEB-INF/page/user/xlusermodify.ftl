<!-- Copyright becat代码生成器 -->
<!-- author zhangwenjun -->
<!-- version V1.0 -->
<!-- date 2019-03-28 15:21:00 -->
<link rel="stylesheet" type="text/css" href="/resource/plugin/layui/css/layui.css" media="all">
<form class="layui-form layui-row XlUserForm">
    <div class="layui-col-md12 layui-col-xs12">

                         <input type="hidden" class="idval" name="userId" value="">
                        <div class="layui-form-item layui-row layui-col-xs12">
                            <label class="layui-form-label">员工账号</label>
                            <div class="layui-input-block">
                                <input type="text" class="layui-input user_fullname" name="userFullname" lay-verify="required" placeholder="请输入内容员工账号">
                            </div>
                        </div>
                        <div class="layui-form-item layui-row layui-col-xs12">
                            <label class="layui-form-label">登录密码</label>
                            <div class="layui-input-block">
                                <input type="text" class="layui-input user_password" name="userPassword" lay-verify="required" placeholder="请输入内容登录密码">
                            </div>
                        </div>
                        <div class="layui-form-item layui-row layui-col-xs12">
                            <label class="layui-form-label">手机</label>
                            <div class="layui-input-block">
                                <input type="text" class="layui-input user_phone" name="userPhone" lay-verify="required" placeholder="请输入内容手机">
                            </div>
                        </div>
                        <div class="layui-form-item layui-row layui-col-xs12">
                            <label class="layui-form-label">职位</label>
                            <div class="layui-input-block">
                                <input type="text" class="layui-input role_id" name="roleId" lay-verify="required" placeholder="请输入内容职位">
                            </div>
                        </div>
                        <div class="layui-form-item layui-row layui-col-xs12">
                            <label class="layui-form-label">停用</label>
                            <div class="layui-input-block">
                                <input type="text" class="layui-input user_isdisabled" name="userIsdisabled" lay-verify="required" placeholder="请输入内容停用">
                            </div>
                        </div>
                        <div class="layui-form-item layui-row layui-col-xs12">
                            <label class="layui-form-label">盐</label>
                            <div class="layui-input-block">
                                <input type="text" class="layui-input user_salt" name="userSalt" lay-verify="required" placeholder="请输入内容盐">
                            </div>
                        </div>
                        <div class="layui-form-item layui-row layui-col-xs12">
                            <label class="layui-form-label">删除</label>
                            <div class="layui-input-block">
                                <input type="text" class="layui-input user_isdeleted" name="userIsdeleted" lay-verify="required" placeholder="请输入内容删除">
                            </div>
                        </div>
                        <div class="layui-form-item layui-row layui-col-xs12">
                            <label class="layui-form-label">最后登录时间</label>
                            <div class="layui-input-block">
                                <input type="text" class="layui-input user_lastlogintime" name="userLastlogintime" lay-verify="required" placeholder="请输入内容最后登录时间">
                            </div>
                        </div>
                        <div class="layui-form-item layui-row layui-col-xs12">
                            <label class="layui-form-label">所属店铺</label>
                            <div class="layui-input-block">
                                <input type="text" class="layui-input store_id" name="storeId" lay-verify="required" placeholder="请输入内容所属店铺">
                            </div>
                        </div>
                        <div class="layui-form-item layui-row layui-col-xs12">
                            <label class="layui-form-label">???id</label>
                            <div class="layui-input-block">
                                <input type="text" class="layui-input recommend_assid" name="recommendAssid" lay-verify="required" placeholder="请输入内容???id">
                            </div>
                        </div>

        <div class="layui-form-item layui-row layui-col-xs12">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit="" lay-filter="XlUsermodify">发布</button>
                <button type="reset" class="layui-btn layui-btn-primary">取消</button>
            </div>
        </div>
    </div>
</form>
<script type="text/javascript" src="/resource/plugin/layui/layui.js"></script>
<script type="text/javascript" src="/resource/js/user/xlusermodify.js"></script>