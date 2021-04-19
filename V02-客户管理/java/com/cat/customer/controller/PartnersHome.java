package com.cat.customer.controller;

import com.cat.boot.jsonbean.ResultBean;
import com.cat.boot.service.BaseHome;
import com.cat.boot.util.StringUtil;
import com.cat.customer.jsonbean.PartnersBean;
import com.cat.customer.model.Customer;
import com.cat.customer.model.Partners;
import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/partners")
public class PartnersHome extends BaseHome<Partners> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5079095773304621404L;

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam String id) {
		if (!StringUtil.isEmpty(id)) {
			Partners entity = findById(id);
			return ResultBean.getSucess(PartnersBean.setThis(entity));
		} else {
			return ResultBean.getSucess(PartnersBean.setThis(new Partners()));
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(PartnersBean entity) throws Exception {
		Partners bean = new Partners();
		if (StringUtils.isNotEmpty(entity.getId())) {
			bean = findById(entity.getId());
		}
		PartnersBean.clone(bean, entity);
		bean.setCustomer((Customer)baseService.findById(Customer.class,entity.getCustomer_id()));
		baseService.save(bean);
		return ResultBean.getSucess("sucess");
	}
}
