package com.cat.process.controller;

import com.cat.boot.jsonbean.BaseQueryHelp;
import com.cat.boot.jsonbean.QueryResultBean;
import com.cat.boot.jsonbean.ResultBean;
import com.cat.boot.service.BaseNqtQuery;
import com.cat.boot.util.CalendarUtil;
import com.cat.boot.util.NameQueryUtil;
import com.cat.process.jsonbean.LeaveBean;
import com.cat.process.model.Leave;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@RestController
@Scope("prototype")
@RequestMapping("/leave")
public class LeaveQuery extends BaseNqtQuery<Leave> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7061453734710522088L;

	@Override
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String query(BaseQueryHelp parms) throws Exception {
		excuteQuery(parms);
		return ResultBean.getSucess(new QueryResultBean(parms, LeaveBean.setThis(results)));
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(@RequestParam String id) {
		return super.delete(id);
	}

}
