package com.cat.daily.controller;

import com.cat.boot.jsonbean.ResultBean;
import com.cat.boot.service.BaseHome;
import com.cat.boot.util.StringUtil;
import com.cat.daily.jsonbean.StaffcColumnBean;
import com.cat.daily.model.StaffcColumn;
import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/staffccolumn")
public class StaffcColumnHome extends BaseHome<StaffcColumn> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5079095773304621404L;

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam String id) {
		if (!StringUtil.isEmpty(id)) {
			StaffcColumn entity = findById(id);
			return ResultBean.getSucess(StaffcColumnBean.setThis(entity));
		} else {
			return ResultBean.getSucess(StaffcColumnBean.setThis(new StaffcColumn()));
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(StaffcColumnBean entity) throws Exception {
		StaffcColumn bean = new StaffcColumn();
		if(StringUtils.isNotEmpty(entity.getId())){
			bean = findById(entity.getId());
		}
		StaffcColumnBean.clone(bean, entity);
		baseService.save(bean);
		return ResultBean.getSucess(StaffcColumnBean.setThis(bean));
	}
}
