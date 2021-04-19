package com.cat.customer.controller;

import com.cat.boot.jsonbean.ResultBean;
import com.cat.boot.service.BaseHome;
import com.cat.boot.util.ExcelImportUtil;
import com.cat.boot.util.StringUtil;
import com.cat.customer.jsonbean.DecisionMakerBean;
import com.cat.customer.jsonbean.PartnersBean;
import com.cat.customer.model.Customer;
import com.cat.customer.jsonbean.CustomerBean;
import com.cat.customer.model.DecisionMaker;
import com.cat.customer.model.Partners;
import org.apache.commons.lang3.StringUtils;
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
import java.util.*;


@RestController
@RequestMapping("/customer")
public class CustomerHome extends BaseHome<Customer> {

	/**
	 *
	 */
	private static final long serialVersionUID = -5079095773304621404L;

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam String id) {
		if (!StringUtil.isEmpty(id)) {
			Customer entity = findById(id);
			return ResultBean.getSucess(CustomerBean.setThis(entity));
		} else {
			return ResultBean.getSucess(CustomerBean.setThis(new Customer()));
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(CustomerBean entity) throws Exception {
		Customer bean = new Customer();
		if (StringUtils.isNotEmpty(entity.getId())) {
			bean = findById(entity.getId());
		}
		CustomerBean.clone(bean, entity, baseService);
		baseService.save(bean);
		return ResultBean.getSucess("sucess");
	}

	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public String find(@RequestParam String id) {
		Customer entity = findById(id);
		return ResultBean.getSucess(CustomerBean.setThis(entity));
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@RequestMapping(value = "/improtExcel", method = {RequestMethod.POST})
		public void improtExcel(HttpServletResponse response, HttpServletRequest request,
							  @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
		try {
			List<Map<String, Object>> lists = ExcelImportUtil.readXls3(file);
			List<Customer> customers = new ArrayList<>();
			ListIterator<Map<String, Object>> iterator = lists.listIterator();
			while (iterator.hasNext()) {
				Map<String, Object> map = iterator.next();
				if (map.containsKey("type")) {
					if (map.get("type").equals("customer")) {
						Customer entity = new Customer();
						CustomerBean.clone(entity, map);
						customers.add(entity);
						iterator.remove();
					}
				}
			}

			ListIterator<Map<String, Object>> iterator1 = lists.listIterator();
			for (Customer entity : customers) {
				baseService.save(entity);
				while (iterator1.hasNext()) {
					Map<String, Object> map = iterator1.next();
					if (map.containsKey("type")) {
						if (map.get("type").equals("partners")) {
							Partners partners = new Partners();
							partners.setCustomer(entity);
							PartnersBean.clone(partners, map);
							baseService.save(partners);
							iterator1.remove();
						}else if (map.get("type").equals("dm")) {
							DecisionMaker dm = new DecisionMaker();
							dm.setCustomer(entity);
							DecisionMakerBean.clone(dm, map);
							baseService.save(dm);
							iterator1.remove();
						}
					}
				}
			}
		response.getWriter().print(ResultBean.getSucess("sucess"));
		} catch (Exception e) {
		e.printStackTrace();
		response.getWriter().print("error");
	}
	}
}
