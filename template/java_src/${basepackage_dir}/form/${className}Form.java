package ${basepackage}.${module}.form;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

<#include "/java_imports.include">
<#assign classNameQuery = table.className+"Form">
<#include "/macro.include"/>
import java.math.BigDecimal;
import javax.validation.constraints.Digits;

<#include "/java_copyright.include"><#assign className = table.className><#assign classNameLower = className?uncap_first> 
public class ${className}Form  {

	//columns START
	<#list table.columns as column>
	<#if  column.columnNameFirstLower != 'deleted'>
	
	/**
	 * @Fields ${column.sqlName}:${column.columnAlias}
	 */
	<#if !column.nullable>
	<#switch column.simpleJavaType> 
	<#case "Integer"> 
	@NotNull(message = "请填写${column.columnAlias}")
	<#break> 
	<#case "BigDecimal"> 
	@NotNull(message = "请填写${column.columnAlias}")
	<#break> 
	<#case "String"> 
	@NotEmpty(message = "请填写${column.columnAlias}")
	<#break> 
	</#switch> 
	</#if>
	<#if column.simpleJavaType == "Date">
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	</#if>
	<#if column.simpleJavaType == "String">
	@Length(max = ${column.size}, message = "${column.columnAlias}的长度不能超过{1}")
	</#if>
	<#if column.simpleJavaType == "BigDecimal">
	@Digits(integer = ${column.size}, fraction = ${column.decimalDigits}, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	</#if>
	<#if column.simpleJavaType == "Integer">
	@Range(message = "数值范围不正确")
	</#if>
	private ${column.simpleJavaType} ${column.columnNameFirstLower};
	</#if>
	</#list>
	//columns END
	

<@generateConstructor classNameQuery/>
<@generateJavaColumnsWithoutDeleted/>

}