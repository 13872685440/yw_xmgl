package com.cat.project.controller;

import com.alibaba.fastjson.JSONObject;
import com.cat.boot.jsonbean.PropParamBean;
import com.cat.boot.jsonbean.ResultBean;
import com.cat.boot.service.BaseHome;
import com.cat.boot.util.StringUtil;
import com.cat.project.jsonbean.ContractBean;
import com.cat.project.model.Contract;
import com.cat.project.model.Schedule;
import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/contract")
public class ContractHome extends BaseHome<Contract> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5079095773304621404L;

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam String id) {
		if (!StringUtil.isEmpty(id)) {
			Contract entity = findById(id);
			return ResultBean.getSucess(ContractBean.setThis(entity));
		} else {
			return ResultBean.getSucess(ContractBean.setThis(new Contract()));
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(ContractBean bean) throws Exception {
		Contract entity = new Contract();
		if(StringUtils.isNotEmpty(bean.getId())){
			entity = findById(bean.getId());
		}
		ContractBean.clone(entity, bean, baseService);
		baseService.save(entity);

		if(StringUtils.isNotEmpty(bean.getXmgd_id())){
			Schedule schedule = (Schedule)baseService.findById(Schedule.class,bean.getXmgd_id());
			schedule.setContractId(entity.getId());
			schedule.setContractCodding(entity.getCoding());
			baseService.save(schedule);
		}
		minioFileController.replaceTmpId(entity.getTmpId(), bean.getId(), "com.cat.project.model.Contract");
		return ResultBean.getSucess(ContractBean.setThis(entity));
	}

	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public String find(@RequestParam String id) {
			Contract entity = findById(id);
			return ResultBean.getSucess(ContractBean.setThis(entity));
	}

	@RequestMapping(value = "/validationUnique", method = RequestMethod.GET)
	public String validationPhone(@RequestParam String key,@RequestParam String value,@RequestParam String error) {
		// 判断合同号是否有录入
		JSONObject o = new JSONObject();
		Contract user = (Contract) baseService.getSimple("Contract", "", false,
				Arrays.asList(new PropParamBean("=", "and", key, value)));
		if(user!=null) {
			o.put("error", error);
		}
		return ResultBean.getSucess(o);
	}
}
