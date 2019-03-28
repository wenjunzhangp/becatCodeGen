package com.codegen.main;


import com.codegen.service.CodeGeneratorManager;
import com.codegen.service.impl.HtmlGenerator;
import com.codegen.service.impl.JsGenerator;

import java.io.InputStream;
import java.util.Properties;

/**
 * Copyright:   西邻在线
 * 代码生成器启动项
 *
 * @author: zhangwenjun
 * @version: V1.0
 * @Date: 2018-10-19 10:42
 */
public class CodeGeneratorMain {

    /**
     * 加载配置文件
     *
     * @return
     */
    private static Properties loadProperties() {
        Properties prop = null;
        try {
            prop = new Properties();
            InputStream in = CodeGeneratorManager.class.getClassLoader().getResourceAsStream("generatorConfig.properties");
            prop.load(in);
        } catch (Exception e) {
            throw new RuntimeException("加载配置文件异常!", e);
        }
        return prop;
    }

    /**
     * 说明:
     * 以表名 gen_test_demo 为例子, 主要是以下几种情况:
     * 1. gen_test_demo ==> Demo 可以传入多表
     * genCodeWithSimpleName("gen_test_demo");
     * <p>
     * 2. gen_test_demo ==> GenTestDemo 可以传入多表
     * genCodeWithDetailName("gen_test_demo");
     * <p>
     * 3. gen_test_demo ==> IDemo 自定义名称
     * genCodeWithCustomName("gen_test_demo", "IDemo");
     */
    public static void main(String[] args) {
        CodeGeneratorManager cgm = new CodeGeneratorManager();
        Properties prop = loadProperties();

        //生成后台Java文件(xml dao service serviceimpl controller)
        cgm.genCodeWithDetailName(prop.getProperty("table-name"));
        //cgm.genCodeWithSimpleName(prop.getProperty("table-name"));
        //cgm.genCodeWithCustomName(prop.getProperty("table-name"), prop.getProperty("model_name"));

        //生成前端文件(html js)
        new HtmlGenerator().genCode(prop.getProperty("table-name"),"","");
        new JsGenerator().genCode(prop.getProperty("table-name"),"","");

        System.out.println("==========================================");
        System.out.println("Github地址:[https://github.com/wenjunzhangp]");
        System.out.println("互联网沉浮中的一枚程序猿-包子");
        System.out.println("版本：V1.0 后续会持续更新,增加更强大的功能");
        System.out.println("如果觉得代码生成器好用，请不要吝啬你的小星星，帮我点点star  thanks~~");
        System.out.println("==========================================");
    }

}
