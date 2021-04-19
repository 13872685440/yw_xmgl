package com.cat.customer.jsonbean;

import com.cat.boot.jsonbean.BaseAppBean;
import com.cat.boot.model.BaseEntity;
import com.cat.boot.service.BaseService;
import com.cat.boot.util.StringUtil;
import com.cat.customer.model.Partners;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PartnersBean extends BaseAppBean {

    private static final long serialVersionUID = 7777525968411090290L;

    private String id;
    /**关联客户管理实体*/
    private String customer_id;
    /** 公司名称*/
    private String corporatName;
    /** 合作规模*/
    private String cooperationScale;
    /** 合作方式*/
    private String cooperationMode;
    /** 评估*/
    private String assess;

    public String getCorporatName() {
        return corporatName;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public void setCorporatName(String corporatName) {
        this.corporatName = corporatName;
    }

    public String getCooperationScale() {
        return cooperationScale;
    }

    public void setCooperationScale(String cooperationScale) {
        this.cooperationScale = cooperationScale;
    }

    public String getCooperationMode() {
        return cooperationMode;
    }

    public void setCooperationMode(String cooperationMode) {
        this.cooperationMode = cooperationMode;
    }

    public String getAssess() {
        return assess;
    }

    public void setAssess(String assess) {
        this.assess = assess;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }



    public PartnersBean() {}

    public PartnersBean(BaseEntity entity) {
        super(entity);
    }

    public static PartnersBean setThis(Partners entity) {
        PartnersBean bean = new PartnersBean(entity);
        bean.setId(entity.getId());
        bean.setCustomer_id(entity.getCustomer().getId());
        bean.setCorporatName(entity.getCorporatName());
        bean.setCooperationScale(entity.getCooperationScale());
        bean.setCooperationMode(entity.getCooperationMode());
        bean.setAssess(entity.getAssess());
        return bean;
    }

    public static List<PartnersBean> setThis(List<Partners> entitys) {
        List<PartnersBean> beans = new ArrayList<>();
        if (!StringUtil.isListEmpty(entitys)) {
            for (Partners entity : entitys) {
                PartnersBean bean = setThis(entity);
                beans.add(bean);
            }
        }
        return beans;
    }

    public static void clone(Partners bean, Map<String, Object> map) {
        bean.setCorporatName(map.containsKey("corporatName")?map.get("corporatName").toString():null);
        bean.setCooperationScale(map.containsKey("cooperationScale")?map.get("cooperationScale").toString():null);
        bean.setCooperationMode(map.containsKey("cooperationMode")?map.get("cooperationMode").toString():null);
        bean.setAssess(map.containsKey("assess")?map.get("assess").toString():null);
    }

    public static void clone(Partners bean, PartnersBean entity) {
        bean.setId(entity.getId());
        bean.setCorporatName(entity.getCorporatName());
        bean.setCooperationScale(entity.getCooperationScale());
        bean.setCooperationMode(entity.getCooperationMode());
        bean.setAssess(entity.getAssess());
    }
}