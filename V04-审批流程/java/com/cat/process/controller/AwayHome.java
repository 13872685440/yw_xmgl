package com.cat.process.controller;

import com.cat.boot.jsonbean.ResultBean;
import com.cat.boot.service.BaseHome;
import com.cat.boot.util.StringUtil;
import com.cat.process.model.Away;
import com.cat.process.jsonbean.AwayBean;
import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/away")
public class AwayHome extends BaseHome<Away> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5079095773304621404L;

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam String id) {
		if (!StringUtil.isEmpty(id)) {
			Away entity = findById(id);
			return ResultBean.getSucess(AwayBean.setThis(entity));
		} else {
			return ResultBean.getSucess(AwayBean.setThis(new Away()));
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(AwayBean entity) throws Exception {
		Away bean = new Away();
		if (StringUtils.isNotEmpty(entity.getId())) {
			bean = findById(entity.getId());
		}
		AwayBean.clone(bean, entity,baseService);
		baseService.save(bean);
		return ResultBean.getSucess(AwayBean.setThis(new Away()));
	}

}
