/*
    Copyright becat代码生成器
    author zhangwenjun
    version V1.0
    date 2019-03-28 15:21:00
*/
layui.use(['form','layer','table'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        table = layui.table;

    var tableIns = table.render({
        id : "id",
        elem: '#XlUserList',
        url : '/xlUser/pageList.shtml',
        cellMinWidth : 95,
        page : true,
        height : "full-125",
        limits : [10,15,20,25],
        limit : 10,
        id : "XlUserList",
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
                                {field: 'user_id', title: '员工id（主键）', minWidth:100, align:"center"},
                                {field: 'user_fullname', title: '员工账号', minWidth:100, align:"center"},
                                {field: 'user_password', title: '登录密码', minWidth:100, align:"center"},
                                {field: 'user_phone', title: '手机', minWidth:100, align:"center"},
                                {field: 'role_id', title: '职位', minWidth:100, align:"center"},
                                {field: 'user_isdisabled', title: '停用', minWidth:100, align:"center"},
                                {field: 'user_salt', title: '盐', minWidth:100, align:"center"},
                                {field: 'user_isdeleted', title: '删除', minWidth:100, align:"center"},
                                {field: 'user_lastlogintime', title: '最后登录时间', minWidth:100, align:"center"},
                                {field: 'store_id', title: '所属店铺', minWidth:100, align:"center"},
                                {field: 'recommend_assid', title: '???id', minWidth:100, align:"center"},
            {title: '操作', minWidth:150, templet:'#XlUserListBar',fixed:"right",align:"center"}
        ]]
    });

    $(".search_btn").on("click",function(){
        table.reload("XlUserList",{
            page: {
                curr: 1
            },
            where: {
                //多条件查询 向后台传递查询参数
                filter : $(".searchVal").val()
            }
        })
    });

    $(".add_btn").click(function(){
        addIndus();
    });

    function addIndus(edit){
        var index = layui.layer.open({
            title : "操作XlUser窗口",
            type : 2,
            content : "/xlUser/addOrUpdate.shtml",
            success : function(layero, index){
                var body = layui.layer.getChildFrame('body', index);
                if(edit){
                    body.find(".idval").val(edit.id);
                            body.find(".user_id").val(edit.user_id);
                            body.find(".user_fullname").val(edit.user_fullname);
                            body.find(".user_password").val(edit.user_password);
                            body.find(".user_phone").val(edit.user_phone);
                            body.find(".role_id").val(edit.role_id);
                            body.find(".user_isdisabled").val(edit.user_isdisabled);
                            body.find(".user_salt").val(edit.user_salt);
                            body.find(".user_isdeleted").val(edit.user_isdeleted);
                            body.find(".user_lastlogintime").val(edit.user_lastlogintime);
                            body.find(".store_id").val(edit.store_id);
                            body.find(".recommend_assid").val(edit.recommend_assid);
                    form.render();
                }
                setTimeout(function(){
                    layui.layer.tips('点击此处返回XlUser列表', '.layui-layer-setwin .layui-layer-close', {
                        tips: 3
                    });
                },500)
            }
        })
        layui.layer.full(index);
        //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
        $(window).on("resize",function(){
            layui.layer.full(index);
        })
    }

    $(".del_btn").click(function(){
        var checkStatus = table.checkStatus('XlUserList'),
            data = checkStatus.data,
            newsId = [];
        if(data.length > 0) {
            for (var i in data) {
                newsId.push(data[i].id);
            }
            layer.confirm('确定删除选中的数据？', {icon: 3, title: '温馨提示'}, function (index) {
                $.ajax({
                    url : "/xlUser/delete.shtml",
                    type : "post",
                    data: {ids:newsId.toString()},
                    dataType : "json",
                    success : function(data){
                        if(data.success){
                            layer.msg(data.msg);
                            layer.close(index);
                            tableIns.reload();
                        }else{
                            layer.msg(data.msg);
                        }
                    }
                })
            })
        }else{
            layer.msg("请选择需要删除的数据");
        }
    });

    table.on('tool(XlUserList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;

        if(layEvent === 'edit'){
            addIndus(data);
        } else if(layEvent === 'del'){
            layer.confirm('确定删除此条数据？',{icon:3, title:'温馨提示'},function(index){
                $.ajax({
                    url : "/xlUser/delete.shtml",
                    type : "post",
                    data: {ids:data.id},
                    dataType : "json",
                    success : function(data){
                        if(data.success){
                            layer.msg(data.msg);
                            layer.close(index);
                            tableIns.reload();
                        }else{
                            layer.msg(data.msg);
                        }
                    }
                })
            });
        }
    });

})