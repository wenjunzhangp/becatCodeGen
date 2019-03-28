package com.codegen.service;

/**
 * Copyright:   西邻在线
 * 主要逻辑接口
 *
 * @author: zhangwenjun
 * @version: V1.0
 * @Date: 2018-10-19 10:42
 */
public interface CodeGenerator {

    /**
     * 代码生成主要逻辑
     *
     * @param tableName 表名
     * @param modelName 自定义实体类名, 为null则默认将表名下划线转成大驼峰形式
     * @param sign      区分字段, 规定如表 gen_test_demo, 则 test 即为区分字段
     */
    void genCode(String tableName, String modelName, String sign);
}
