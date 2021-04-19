package com.cat.process.controller;

import com.cat.boot.jsonbean.ResultBean;
import com.cat.boot.service.BaseHome;
import com.cat.process.jsonbean.LeaveBean;
import com.cat.process.model.Leave;
import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/leave")
public class LeaveHome extends BaseHome<Leave> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5079095773304621404L;

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam String id) {
		Leave entity = findById(id);
		if (entity!=null) {
			return ResultBean.getSucess(LeaveBean.setThis(entity));
		} else {
			return ResultBean.getSucess(LeaveBean.setThis(new Leave()));
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(LeaveBean entity){
		Leave bean = new Leave();
		if(StringUtils.isNotEmpty(entity.getId())){
			bean = findById(entity.getId());
		}
		LeaveBean.clone(bean, entity,baseService);
		baseService.save(bean);
		return ResultBean.getSucess(LeaveBean.setThis(bean));
	}
}
