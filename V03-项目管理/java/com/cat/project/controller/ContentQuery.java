package com.cat.project.controller;

import com.cat.boot.jsonbean.BaseQueryHelp;
import com.cat.boot.jsonbean.QueryResultBean;
import com.cat.boot.jsonbean.ResultBean;
import com.cat.boot.service.BaseNqtQuery;
import com.cat.boot.util.NameQueryUtil;
import com.cat.project.jsonbean.ContentBean;
import com.cat.project.jsonbean.ScheduleBean;
import com.cat.project.model.Content;
import com.cat.project.model.Schedule;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Scope("prototype")
@RequestMapping("/content")
public class ContentQuery extends BaseNqtQuery<Content> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7061453734710522088L;

	@Override
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String query(BaseQueryHelp parms) throws Exception {
		excuteQuery(parms);
		return ResultBean.getSucess(new QueryResultBean(parms, ContentBean.setThis(results)));
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getList", method = RequestMethod.GET)
	public String query_family(@RequestParam String keyValue,@RequestParam int type) throws Exception {
		List<Content> p = (List<Content>) baseService.getList("Content", "o.id desc", true,
				NameQueryUtil.setParams("keyValue",keyValue,"type",type));
		return ResultBean.getSucess(ContentBean.setThis(p));
	}
}
