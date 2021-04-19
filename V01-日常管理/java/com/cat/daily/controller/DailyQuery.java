package com.cat.daily.controller;

import com.cat.boot.jsonbean.BaseQueryHelp;
import com.cat.boot.jsonbean.QueryResultBean;
import com.cat.boot.jsonbean.ResultBean;
import com.cat.boot.service.BaseNqtQuery;
import com.cat.boot.util.CalendarUtil;
import com.cat.boot.util.NameQueryUtil;
import com.cat.daily.jsonbean.DailyBean;
import com.cat.daily.model.Daily;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@Scope("prototype")
@RequestMapping("/daily")
public class DailyQuery extends BaseNqtQuery<Daily> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7061453734710522088L;

	@Override
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String query(BaseQueryHelp parms) throws Exception {
		excuteQuery(parms);
		return ResultBean.getSucess(new QueryResultBean(parms, DailyBean.setThis(results)));
	}


	@RequestMapping(value = "/getSignlist", method = RequestMethod.GET)
	public String getSignlist(@RequestParam String dailyDate) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		dailyDate =  CalendarUtil.getYyyyMm(CalendarUtil.StringToCalendar(dailyDate));
		List<Daily> list = (ArrayList<Daily>)baseService.getList("Daily","daily","Daily_getTitleBySign",
				NameQueryUtil.setParams("dailyDate",dailyDate,"isSign","1"));
		return ResultBean.getSucess(DailyBean.setThis(list));
	}

	@RequestMapping(value = "/getDaylist", method = RequestMethod.GET)
	public String getDaylist(@RequestParam String dailyDate) throws Exception {
		List<Daily> list = (ArrayList<Daily>)baseService.getList("Daily","daily","Daily_getTitleBySign",
				NameQueryUtil.setParams("dailyDate",dailyDate,"isSign",""));
		return ResultBean.getSucess(DailyBean.setThis(list));
	}

	@RequestMapping(value = "/getMonthlist", method = RequestMethod.GET)
	public String getMonthlist(@RequestParam String dailyDate) throws Exception {
		Calendar s = CalendarUtil.StringToCalendar(dailyDate);
		s.add(Calendar.MONTH, -1);
		Calendar e = CalendarUtil.StringToCalendar(dailyDate);
		e.add(Calendar.MONTH, +1);
		String kssj = CalendarUtil.getYyyyMm(s)+"-15";
		String jssj = CalendarUtil.getYyyyMm(e)+"-15";

		List<Daily> list = (ArrayList<Daily>)baseService.getList("Daily","daily","Daily_getlistDailyDate",
				NameQueryUtil.setParams("kssj",kssj,"jssj",jssj));
		return ResultBean.getSucess(DailyBean.setThis(list));
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(@RequestParam String id) {
		return super.delete(id);
	}

}
