package com.cat.project.controller;

import com.cat.boot.jsonbean.ResultBean;
import com.cat.boot.service.BaseHome;
import com.cat.boot.util.StringUtil;
import com.cat.dictionary.model.Dictionary;
import com.cat.project.jsonbean.OfferBean;
import com.cat.project.model.Contract;
import com.cat.project.model.Offer;
import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;

@RestController
@RequestMapping("/offer")
public class OfferHome extends BaseHome<Offer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5079095773304621404L;

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam String id) {
		if (!StringUtil.isEmpty(id)) {
			Offer entity = findById(id);
			return ResultBean.getSucess(OfferBean.setThis(entity));
		} else {
			return ResultBean.getSucess(OfferBean.setThis(new Offer()));
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(OfferBean entity) throws Exception {
		Offer bean = new Offer();
		if (StringUtils.isNotEmpty(entity.getId())) {
			bean = findById(entity.getId());
		}

		if (entity.getType() == 1 || entity.getType() == 2) {
			bean.setKeyId("Contract");
			Contract entity1 = (Contract) baseService.findById(Contract.class, entity.getKeyValue());
			if (entity.getType() == 1) {
				entity1.setKpmoney(entity1.getKpmoney() + entity.getPrice());
				entity1.setKpState((Dictionary) baseService.findById(Dictionary.class, entity.getState_code()));
				bean.setRatio((Math.round(entity1.getKpmoney() * 10000d / entity1.getMoney()) / 100d));

			} else if (entity.getType() == 2) {
				entity1.setSkmoney(entity1.getSkmoney() + entity.getPrice());
				entity1.setSkState((Dictionary) baseService.findById(Dictionary.class, entity.getState_code()));
				bean.setRatio((Math.round(entity1.getSkmoney() * 10000d / entity1.getMoney()) / 100d));
			}
			baseService.save(entity1);
		}
		OfferBean.clone(bean, entity, baseService);
		baseService.save(bean);
		return ResultBean.getSucess("sucess");
	}

}
