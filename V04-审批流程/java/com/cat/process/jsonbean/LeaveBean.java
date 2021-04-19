package com.cat.process.jsonbean;

import com.cat.boot.jsonbean.BaseAppBean;
import com.cat.boot.model.BaseEntity;
import com.cat.boot.service.BaseService;
import com.cat.boot.util.StringUtil;
import com.cat.dictionary.model.Dictionary;
import com.cat.process.model.Leave;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class LeaveBean extends BaseAppBean {

    private static final long serialVersionUID = 7777525968411090290L;

    private String id;
    /** 请假类型 */
    private String leavetType_code;
    /** 请假类型 */
    private String leavetType_name;
    /** 开始日期 */
    private String startDate;
    /** 开始时间(上午) */
    private String startTime;
    /** 结束日期 */
    private String endDate;
    /** 开始时间(下午) */
    private String endTime;
    /** 请假时长 */
    private String duration;
    /** 说明 */
    private String explain;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getLeavetType_code() {
        return leavetType_code;
    }

    public void setLeavetType_code(String leavetType_code) {
        this.leavetType_code = leavetType_code;
    }

    public String getLeavetType_name() {
        return leavetType_name;
    }

    public void setLeavetType_name(String leavetType_name) {
        this.leavetType_name = leavetType_name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public LeaveBean() {}

    public LeaveBean(BaseEntity entity) {
        super(entity);
    }

    public static LeaveBean setThis(Leave entity) {
        LeaveBean bean = new LeaveBean(entity);
        bean.setId(entity.getId());
        if (entity.getLeavetType() != null) {
            bean.setLeavetType_code(entity.getLeavetType().getCode());
            bean.setLeavetType_name(entity.getLeavetType().getName());
        }
        bean.setStartDate(entity.getStartDate());
        bean.setStartTime(entity.getStartTime());
        bean.setEndDate(entity.getEndDate());
        bean.setEndTime(entity.getEndTime());
        bean.setDuration(entity.getDuration());
        bean.setExplain(entity.getExplain());
        return bean;
    }

    public static List<LeaveBean> setThis(List<Leave> entitys) {
        List<LeaveBean> beans = new ArrayList<>();
        if (!StringUtil.isListEmpty(entitys)) {
            for (Leave bean : entitys) {
                beans.add(setThis(bean));
            }
        }
        return beans;
    }

    public static void clone(Leave bean, LeaveBean entity,BaseService baseService) {
        bean.setId(entity.getId());
        if (StringUtils.isNotEmpty(entity.getLeavetType_code())) {
            bean.setLeavetType((Dictionary) baseService.findById(Dictionary.class, entity.getLeavetType_code()));
        }
        bean.setStartDate(entity.getStartDate());
        bean.setStartTime(entity.getStartTime());
        bean.setEndDate(entity.getEndDate());
        bean.setEndTime(entity.getEndTime());
        bean.setDuration(entity.getDuration());
        bean.setExplain(entity.getExplain());

    }
}