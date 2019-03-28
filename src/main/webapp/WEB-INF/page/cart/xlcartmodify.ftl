<!-- Copyright becat代码生成器 -->
<!-- author zhangwenjun -->
<!-- version V1.0 -->
<!-- date 2019-03-28 15:21:00 -->
<link rel="stylesheet" type="text/css" href="/resource/plugin/layui/css/layui.css" media="all">
<form class="layui-form layui-row XlCartForm">
    <div class="layui-col-md12 layui-col-xs12">

                         <input type="hidden" class="idval" name="cartId" value="">
                        <div class="layui-form-item layui-row layui-col-xs12">
                            <label class="layui-form-label">商品skuid</label>
                            <div class="layui-input-block">
                                <input type="text" class="layui-input cart_skuid" name="cartSkuid" lay-verify="required" placeholder="请输入内容商品skuid">
                            </div>
                        </div>
                        <div class="layui-form-item layui-row layui-col-xs12">
                            <label class="layui-form-label">商品名称</label>
                            <div class="layui-input-block">
                                <input type="text" class="layui-input cart_goodsname" name="cartGoodsname" lay-verify="required" placeholder="请输入内容商品名称">
                            </div>
                        </div>
                        <div class="layui-form-item layui-row layui-col-xs12">
                            <label class="layui-form-label">商品价格</label>
                            <div class="layui-input-block">
                                <input type="text" class="layui-input cart_goodsprice" name="cartGoodsprice" lay-verify="required" placeholder="请输入内容商品价格">
                            </div>
                        </div>
                        <div class="layui-form-item layui-row layui-col-xs12">
                            <label class="layui-form-label">购买数量</label>
                            <div class="layui-input-block">
                                <input type="text" class="layui-input cart_count" name="cartCount" lay-verify="required" placeholder="请输入内容购买数量">
                            </div>
                        </div>
                        <div class="layui-form-item layui-row layui-col-xs12">
                            <label class="layui-form-label">加入购物车时间</label>
                            <div class="layui-input-block">
                                <input type="text" class="layui-input cart_addtime" name="cartAddtime" lay-verify="required" placeholder="请输入内容加入购物车时间">
                            </div>
                        </div>
                        <div class="layui-form-item layui-row layui-col-xs12">
                            <label class="layui-form-label">小计金额</label>
                            <div class="layui-input-block">
                                <input type="text" class="layui-input cart_totalprice" name="cartTotalprice" lay-verify="required" placeholder="请输入内容小计金额">
                            </div>
                        </div>
                        <div class="layui-form-item layui-row layui-col-xs12">
                            <label class="layui-form-label">商品图片链接</label>
                            <div class="layui-input-block">
                                <input type="text" class="layui-input cart_goodsicon" name="cartGoodsicon" lay-verify="required" placeholder="请输入内容商品图片链接">
                            </div>
                        </div>
                        <div class="layui-form-item layui-row layui-col-xs12">
                            <label class="layui-form-label">商品sku详情</label>
                            <div class="layui-input-block">
                                <input type="text" class="layui-input cart_skuproduct" name="cartSkuproduct" lay-verify="required" placeholder="请输入内容商品sku详情">
                            </div>
                        </div>
                        <div class="layui-form-item layui-row layui-col-xs12">
                            <label class="layui-form-label">商品详情页链接</label>
                            <div class="layui-input-block">
                                <input type="text" class="layui-input cart_detailurl" name="cartDetailurl" lay-verify="required" placeholder="请输入内容商品详情页链接">
                            </div>
                        </div>
                        <div class="layui-form-item layui-row layui-col-xs12">
                            <label class="layui-form-label">所属用户ID</label>
                            <div class="layui-input-block">
                                <input type="text" class="layui-input cart_assid" name="cartAssid" lay-verify="required" placeholder="请输入内容所属用户ID">
                            </div>
                        </div>
                        <div class="layui-form-item layui-row layui-col-xs12">
                            <label class="layui-form-label">运费</label>
                            <div class="layui-input-block">
                                <input type="text" class="layui-input cart_freight" name="cartFreight" lay-verify="required" placeholder="请输入内容运费">
                            </div>
                        </div>

        <div class="layui-form-item layui-row layui-col-xs12">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit="" lay-filter="XlCartmodify">发布</button>
                <button type="reset" class="layui-btn layui-btn-primary">取消</button>
            </div>
        </div>
    </div>
</form>
<script type="text/javascript" src="/resource/plugin/layui/layui.js"></script>
<script type="text/javascript" src="/resource/js/cart/xlcartmodify.js"></script>