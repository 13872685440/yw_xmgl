package com.cat.project.controller;

import com.cat.boot.catconst.RedisConst;
import com.cat.boot.jsonbean.ResultBean;
import com.cat.boot.service.BaseHome;
import com.cat.boot.util.CalendarUtil;
import com.cat.boot.util.FrameUtils;
import com.cat.boot.util.NameQueryUtil;
import com.cat.boot.util.StringUtil;
import com.cat.project.jsonbean.ScheduleBean;
import com.cat.project.model.Schedule;
import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/schedule")
public class ScheduleHome extends BaseHome<Schedule> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5079095773304621404L;

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam String id) {
		if (!StringUtil.isEmpty(id)) {
			Schedule entity = findById(id);
			return ResultBean.getSucess(ScheduleBean.setThis(entity));
		} else {
			return ResultBean.getSucess(ScheduleBean.setThis(new Schedule()));
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(ScheduleBean bean) throws Exception {
		Schedule entity = new Schedule();
		if(StringUtils.isNotEmpty(bean.getId())){
			entity = findById(bean.getId());
			ScheduleBean.clone(entity, bean, baseService);
		}else{
			ScheduleBean.clone(entity, bean, baseService);
			createCode(entity);
		}
		baseService.save(entity);
		return ResultBean.getSucess(ScheduleBean.setThis(entity));
	}


	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public String find(@RequestParam String id) {
		Schedule entity = findById(id);
		return ResultBean.getSucess(ScheduleBean.setThis(entity));
	}


	private void createCode(Schedule entity){
		String date = CalendarUtil.getYyMmDd(CalendarUtil.now());
		String pcd = RedisConst.suhedule_code_prefix+"-"+date;
		String code = ((String) baseService.getSimple("Schedule", "project", "Schedule_getCode",
				NameQueryUtil.setParams("code",pcd)));
		entity.setCode(date+code);
		entity.setCoding(pcd+code);
	}


}
