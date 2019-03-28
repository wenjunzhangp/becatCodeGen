layui.use(['form','layer'],function(){
    var form = layui.form
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery;

    var requestUrl = "${addurl}";
    if (!isEmpty($(".idval").val())) {
        requestUrl = "${updateurl}";
    }

    //添加自定义表单验证规则
    <#--form.verify({
        blogCategory: function (value, item) {
            if (value == -1) {
                return "不要忘记选博客分类";
            }
        }
    })-->

    form.on("submit(${tablename}modify)",function(data){
        var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
        $.ajax({
            url : requestUrl,
            type : "post",
            data:$(".${tablename}Form").serialize(),
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