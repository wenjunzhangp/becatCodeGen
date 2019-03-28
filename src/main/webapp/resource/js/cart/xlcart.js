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
        elem: '#XlCartList',
        url : '/xlCart/pageList.shtml',
        cellMinWidth : 95,
        page : true,
        height : "full-125",
        limits : [10,15,20,25],
        limit : 10,
        id : "XlCartList",
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
                                {field: 'cart_id', title: '主键ID', minWidth:100, align:"center"},
                                {field: 'cart_skuid', title: '商品skuid', minWidth:100, align:"center"},
                                {field: 'cart_goodsname', title: '商品名称', minWidth:100, align:"center"},
                                {field: 'cart_goodsprice', title: '商品价格', minWidth:100, align:"center"},
                                {field: 'cart_count', title: '购买数量', minWidth:100, align:"center"},
                                {field: 'cart_addtime', title: '加入购物车时间', minWidth:100, align:"center"},
                                {field: 'cart_totalprice', title: '小计金额', minWidth:100, align:"center"},
                                {field: 'cart_goodsicon', title: '商品图片链接', minWidth:100, align:"center"},
                                {field: 'cart_skuproduct', title: '商品sku详情', minWidth:100, align:"center"},
                                {field: 'cart_detailurl', title: '商品详情页链接', minWidth:100, align:"center"},
                                {field: 'cart_assid', title: '所属用户ID', minWidth:100, align:"center"},
                                {field: 'cart_freight', title: '运费', minWidth:100, align:"center"},
            {title: '操作', minWidth:150, templet:'#XlCartListBar',fixed:"right",align:"center"}
        ]]
    });

    $(".search_btn").on("click",function(){
        table.reload("XlCartList",{
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
            title : "操作XlCart窗口",
            type : 2,
            content : "/xlCart/addOrUpdate.shtml",
            success : function(layero, index){
                var body = layui.layer.getChildFrame('body', index);
                if(edit){
                    body.find(".idval").val(edit.id);
                            body.find(".cart_id").val(edit.cart_id);
                            body.find(".cart_skuid").val(edit.cart_skuid);
                            body.find(".cart_goodsname").val(edit.cart_goodsname);
                            body.find(".cart_goodsprice").val(edit.cart_goodsprice);
                            body.find(".cart_count").val(edit.cart_count);
                            body.find(".cart_addtime").val(edit.cart_addtime);
                            body.find(".cart_totalprice").val(edit.cart_totalprice);
                            body.find(".cart_goodsicon").val(edit.cart_goodsicon);
                            body.find(".cart_skuproduct").val(edit.cart_skuproduct);
                            body.find(".cart_detailurl").val(edit.cart_detailurl);
                            body.find(".cart_assid").val(edit.cart_assid);
                            body.find(".cart_freight").val(edit.cart_freight);
                    form.render();
                }
                setTimeout(function(){
                    layui.layer.tips('点击此处返回XlCart列表', '.layui-layer-setwin .layui-layer-close', {
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
        var checkStatus = table.checkStatus('XlCartList'),
            data = checkStatus.data,
            newsId = [];
        if(data.length > 0) {
            for (var i in data) {
                newsId.push(data[i].id);
            }
            layer.confirm('确定删除选中的数据？', {icon: 3, title: '温馨提示'}, function (index) {
                $.ajax({
                    url : "/xlCart/delete.shtml",
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

    table.on('tool(XlCartList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;

        if(layEvent === 'edit'){
            addIndus(data);
        } else if(layEvent === 'del'){
            layer.confirm('确定删除此条数据？',{icon:3, title:'温馨提示'},function(index){
                $.ajax({
                    url : "/xlCart/delete.shtml",
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