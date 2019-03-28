package ${basePackage}.service.${sign};

import com.github.pagehelper.PageInfo;
import ${basePackage}.model.${sign}.${modelNameUpperCamel};
import ${basePackage}.service.Service;

import java.util.Map;

/**
 * Copyright:   ${company}
 *
 *
 * @author: ${author}
 * @version: V1.0
 * @Date: ${date}
 */
public interface ${modelNameUpperCamel}Service extends Service<${modelNameUpperCamel}> {

    /**
     * 多条件查询分页列表
     * @param paramMap
     * @return
     */
    PageInfo find${modelNameUpperCamel}PageList(Map<String, Object> paramMap);

}
