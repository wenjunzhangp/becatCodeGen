package com.xilin.controller;

import com.github.pagehelper.PageInfo;
import com.xilin.statics.Constant;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

public class BaseController {

    @InitBinder
    public void initBinder(ServletRequestDataBinder binder) {
        /**
         * 自动转换日期类型的字段格式
         */
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
        /**
         * 防止XSS攻击
         */
        //binder.registerCustomEditor(String.class, new StringEscapeEditor(true, false));
    }

    protected int pageNo = 1;
    protected int pageSize = 10;

    /**
     * 生成主键UUID
     * @return
     */
    protected static String getUUID(){
        String uuid = UUID.randomUUID().toString();
        return uuid.replace("-", "");
    }

    /**
     * 存储session
     *
     * @param request
     * @param key
     * @param value
     */
    protected static void setSession(HttpServletRequest request, String key, Object value) {
        HttpSession session = request.getSession();
        session.setAttribute(key, value);
    }

    /**
     * 获取session
     *
     * @param request
     * @param key
     */
    protected static Object getSession(HttpServletRequest request, String key) {
        HttpSession session = request.getSession();
        return session.getAttribute(key);
    }

    /**
     * 销毁session
     *
     * @param request
     * @param key
     */
    protected static void destroySession(HttpServletRequest request, String key) {
        HttpSession session = request.getSession();
        session.removeAttribute(key);
    }

    /**
     * 赋值分页参数信息
     *
     * @param request
     */
    protected void setPageInfo(HttpServletRequest request) {
        String pageNoStr = request.getParameter("page");
        if (StringUtils.isNotBlank(pageNoStr)) {
            pageNo = Integer.valueOf(pageNoStr);
        }
        String pageSizeStr = request.getParameter("limit");
        if (StringUtils.isNotBlank(pageSizeStr)) {
            pageSize = Integer.valueOf(pageSizeStr);
        }
    }

    /**
     * 分页返回成功的响应体
     *
     * @param pageInfo
     */
    protected Map<String, Object> setResultMapOkByPage(PageInfo pageInfo) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>(16);
        resultMap.put(Constant.CODE, Constant.HTTP_DEFAULT);
        resultMap.put(Constant.MESSAGE, "");
        resultMap.put("count", pageInfo.getTotal());
        resultMap.put(Constant.DATA, pageInfo.getList());
        return resultMap;
    }

    /**
     * 分页返回失败的响应体
     *
     * @param e 异常信息
     */
    protected Map<String, Object> setResultMapError(Exception e) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>(16);
        resultMap.put(Constant.CODE, Constant.HTTP_ERROR);
        resultMap.put(Constant.MESSAGE, e.getMessage());
        return resultMap;
    }

    /**
     * 获取请求属性封装为Map类型 分页列表多条件查询使用
     *
     * @param request
     * @return
     */
    protected Map<String, Object> genRequestMapSingle(HttpServletRequest request) {
        Map<String, Object> conditions = new HashMap<String, Object>(256);
        Map map = request.getParameterMap();
        for (Object o : map.keySet()) {
            String key = (String) o;
            conditions.put(key, ((String[]) map.get(key))[0]);
        }
        setPageInfo(request);
        return conditions;
    }

    public ModelAndView redirect(String redirectUrl, Map<String, Object>... parament) {
        ModelAndView view = new ModelAndView(new RedirectView(redirectUrl));
        if (null != parament && parament.length > 0) {
            view.addAllObjects(parament[0]);
        }
        return view;
    }

}
