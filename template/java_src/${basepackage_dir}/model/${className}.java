package ${basepackage}.${module}.model;

import java.util.Date;
import java.math.BigDecimal;


<#include "/java_imports.include">

<#include "/macro.include"/>
import com.hsnn.medstgmini.common.model.ICreateInfo;
import com.hsnn.medstgmini.common.model.IUpdateInfo;

<#include "/java_copyright.include"><#assign className = table.className><#assign classNameLower = className?uncap_first> 
public class ${className}{
	
	//alias
	public static final String TABLE_ALIAS = "${table.tableAlias}";
	
	//columns START
	<#list table.columns as column>
	/**
	 * @Fields ${column.columnNameFirstLower}:${column.columnAlias}
	 */
	private ${column.simpleJavaType} ${column.columnNameFirstLower};
	
	</#list>
	//columns END

<@generateConstructor className/>
<@generateJavaColumns/>


}