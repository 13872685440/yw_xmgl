package com.cat.daily.controller;

import com.cat.boot.jsonbean.ResultBean;
import com.cat.boot.service.BaseHome;
import com.cat.boot.util.StringUtil;
import com.cat.daily.jsonbean.CommonColumnBean;
import com.cat.daily.model.CommonColumn;
import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/commoncolumn")
public class CommonColumnHome extends BaseHome<CommonColumn> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5079095773304621404L;

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam String id) {
		if (!StringUtil.isEmpty(id)) {
			CommonColumn entity = findById(id);
			return ResultBean.getSucess(CommonColumnBean.setThis(entity));
		} else {
			return ResultBean.getSucess(CommonColumnBean.setThis(new CommonColumn()));
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(CommonColumnBean entity){
		CommonColumn bean = new CommonColumn();
		if(StringUtils.isNotEmpty(entity.getId())){
			bean = findById(entity.getId());
		}
		CommonColumnBean.clone(bean, entity);
		baseService.save(bean);
		return ResultBean.getSucess(CommonColumnBean.setThis(bean));
	}
}
