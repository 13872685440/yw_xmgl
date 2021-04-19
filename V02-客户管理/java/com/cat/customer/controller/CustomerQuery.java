package com.cat.customer.controller;

import com.cat.boot.jsonbean.BaseQueryHelp;
import com.cat.boot.jsonbean.QueryResultBean;
import com.cat.boot.jsonbean.ResultBean;
import com.cat.boot.service.BaseNqtQuery;
import com.cat.boot.util.ExcelImportUtil;
import com.cat.customer.jsonbean.CustomerBean;
import com.cat.customer.model.Customer;
import org.springframework.context.annotation.Scope;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@Scope("prototype")
@RequestMapping("/customer")
public class CustomerQuery extends BaseNqtQuery<Customer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7061453734710522088L;

	@Override
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String query(BaseQueryHelp parms) throws Exception {
		if(parms.getSortField()!=null) {
			if (parms.getSortField().equals("type_name")) {
				parms.setSortField("type.name");
			}
			if (parms.getSortField().equals("source_name")) {
				parms.setSortField("source.name");
			}
		}
		excuteQuery(parms);
		return ResultBean.getSucess(new QueryResultBean(parms, CustomerBean.setThis(results)));
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@RequestMapping(value = "/revoke", method = RequestMethod.POST)
	public String revoke(@RequestParam String id) {
		Customer entity = (Customer)baseService.findById(Customer.class,id);
		entity.setDictionaryData("0");
		baseService.save(entity);

		baseService.updataState("DecisionMaker", "customer.id", id);
		baseService.updataState("Partners", "customer.id", id);

		return ResultBean.getSucess("删除成功");
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(@RequestParam String id) {
		return super.delete(id);
	}



}
