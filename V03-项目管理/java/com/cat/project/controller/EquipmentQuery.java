package com.cat.project.controller;

import com.cat.boot.jsonbean.BaseQueryHelp;
import com.cat.boot.jsonbean.QueryResultBean;
import com.cat.boot.jsonbean.ResultBean;
import com.cat.boot.service.BaseNqtQuery;
import com.cat.project.jsonbean.EquipmentBean;
import com.cat.project.model.Equipment;
import org.springframework.context.annotation.Scope;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope("prototype")
@RequestMapping("/equipment")
public class EquipmentQuery extends BaseNqtQuery<Equipment> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7061453734710522088L;

	@Override
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String query(BaseQueryHelp parms) throws Exception {
		excuteQuery(parms);
		return ResultBean.getSucess(new QueryResultBean(parms, EquipmentBean.setThis(results)));
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(@RequestParam String id) {
		return super.delete(id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@RequestMapping(value = "/revoke", method = RequestMethod.POST)
	public String revoke(@RequestParam String id) {
		Equipment entity = (Equipment)baseService.findById(Equipment.class,id);
		entity.setDictionaryData("0");
		baseService.save(entity);

		baseService.updataState("Content", "keyValue", id);
		baseService.updataState("Offer", "keyValue", id);

		return ResultBean.getSucess("删除成功");
	}

}
