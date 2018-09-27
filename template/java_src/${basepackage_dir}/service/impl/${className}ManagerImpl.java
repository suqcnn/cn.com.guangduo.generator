<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.${module}.service.impl;

import org.springframework.stereotype.Service;
import ${basepackage}.${module}.service.${className}Manager;
import com.hsnn.medstgmini.common.service.impl.GenericManagerImpl;

import ${basepackage}.${module}.model.${className};

@Service
public class ${className}ManagerImpl extends GenericManagerImpl<${className}, ${table.getPkColumn().simpleJavaType}> implements ${className}Manager {
	// 扩展接口实现
    
}