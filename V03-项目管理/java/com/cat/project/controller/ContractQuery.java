package com.cat.project.controller;

import com.cat.boot.jsonbean.BaseQueryHelp;
import com.cat.boot.jsonbean.QueryResultBean;
import com.cat.boot.jsonbean.ResultBean;
import com.cat.boot.service.BaseNqtQuery;
import com.cat.boot.util.NameQueryUtil;
import com.cat.project.jsonbean.ContractBean;
import com.cat.project.model.Contract;
import org.springframework.context.annotation.Scope;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Scope("prototype")
@RequestMapping("/contract")
public class ContractQuery extends BaseNqtQuery<Contract> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7061453734710522088L;

	@Override
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String query(BaseQueryHelp parms) throws Exception {
		excuteQuery(parms);
		return ResultBean.getSucess(new QueryResultBean(parms, ContractBean.setThis(results)));
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(@RequestParam String id) {
		return super.delete(id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@RequestMapping(value = "/revoke", method = RequestMethod.POST)
	public String revoke(@RequestParam String id) {
		Contract entity = (Contract)baseService.findById(Contract.class,id);
		entity.setDictionaryData("0");
		baseService.save(entity);

		baseService.updataState("Content", "keyValue", id);
		baseService.updataState("Offer", "keyValue", id);
		baseService.updataState("CStatement", "keyValue", id);

		return ResultBean.getSucess("删除成功");
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getListByCoding", method = RequestMethod.GET)
	public String query_family(@RequestParam String keyword,@RequestParam int isRelation) throws Exception {
		List<Contract> res = (List<Contract> ) baseService.getList("Contract", "project", "Contract_getCoding",
				NameQueryUtil.setParams("coding",keyword,"isRelation",isRelation));
		return ResultBean.getSucess(ContractBean.setSelect(res));
	}

}
