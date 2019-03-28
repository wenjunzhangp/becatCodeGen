package com.codegen.service;

/**
 * Copyright:   西邻在线
 * 配置信息变量
 *
 * @author: zhangwenjun
 * @version: V1.0
 * @Date: 2018-10-19 10:42
 */
public class CodeGeneratorConfig {

    // JDBC 相关配置信息
    protected static String JDBC_URL;
    protected static String JDBC_USERNAME;
    protected static String JDBC_PASSWORD;
    protected static String JDBC_DRIVER_CLASS_NAME;

    // 项目在硬盘上的基础路径
    protected static String PROJECT_PATH;
    // java文件路径
    protected static String JAVA_PATH;
    // 资源文件路径
    protected static String RESOURCES_PATH;
    // 模板存放位置
    protected static String TEMPLATE_FILE_PATH;
    // 生成的分页列表页位置
    protected static String PAGELIST_FILE_PATH;
    // 分页列表js
    protected static String PAGELISTJS_FILE_PATH;

    // 项目基础包
    protected static String BASE_PACKAGE;
    // 项目 Model 所在包
    protected static String MODEL_PACKAGE;
    // 项目 Mapper 所在包
    protected static String MAPPER_PACKAGE;
    // 项目 Service 所在包
    protected static String SERVICE_PACKAGE;
    // 项目 Service 实现类所在包
    protected static String SERVICE_IMPL_PACKAGE;
    // 项目 Controller 所在包
    protected static String CONTROLLER_PACKAGE;

    // 生成的 Service 存放路径
    protected static String PACKAGE_PATH_SERVICE;
    // 生成的 Service 实现存放路径
    protected static String PACKAGE_PATH_SERVICE_IMPL;
    // 生成的 Controller 存放路径
    protected static String PACKAGE_PATH_CONTROLLER;

    // MyMapper 插件基础接口的完全限定名
    protected static String MAPPER_INTERFACE_REFERENCE;
    // 通用 Service 层 基础接口完全限定名
    protected static String SERVICE_INTERFACE_REFERENCE;
    // 基于通用 MyBatis Mapper 插件的 Service 接口的实现
    protected static String ABSTRACT_SERVICE_CLASS_REFERENCE;

    // 模板注释中 @author
    protected static String AUTHOR;
    // 模板注释中 @date
    protected static String DATE;
    // 模板注释中 @sign
    protected static String SIGN;
    // 模板注释中 @table-name
    protected static String TABLENAME;
    // 模板注释中 @model_name
    protected static String MODELNAME;

}
