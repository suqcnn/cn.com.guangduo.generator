<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.${module}.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ${basepackage}.${module}.service.${className}Manager;

import ${basepackage}.${module}.form.${className}Form;
import ${basepackage}.${module}.model.${className};
import com.hsnn.common.common.controller.GenericController;
import com.hsnn.common.util.BeanUtils;
import com.hsnn.common.util.Pagination;
import com.hsnn.common.util.ValidateUtils;

@Controller
@RequestMapping(${className}Controller.ACTION_PATH)
public class ${className}Controller extends GenericController {
	private static final Logger log = Logger.getLogger(${className}Controller.class);
	protected static final String ACTION_PATH="/${classNameLower}";
	protected static final String MODEL_PATH="/${module}/${classNameLower}/";// TODO 修改
	@Autowired
	private ${className}Manager ${classNameLower}Manager;

	@RequestMapping("toList")
	public ModelAndView toList() {
		return new ModelAndView(MODEL_PATH + "list");
	}
	
	@RequestMapping("get${className}Data")
	@ResponseBody
	public Pagination get${className}Data() {
		Pagination pagination = new Pagination(this.getRequest());
		try {
			pagination = ${classNameLower}Manager.getList(pagination);
		} catch (Exception e) {
			log.error("Failed to get${className}Data", e);
		}
		return pagination;
	}
	
	@RequestMapping("toAdd")
	public ModelAndView toAddPage() {
		ModelAndView modelAndView = new ModelAndView(MODEL_PATH + "add");
		modelAndView.addObject("validate", ValidateUtil.getValidate(${className}Form.class));
		return modelAndView;
	}
	
	@RequestMapping(value ="/add${className}" )
	@ResponseBody
	public AjaxObject add${className}(${className}Form ${classNameLower}Form){
		AjaxObject ajaxObject = new AjaxObject();
		${className} ${classNameLower} = new ${className}();
		formToModel(${classNameLower}Form, ${classNameLower});
		if(${classNameLower}Manager.save(${classNameLower})){
			ajaxObject.setSuccess(true);
		}else{
			ajaxObject.setSuccess(false);
		}
		return ajaxObject;
	}
	
	@RequestMapping("toUpdate")
	public ModelAndView toUpdate(${table.getPkColumn().javaType} ${table.getPkColumn().columnNameFirstLower}) {
		ModelAndView modelAndView = new ModelAndView(MODEL_PATH + "update");
		${className} ${classNameLower} = ${classNameLower}Manager.getById(${table.getPkColumn().columnNameFirstLower});
		${className}Form ${classNameLower}Form = new ${className}Form();
		modelToForm(${classNameLower}, ${classNameLower}Form);
		modelAndView.addObject("validate", ValidateUtils.getValidate(${className}Form.class));
		modelAndView.addObject("pubTradeGoodsForm", pubTradeGoodsForm);
		return modelAndView;

	}
	
	@RequestMapping(value ="/update${className}" )
	@ResponseBody
	public AjaxObject update${className}(${className}Form ${classNameLower}Form){
		AjaxObject ajaxObject = new AjaxObject();
		${className} ${classNameLower} = ${classNameLower}Manager.getById(${classNameLower}Form.get${table.getPkColumn().columnName}());
		BeanUtils.copyProperties(${classNameLower}Form, ${classNameLower});
		if(${classNameLower}Manager.updateById(${classNameLower})){
			ajaxObject.setSuccess(true);
		}else{
			ajaxObject.setSuccess(false);
		}
		return ajaxObject;
	}
}