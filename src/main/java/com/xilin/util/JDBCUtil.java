package com.xilin.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Copyright:   西邻在线电子商务
 *
 * @author: zhangwenjun
 * @version: V1.0
 * @Date: 2019-03-15 13:35
 */
public class JDBCUtil {

    private static String driver = "";
    private static String url = "";
    private static String user = "";
    private static String password = "";

    /**
     * 加载配置文件
     *
     * @return
     */
    private static Properties loadProperties() {
        Properties prop = null;
        try {
            prop = new Properties();
            InputStream in = JDBCUtil.class.getClassLoader().getResourceAsStream("generatorConfig.properties");
            prop.load(in);
        } catch (Exception e) {
            throw new RuntimeException("加载配置文件异常!", e);
        }
        return prop;
    }

    /**
     * 初始化配置信息
     */
    private static void init() {
        try {
            Properties prop = loadProperties();
            url = prop.getProperty("jdbc.url");
            user = prop.getProperty("jdbc.username");
            password = prop.getProperty("jdbc.password");
            driver = prop.getProperty("jdbc.driver.class.name");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static {
        init();
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void close(ResultSet rs, PreparedStatement ps, Connection con) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (ps != null) {
                    try {
                        ps.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } finally {
                        if (con != null) {
                            try {
                                con.close();
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }

    /***
     * DQL查询
     * Result获取数据集
     *
     * @param sql
     * @param obj
     * @return
     */
    public static List<Map<String,Object>> executeQuery(String sql, Object... obj) {
        Connection con = getConnection();
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            for (int i = 0; i < obj.length; i++) {
                ps.setObject(i + 1, obj[i]);
            }
            rs = ps.executeQuery();
            List<Map<String,Object>> data = new ArrayList<Map<String,Object>>();
            ResultSetMetaData md = rs.getMetaData();
            int columnCount = md.getColumnCount();
            while (rs.next()) {
                Map<String, Object> rowData = new HashMap<String, Object>();
                for (int i = 1; i <= columnCount; i++) {
                    rowData.put(md.getColumnName(i), rs.getObject(i));
                }
                data.add(rowData);
            }
            return data;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs, ps, con);
        }
        return null;
    }

    public static List<Map<String,Object>> handleData(List<Map<String,Object>> data){
        List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
        for (int i = 0;i<data.size();i++) {
            Map<String,Object> info = new HashMap<>();
            Map<String,Object> map = data.get(i);
            info.put(String.valueOf(map.get("COLUMN_NAME")),map.get("COLUMN_COMMENT"));
            result.add(info);
        }
        return result;
    }

    public static void main(String[] args) {
        //取某一张表的所有字段名 作用：为分页的js table做准备
        List<Map<String,Object>> data = JDBCUtil.executeQuery("select COLUMN_NAME,column_comment from information_schema.COLUMNS where table_name = 'xl_test_gencode'");
        List<Map<String,Object>> result = handleData(data);
        for (int i = 0;i<result.size();i++) {
            Map map = result.get(i);
            System.out.println("key"+map.get("id"));
        }
    }
}
