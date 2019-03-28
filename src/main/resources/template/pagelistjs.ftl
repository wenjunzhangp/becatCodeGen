/*
    Copyright ${company}
    author ${author}
    version V1.0
    date ${date}
*/
layui.use(['form','layer','table'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        table = layui.table;

    var tableIns = table.render({
        id : "id",
        elem: '#${tablename}List',
        url : '${requesturl}',
        cellMinWidth : 95,
        page : true,
        height : "full-125",
        limits : [10,15,20,25],
        limit : 10,
        id : "${tablename}List",
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
            <#list columnlist as map>
                <#list map?keys as itemKey>
                                {field: '${itemKey}', title: '${map[itemKey]}', minWidth:100, align:"center"},
                </#list>
            </#list>
            {title: '操作', minWidth:150, templet:'#${tablename}ListBar',fixed:"right",align:"center"}
            <#-- 如果碰到需要格式化的列，你这么处理 举个栗子：
                {field: 'type', title: '类型', align:'center',minWidth:100,templet:function(d){
                if(d.type == "0"){
                    return "未知来源";
                }else if(d.type == "1"){
                    return "原创";
                }else if(d.type == "2"){
                    return "转载";
                }else{
                    return "未知来源";
                }
            }},
             -->
        ]]
    });

    $(".search_btn").on("click",function(){
        table.reload("${tablename}List",{
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
            title : "操作${tablename}窗口",
            type : 2,
            content : "${modifyurl}",
            success : function(layero, index){
                var body = layui.layer.getChildFrame('body', index);
                if(edit){
                    body.find(".idval").val(edit.id);
                    <#list columnlist as map>
                        <#list map?keys as itemKey>
                            body.find(".${itemKey}").val(edit.${itemKey});
                        </#list>
                    </#list>
                <#-- 下列几种常见的情况
                    1.碰到多文本框或者富文本编辑器填充内容 那么你这么处理 举个栗子：
                       body.find(".content").text(edit.content);
                    2.碰到单选多选按钮 那么你这么处理 举个栗子：
                        body.find(".type input[value="+edit.type+"]").prop("checked","checked");
                        body.find(".stick input[value="+edit.stick+"]").prop("checked","checked");
                 -->
                    form.render();
                }
                setTimeout(function(){
                    layui.layer.tips('点击此处返回${tablename}列表', '.layui-layer-setwin .layui-layer-close', {
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
        var checkStatus = table.checkStatus('${tablename}List'),
            data = checkStatus.data,
            newsId = [];
        if(data.length > 0) {
            for (var i in data) {
                newsId.push(data[i].id);
            }
            layer.confirm('确定删除选中的数据？', {icon: 3, title: '温馨提示'}, function (index) {
                $.ajax({
                    url : "${deleteurl}",
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

    table.on('tool(${tablename}List)', function(obj){
        var layEvent = obj.event,
            data = obj.data;

        if(layEvent === 'edit'){
            addIndus(data);
        } else if(layEvent === 'del'){
            layer.confirm('确定删除此条数据？',{icon:3, title:'温馨提示'},function(index){
                $.ajax({
                    url : "${deleteurl}",
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