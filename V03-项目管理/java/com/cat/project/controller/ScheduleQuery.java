package com.cat.project.controller;

import com.cat.boot.jsonbean.BaseQueryHelp;
import com.cat.boot.jsonbean.QueryResultBean;
import com.cat.boot.jsonbean.ResultBean;
import com.cat.boot.service.BaseNqtQuery;
import com.cat.boot.util.NameQueryUtil;
import com.cat.project.jsonbean.ScheduleBean;
import com.cat.project.model.Schedule;
import org.springframework.context.annotation.Scope;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Scope("prototype")
@RequestMapping("/schedule")
public class ScheduleQuery extends BaseNqtQuery<Schedule> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7061453734710522088L;

	@Override
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String query(BaseQueryHelp parms) throws Exception {
		excuteQuery(parms);
		return ResultBean.getSucess(new QueryResultBean(parms, ScheduleBean.setThis(results)));
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(@RequestParam String id) {
		return super.delete(id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@RequestMapping(value = "/revoke", method = RequestMethod.POST)
	public String revoke(@RequestParam String id) {
		Schedule entity = (Schedule)baseService.findById(Schedule.class,id);
		entity.setDictionaryData("0");
		baseService.save(entity);

		baseService.updataState("Content", "keyValue", id);

		return ResultBean.getSucess("删除成功");
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getListByCoding", method = RequestMethod.GET)
	public String query_family(@RequestParam String keyword) throws Exception {
		List<Schedule> res = (List<Schedule> ) baseService.getList("Schedule", "project", "Schedule_getCoding",
				NameQueryUtil.setParams("coding",keyword));
		return ResultBean.getSucess(ScheduleBean.setSelect(res));
	}
}
