package com.codegen.service.impl;

import com.codegen.service.CodeGenerator;
import com.codegen.service.CodeGeneratorManager;
import com.codegen.util.StringUtils;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.config.GeneratedKey;
import org.mybatis.generator.config.JavaClientGeneratorConfiguration;
import org.mybatis.generator.config.JavaModelGeneratorConfiguration;
import org.mybatis.generator.config.SqlMapGeneratorConfiguration;
import org.mybatis.generator.config.TableConfiguration;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright:   西邻在线
 * Model & Mapper 代码生成器
 *
 * @author: zhangwenjun
 * @version: V1.0
 * @Date: 2018-10-19 10:42
 */
public class ModelAndMapperGenerator extends CodeGeneratorManager implements CodeGenerator {

    @Override
    public void genCode(String tableName, String modelName, String sign) {
        Context initConfig = initConfig(tableName, modelName, sign);
        List<String> warnings = null;
        MyBatisGenerator generator = null;
        try {
            Configuration cfg = new Configuration();
            cfg.addContext(initConfig);
            cfg.validate();
            DefaultShellCallback callback = new DefaultShellCallback(true);
            warnings = new ArrayList<String>();
            generator = new MyBatisGenerator(cfg, callback, warnings);
            generator.generate(null);
        } catch (Exception e) {
            throw new RuntimeException("Model 和  Mapper 生成失败!", e);
        }
        if (generator == null || generator.getGeneratedJavaFiles().isEmpty() || generator.getGeneratedXmlFiles().isEmpty()) {
            throw new RuntimeException("Model 和  Mapper 生成失败, warnings: " + warnings);
        }
        if (StringUtils.isNullOrEmpty(modelName)) {
            modelName = tableNameConvertUpperCamel(tableName);
        }
        logger.info(modelName, "{}.java 生成成功!");
        logger.info(modelName, "{}Mapper.java 生成成功!");
        logger.info(modelName, "{}Mapper.xml 生成成功!");
    }

    /**
     * 完善初始化环境
     *
     * @param tableName 表名
     * @param modelName 自定义实体类名, 为null则默认将表名下划线转成大驼峰形式
     * @param sign      区分字段, 规定如表 gen_test_demo, 则 test 即为区分字段
     */
    private Context initConfig(String tableName, String modelName, String sign) {
        Context context = null;
        try {
            context = initMybatisGeneratorContext(sign);
            JavaModelGeneratorConfiguration javaModelGeneratorConfiguration = new JavaModelGeneratorConfiguration();
            javaModelGeneratorConfiguration.setTargetProject(PROJECT_PATH + JAVA_PATH);
            javaModelGeneratorConfiguration.setTargetPackage(MODEL_PACKAGE + "." + sign);
            //javaModelGeneratorConfiguration.addProperty("rootClass","com.xilin.model.BaseModel");
            javaModelGeneratorConfiguration.addProperty("trimStrings","true");
            context.setJavaModelGeneratorConfiguration(javaModelGeneratorConfiguration);
            JavaClientGeneratorConfiguration javaClientGeneratorConfiguration = new JavaClientGeneratorConfiguration();
            javaClientGeneratorConfiguration.setTargetProject(PROJECT_PATH + JAVA_PATH);
            javaClientGeneratorConfiguration.setTargetPackage(MAPPER_PACKAGE + "." + sign);
            javaClientGeneratorConfiguration.setConfigurationType("XMLMAPPER");
            context.setJavaClientGeneratorConfiguration(javaClientGeneratorConfiguration);
            TableConfiguration tableConfiguration = new TableConfiguration(context);
            tableConfiguration.setTableName(tableName);
            tableConfiguration.setDomainObjectName(modelName);
            tableConfiguration.setGeneratedKey(new GeneratedKey("id", "Mysql", true, null));
            tableConfiguration.setWildcardEscapingEnabled(false);
            tableConfiguration.setAllColumnDelimitingEnabled(false);
            tableConfiguration.setInsertStatementEnabled(false);
            tableConfiguration.setDeleteByPrimaryKeyStatementEnabled(false);
            tableConfiguration.setUpdateByPrimaryKeyStatementEnabled(false);
            tableConfiguration.setSelectByPrimaryKeyQueryId("id");
            tableConfiguration.setSelectByPrimaryKeyStatementEnabled(false);
            context.addTableConfiguration(tableConfiguration);
            //指定mapper.xml生成的位置
            SqlMapGeneratorConfiguration sqlMapGeneratorConfiguration = new SqlMapGeneratorConfiguration();
            sqlMapGeneratorConfiguration.setTargetProject(PROJECT_PATH + JAVA_PATH);
            sqlMapGeneratorConfiguration.setTargetPackage(MAPPER_PACKAGE + "." + sign);
            context.setSqlMapGeneratorConfiguration(sqlMapGeneratorConfiguration);
            //生成的Java文件的编码
            context.addProperty("javaFileEncoding","utf-8");
            //context.addProperty("beginningDelimiter","`");
            //context.addProperty("endingDelimiter","`");
            //格式化java代码
            context.addProperty("javaFormatter","org.mybatis.generator.api.dom.DefaultJavaFormatter");
            //格式化xml代码
            context.addProperty("xmlFormatter","org.mybatis.generator.api.dom.DefaultXmlFormatter");
        } catch (Exception e) {
            throw new RuntimeException("ModelAndMapperGenerator 初始化环境异常!", e);
        }
        return context;
    }
}
