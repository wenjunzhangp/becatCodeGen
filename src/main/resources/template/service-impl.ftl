package ${basePackage}.service.impl.${sign};

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import ${basePackage}.dao.${sign}.${modelNameUpperCamel}Mapper;
import ${basePackage}.model.${sign}.${modelNameUpperCamel};
import ${basePackage}.service.${sign}.${modelNameUpperCamel}Service;
import ${basePackage}.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * Copyright:   ${company}
 *
 *
 * @author: ${author}
 * @version: V1.0
 * @Date: ${date}
 */
@Service
public class ${modelNameUpperCamel}ServiceImpl extends AbstractService<${modelNameUpperCamel}> implements ${modelNameUpperCamel}Service {

    @Autowired
    private ${modelNameUpperCamel}Mapper ${modelNameLowerCamel}Mapper;

    @Override
    public PageInfo find${modelNameUpperCamel}PageList(Map<String, Object> paramMap) {
        PageHelper.startPage(Integer.valueOf(paramMap.get("page").toString()),Integer.valueOf(paramMap.get("limit").toString()),true);
        List<${modelNameUpperCamel}> dataList = ${modelNameLowerCamel}Mapper.findPageList(paramMap);
        return new PageInfo<${modelNameUpperCamel}>(dataList);
    }
}
