<!-- Copyright ${company} -->
<!-- author ${author} -->
<!-- version V1.0 -->
<!-- date ${date} -->
<link rel="stylesheet" type="text/css" href="/resource/plugin/layui/css/layui.css" media="all">
<form class="layui-form layui-row ${tablename}Form">
    <div class="layui-col-md12 layui-col-xs12">

         <#if columnlist?exists>
             <#list columnlist as map>
                 <#list map?keys as itemKey>
                     <#if map_index = 0>
                         <input type="hidden" class="idval" name="${itemKey?replace(itemKey?substring(itemKey?index_of("_"),itemKey?index_of("_")+2),itemKey?substring(itemKey?index_of("_"),itemKey?index_of("_")+2)?upper_case)?replace("_","")}" value="">
                     <#else>
                        <div class="layui-form-item layui-row layui-col-xs12">
                            <label class="layui-form-label">${map[itemKey]}</label>
                            <div class="layui-input-block">
                                <input type="text" class="layui-input ${itemKey}" name="${itemKey?replace(itemKey?substring(itemKey?index_of("_"),itemKey?index_of("_")+2),itemKey?substring(itemKey?index_of("_"),itemKey?index_of("_")+2)?upper_case)?replace("_","")}" lay-verify="required" placeholder="请输入内容${map[itemKey]}">
                            </div>
                        </div>
                     </#if>
                 </#list>
             </#list>
         </#if>

        <div class="layui-form-item layui-row layui-col-xs12">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit="" lay-filter="${tablename}modify">发布</button>
                <button type="reset" class="layui-btn layui-btn-primary">取消</button>
            </div>
        </div>
    </div>
</form>
<script type="text/javascript" src="/resource/plugin/layui/layui.js"></script>
<script type="text/javascript" src="/resource/js${jsresource}"></script>