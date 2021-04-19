package com.cat.project.controller;

import com.alibaba.fastjson.JSONObject;
import com.cat.boot.jsonbean.PropParamBean;
import com.cat.boot.jsonbean.ResultBean;
import com.cat.boot.service.BaseHome;
import com.cat.boot.util.StringUtil;
import com.cat.project.jsonbean.EquipmentBean;
import com.cat.project.model.Contract;
import com.cat.project.model.Equipment;
import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/equipment")
public class EquipmentHome extends BaseHome<Equipment> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5079095773304621404L;

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam String id) {
		if (!StringUtil.isEmpty(id)) {
			Equipment entity = findById(id);
			return ResultBean.getSucess(EquipmentBean.setThis(entity));
		} else {
			return ResultBean.getSucess(EquipmentBean.setThis(new Equipment()));
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(EquipmentBean bean) throws Exception {
		Equipment entity = new Equipment();
		if(StringUtils.isNotEmpty(bean.getId())){
			entity = findById(bean.getId());
		}
		EquipmentBean.clone(entity, bean, baseService);
		baseService.save(entity);

		if(StringUtils.isNotEmpty(bean.getXsht_id())){
			Contract contract = (Contract)baseService.findById(Contract.class,bean.getXsht_id());
			contract.setIsRelation(contract.getIsRelation()==0?1:9);
			baseService.save(contract);
		}

		return ResultBean.getSucess(EquipmentBean.setThis(entity));
	}

	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public String find(@RequestParam String id) {
		Equipment entity = findById(id);
			return ResultBean.getSucess(EquipmentBean.setThis(entity));
	}

	@RequestMapping(value = "/validationUnique", method = RequestMethod.GET)
	public String validationPhone(@RequestParam String key,@RequestParam String value,@RequestParam String error) {
		// 判断合同号是否有录入
		JSONObject o = new JSONObject();
		Equipment user = (Equipment) baseService.getSimple("Equipment", "", false,
				Arrays.asList(new PropParamBean("=", "and", key, value)));
		if(user!=null) {
			o.put("error", error);
		}
		return ResultBean.getSucess(o);
	}
}
