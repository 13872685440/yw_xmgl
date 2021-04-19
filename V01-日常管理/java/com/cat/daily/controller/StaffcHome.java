package com.cat.daily.controller;

import com.alibaba.fastjson.JSONObject;
import com.cat.boot.jsonbean.PropParamBean;
import com.cat.boot.jsonbean.ResultBean;
import com.cat.boot.service.BaseHome;
import com.cat.boot.util.StringUtil;
import com.cat.daily.jsonbean.StaffcBean;
import com.cat.daily.model.Staffc;
import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/staffc")
public class StaffcHome extends BaseHome<Staffc> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5079095773304621404L;

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam String id) {
		if (!StringUtil.isEmpty(id)) {
			Staffc entity = findById(id);
			return ResultBean.getSucess(StaffcBean.setThis(entity));
		} else {
			return ResultBean.getSucess(StaffcBean.setThis(new Staffc()));
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(StaffcBean entity) throws Exception {
		Staffc bean = new Staffc();
		if(StringUtils.isNotEmpty(entity.getId())){
			bean = findById(entity.getId());
		}
		StaffcBean.clone(bean, entity);
		baseService.save(bean);
		return ResultBean.getSucess(StaffcBean.setThis(bean));

	}

	@RequestMapping(value = "/validationUnique", method = RequestMethod.GET)
	public String validationPhone(@RequestParam String key,@RequestParam String value,@RequestParam String error) {
		// 判断合同号是否有录入
		JSONObject o = new JSONObject();
		Staffc user = (Staffc) baseService.getSimple("Staffc", "", false,
				Arrays.asList(new PropParamBean("=", "and", key, value)));
		if(user!=null) {
			o.put("error", error);
		}
		return ResultBean.getSucess(o);
	}
}
