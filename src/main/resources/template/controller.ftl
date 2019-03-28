package ${basePackage}.controller.${sign};

import ${basePackage}.model.${sign}.${modelNameUpperCamel};
import ${basePackage}.service.${sign}.${modelNameUpperCamel}Service;
import com.xilin.controller.BaseController;
import com.xilin.util.JsonResult;
import com.xilin.util.LogUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Copyright:   ${company}
 *
 *
 * @author: ${author}
 * @version: V1.0
 * @Date: ${date}
 */
@Controller
@RequestMapping("/${baseRequestMapping}/")
public class ${modelNameUpperCamel}Controller extends BaseController{

    @Autowired
    ${modelNameUpperCamel}Service ${modelNameLowerCamel}Service;

    /**
     * 新增方法
     * @param ${modelNameLowerCamel}
     * @return
     */
    @RequestMapping("add")
    @ResponseBody
    public JsonResult add(${modelNameUpperCamel} ${modelNameLowerCamel}) {
        try {
            ${modelNameLowerCamel}.setId(getUUID());
            ${modelNameLowerCamel}Service.save(${modelNameLowerCamel});
            return new JsonResult().setSuccess(true).setMsg("添加成功");
        } catch ( Exception e ){
            LogUtils.logError("添加[${modelNameUpperCamel}]发生异常",e);
            return new JsonResult().setSuccess(false).setMsg("添加出现异常");
        }
    }

    /**
     * 单条删除方法
     * @param request
     * @return
     */
    @RequestMapping("delete")
    @ResponseBody
    public JsonResult delete(HttpServletRequest request) {
        try {
            String ids = request.getParameter("ids");
            if (StringUtils.isEmpty(ids)) {
                return new JsonResult().setSuccess(false).setMsg("缺少必要参数");
            }
            ${modelNameLowerCamel}Service.deleteById(ids);
	        return new JsonResult().setSuccess(true).setMsg("删除成功");
        } catch ( Exception e ){
            LogUtils.logError("删除[${modelNameUpperCamel}]发生异常",e);
            return new JsonResult().setSuccess(false).setMsg("删除出现异常");
        }
    }

    /**
     * 修改方法
     * @param ${modelNameLowerCamel}
     * @return
     */
    @RequestMapping("update")
    @ResponseBody
    public JsonResult update(${modelNameUpperCamel} ${modelNameLowerCamel}) {
        try {
            ${modelNameLowerCamel}Service.update(${modelNameLowerCamel});
	        return new JsonResult().setSuccess(true).setMsg("修改成功");
        } catch ( Exception e ){
            LogUtils.logError("修改[${modelNameUpperCamel}]发生异常",e);
            return new JsonResult().setSuccess(false).setMsg("修改出现异常");
        }
    }

    /**
     * 分页列表方法
     * @param request
     * @return
     */
    @RequestMapping("pageList")
    @ResponseBody
    public Map<String,Object> pageList(HttpServletRequest request){
        try {
            Map<String,Object> paramMap = genRequestMapSingle(request);
            return setResultMapOkByPage(${modelNameLowerCamel}Service.find${modelNameUpperCamel}PageList(paramMap));
        } catch ( Exception e ) {
            LogUtils.logError("获取分页列表[${modelNameUpperCamel}]发生异常",e);
            return setResultMapError(e);
        }
    }

    /**
     * 跳转新增/编辑窗体界面
     * @return
     */
    @RequestMapping("addOrUpdate")
    public String addOrUpdate () {
        return "/${sign}/${viewName}modify";
    }

    /**
     * 跳转分页列表界面
     * @return
     */
    @RequestMapping("page")
    public String page () {
        return "/${sign}/${viewName}";
    }
}
