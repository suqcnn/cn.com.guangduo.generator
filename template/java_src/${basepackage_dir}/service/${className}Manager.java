<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.${module}.service;

import com.hsnn.medstgmini.common.service.GenericManager;
import ${basepackage}.${module}.model.${className};

public interface ${className}Manager extends GenericManager<${className}, ${table.getPkColumn().simpleJavaType}> {
	// 扩展接口
}