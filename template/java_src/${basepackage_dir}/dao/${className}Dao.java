<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.${module}.dao;

import com.hsnn.medstgmini.common.dao.GenericDao;
import ${basepackage}.${module}.model.${className};

public interface ${className}Dao extends GenericDao<${className}, ${table.getPkColumn().simpleJavaType}> {
}