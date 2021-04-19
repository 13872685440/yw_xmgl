package com.cat.customer.controller;

import com.cat.boot.jsonbean.ResultBean;
import com.cat.boot.service.BaseHome;
import com.cat.boot.util.StringUtil;
import com.cat.customer.model.Customer;
import com.cat.customer.jsonbean.DecisionMakerBean;
import com.cat.customer.model.DecisionMaker;
import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/decisionmaker")
public class DecisionMakerHome extends BaseHome<DecisionMaker> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5079095773304621404L;

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam String id) {
		if (!StringUtil.isEmpty(id)) {
			DecisionMaker entity = findById(id);
			return ResultBean.getSucess(DecisionMakerBean.setThis(entity));
		} else {
			return ResultBean.getSucess(DecisionMakerBean.setThis(new DecisionMaker()));
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(DecisionMakerBean entity) throws Exception {
		DecisionMaker bean = new DecisionMaker();
		if (StringUtils.isNotEmpty(entity.getId())) {
			bean = findById(entity.getId());
		}
		DecisionMakerBean.clone(bean, entity);
		bean.setCustomer((Customer)baseService.findById(Customer.class,entity.getCustomer_id()));
		baseService.save(bean);
		return ResultBean.getSucess("sucess");
	}

}
