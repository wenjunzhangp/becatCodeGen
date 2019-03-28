layui.use(['form','layer'],function(){
    var form = layui.form
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery;

    var requestUrl = "/xlUser/add.shtml";
    if (!isEmpty($(".idval").val())) {
        requestUrl = "/xlUser/update.shtml";
    }

    //添加自定义表单验证规则

    form.on("submit(XlUsermodify)",function(data){
        var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
        $.ajax({
            url : requestUrl,
            type : "post",
            data:$(".XlUserForm").serialize(),
            dataType : "json",
            success : function(data){
                if(data.success){
                    top.layer.close(index);
                    top.layer.msg("操作成功！");
                    setTimeout(function () {
                        parent.location.reload();
                    }, 2000);
                }else{
                    layer.msg(data.msg);
                }
            }
        })
        return false;
    })

})
//判断字符是否为空的方法
function isEmpty(obj){
    if(typeof obj == "undefined" || obj == null || obj == ""){
        return true;
    }else{
        return false;
    }
}