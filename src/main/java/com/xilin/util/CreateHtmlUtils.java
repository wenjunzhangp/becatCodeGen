package com.xilin.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright:   becat代码生成器
 * freemarker生成分页列表和js
 *
 * @author: zhangwenjun
 * @version: V1.0
 * @Date: 2018-11-02 17:43
 */
public class CreateHtmlUtils {

    /**
     * 通过freemarker生成静态HTML页面
     *
     * @param templateName        模版名称
     * @param targetFileName 模版生成后的文件名
     * @param map            freemarker生成的数据都存储在MAP中，
     * @创建时间：2017年10月22日21:41:06
     */
    public static void createHtml(String templateName, String targetFileName, Map<String, Object> map) throws Exception {
        //创建fm的配置
        Configuration config = new Configuration(Configuration.VERSION_2_3_28);
        //指定默认编码格式
        config.setDefaultEncoding("UTF-8");
        config.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);
        //设置模版文件的路径
        config.setClassForTemplateLoading(CreateHtmlUtils.class, "/template");
        //获得模版包
        Template template = config.getTemplate(templateName);
        //从参数文件中获取指定输出路径 ,路径示例：C:/Workspace/shop-test/src/main/webapp/html
        //定义输出流，注意必须指定编码
        Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("" + "/" + targetFileName)), "UTF-8"));
        //生成模版
        template.process(map, writer);
        writer.close();
    }

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("hello", "。。。。。。");
        try {
            CreateHtmlUtils.createHtml("service.ftl", "abc.html", map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
