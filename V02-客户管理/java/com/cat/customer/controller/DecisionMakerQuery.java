package com.cat.customer.controller;

import com.cat.boot.jsonbean.BaseQueryHelp;
import com.cat.boot.jsonbean.QueryResultBean;
import com.cat.boot.jsonbean.ResultBean;
import com.cat.boot.service.BaseNqtQuery;
import com.cat.boot.util.NameQueryUtil;
import com.cat.customer.jsonbean.DecisionMakerBean;
import com.cat.customer.model.DecisionMaker;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Scope("prototype")
@RequestMapping("/decisionmaker")
public class DecisionMakerQuery extends BaseNqtQuery<DecisionMaker> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7061453734710522088L;

	@Override
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String query(BaseQueryHelp parms) throws Exception {
		excuteQuery(parms);
		return ResultBean.getSucess(new QueryResultBean(parms, DecisionMakerBean.setThis(results)));
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getList", method = RequestMethod.GET)
	public String query_family(@RequestParam String customer_id) throws Exception {
		List<DecisionMaker> p = (List<DecisionMaker>) baseService.getList("DecisionMaker", "o.id desc", true,
				NameQueryUtil.setParams("customer.id",customer_id));
		return ResultBean.getSucess(DecisionMakerBean.setThis(p));
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(@RequestParam String id) {
		return super.delete(id);
	}

}
