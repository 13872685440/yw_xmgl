package com.cat.project.controller;

import com.cat.boot.jsonbean.ResultBean;
import com.cat.boot.service.BaseHome;
import com.cat.boot.util.NameQueryUtil;
import com.cat.boot.util.StringUtil;
import com.cat.dictionary.model.Dictionary;
import com.cat.project.jsonbean.CStatementBean;
import com.cat.project.jsonbean.ContractBean;
import com.cat.project.model.Contract;
import com.cat.project.model.CStatement;
import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cstatement")
public class CStatementHome extends BaseHome<CStatement> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5079095773304621404L;

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam String id) {
		if (!StringUtil.isEmpty(id)) {
			CStatement entity = findById(id);
			return ResultBean.getSucess(CStatementBean.setThis(entity));
		} else {
			return ResultBean.getSucess(CStatementBean.setThis(new CStatement()));
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(CStatementBean entity) {
			CStatement bean = new CStatement();
		if (StringUtils.isNotEmpty(entity.getId())) {
			bean = findById(entity.getId());
		}
		CStatementBean.clone(bean, entity);

		Contract contract =(Contract)baseService.findById(Contract.class,entity.getC_id());
		bean.setContract(contract);
		baseService.save(bean);

		if(bean.isSubmit()){
			contract.setHtjsState((Dictionary) baseService.findById(Dictionary.class, "00100002"));
		}
		baseService.save(contract);

		List<Object> list = new ArrayList();
		list.add(ContractBean.setThis(contract));
		list.add(CStatementBean.setThis(bean));
		CStatementBean.setThis(bean);
		return ResultBean.getSucess(list);
	}

	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public String find(@RequestParam String cid) throws Exception {
		List<CStatement> p = (List<CStatement>) baseService.getList("CStatement", "o.id desc", true,
				NameQueryUtil.setParams("contract.id", cid));
		if (p.size() != 0) {
			return ResultBean.getSucess(CStatementBean.setThis(p.get(0)));
		} else {
			Contract ce = (Contract) baseService.findById(Contract.class, cid);
			return ResultBean.getSucess(CStatementBean.setThis(ce));
		}
	}
}
