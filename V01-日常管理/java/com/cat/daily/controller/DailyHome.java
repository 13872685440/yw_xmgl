package com.cat.daily.controller;

import com.cat.boot.jsonbean.ResultBean;
import com.cat.boot.service.BaseHome;
import com.cat.daily.jsonbean.DailyBean;
import com.cat.daily.model.Daily;
import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daily")
public class DailyHome extends BaseHome<Daily> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5079095773304621404L;

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam String id) {
		Daily entity = findById(id);
		if (entity!=null) {
			return ResultBean.getSucess(DailyBean.setThis(entity));
		} else {
			return ResultBean.getSucess(DailyBean.setThis(new Daily()));
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(DailyBean entity){
		Daily bean = new Daily();
		if(StringUtils.isNotEmpty(entity.getId())){
			bean = findById(entity.getId());
		}
		DailyBean.clone(bean, entity);
		baseService.save(bean);
		return ResultBean.getSucess(DailyBean.setThis(bean));
	}
}
