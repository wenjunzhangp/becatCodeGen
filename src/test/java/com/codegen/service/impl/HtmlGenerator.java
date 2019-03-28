package com.codegen.service.impl;

import com.codegen.service.CodeGenerator;
import com.codegen.service.CodeGeneratorManager;
import com.codegen.util.StringUtils;
import com.xilin.util.JDBCUtil;
import freemarker.template.Configuration;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright:   西邻在线电子商务
 *
 * @author: zhangwenjun
 * @version: V1.0
 * @Date: 2019-03-15 14:17
 */
public class HtmlGenerator extends CodeGeneratorManager implements CodeGenerator {

    /**
     * html代码生成主要逻辑
     *
     * @param tableName 生成的表名
     * @param sign
     */
    @Override
    public void genCode(String tableName, String modelName, String sign) {
        Configuration cfg = getFreemarkerConfiguration();
        String[] strArray = tableName.split(",");
        for (String str : strArray) {
            String customMapping = "/" + getSign(str) + "/";
            String modelNameUpperCamel = StringUtils.isNullOrEmpty(modelName) ? tableNameConvertUpperCamel(str) : modelName;
            //生成pagelist页
            Map<String, Object> data = getDataMapInit(str,modelNameUpperCamel);
            try {
                File htmlFile = new File(PROJECT_PATH + PAGELIST_FILE_PATH +customMapping+ tableNameConvertLowerCamel(modelNameUpperCamel) + ".ftl");
                if (!htmlFile.getParentFile().exists()) {
                    htmlFile.getParentFile().mkdirs();
                }
                cfg.getTemplate("pagelist.ftl").process(data, new FileWriter(htmlFile));
                logger.info(tableNameConvertLowerCamel(modelNameUpperCamel) + ".ftl 生成成功!");
            } catch (Exception e) {
                throw new RuntimeException("ftl 生成失败!", e);
            }
            //生成pagemodify页
            Map<String, Object> datamodify = getDataMapInitModify(str,modelNameUpperCamel);
            try {
                File htmlFile = new File(PROJECT_PATH + PAGELIST_FILE_PATH +customMapping+ tableNameConvertLowerCamel(modelNameUpperCamel) + "modify.ftl");
                if (!htmlFile.getParentFile().exists()) {
                    htmlFile.getParentFile().mkdirs();
                }
                cfg.getTemplate("pagemodify.ftl").process(datamodify, new FileWriter(htmlFile));
                logger.info(tableNameConvertLowerCamel(modelNameUpperCamel) + "modify.ftl 生成成功!");
            } catch (Exception e) {
                throw new RuntimeException("ftl 生成失败!", e);
            }
        }
    }

    /**
     * 预置页面所需数据
     *
     * @param tableName           表名
     * @param modelNameUpperCamel 首字为大写的实体类名
     * @return
     */
    private Map<String, Object> getDataMapInit(String tableName,String modelNameUpperCamel) {
        Map<String, Object> data = new HashMap<String,Object>(16);
        data.put("date", DATE);
        data.put("author", AUTHOR);
        data.put("company", SIGN);
        data.put("tablename", modelNameUpperCamel);
        data.put("lowername", tableNameConvertLowerCamel(modelNameUpperCamel));
        data.put("jsresource", getSign(tableName));
        return data;
    }

    /**
     * 预置页面所需数据
     *
     * @param tableName           表名
     * @param modelNameUpperCamel 首字为大写的实体类名
     * @return
     */
    private Map<String, Object> getDataMapInitModify(String tableName,String modelNameUpperCamel) {
        Map<String, Object> data = new HashMap<String,Object>(16);
        data.put("date", DATE);
        data.put("author", AUTHOR);
        data.put("company", SIGN);
        data.put("tablename", modelNameUpperCamel);
        data.put("lowername", tableNameConvertLowerCamel(modelNameUpperCamel));
        data.put("jsresource", "/"+getSign(tableName)+"/"+tableNameConvertLowerCamel(modelNameUpperCamel)+"modify.js");
        List<Map<String,Object>> columnList = JDBCUtil.executeQuery("select COLUMN_NAME,column_comment from information_schema.COLUMNS where table_name = '"+tableName+"'");
        List<Map<String,Object>> result = JDBCUtil.handleData(columnList);
        data.put("columnlist", result);
        return data;
    }
}
