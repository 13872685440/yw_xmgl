package com.cat.customer.jsonbean;

import com.cat.boot.jsonbean.BaseAppBean;
import com.cat.boot.model.BaseEntity;
import com.cat.boot.service.BaseService;
import com.cat.boot.util.StringUtil;
import com.cat.customer.model.DecisionMaker;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DecisionMakerBean extends BaseAppBean {

    private static final long serialVersionUID = 7777525968411090290L;

    private String id;
    /**关联客户管理实体*/
    private String customer_id;
    /** 姓名*/
    private String name;
    /** 部门*/
    private String department;
    /** 联系方式*/
    private String tel;
    /** 兴趣爱好*/
    private String hobby;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public DecisionMakerBean() {}

    public DecisionMakerBean(BaseEntity entity) {
        super(entity);
    }

    public static DecisionMakerBean setThis(DecisionMaker entity) {
        DecisionMakerBean bean = new DecisionMakerBean(entity);
        bean.setId(entity.getId());
        bean.setCustomer_id(entity.getCustomer().getId());
        bean.setName(entity.getName());
        bean.setDepartment(entity.getDepartment());
        bean.setTel(entity.getTel());
        bean.setHobby(entity.getHobby());
        return bean;
    }

    public static List<DecisionMakerBean> setThis(List<DecisionMaker> entitys) {
        List<DecisionMakerBean> beans = new ArrayList<>();
        if (!StringUtil.isListEmpty(entitys)) {
            for (DecisionMaker entity : entitys) {
                DecisionMakerBean bean = setThis(entity);
                beans.add(bean);
            }
        }
        return beans;
    }

    public static void clone(DecisionMaker bean, Map<String, Object> map) {
        bean.setName(map.containsKey("name")?map.get("name").toString():null);
        bean.setDepartment(map.containsKey("department")?map.get("department").toString():null);
        bean.setTel(map.containsKey("tel")?map.get("tel").toString():null);
        bean.setHobby(map.containsKey("hobby")?map.get("hobby").toString():null);
    }

    public static void clone(DecisionMaker bean, DecisionMakerBean entity) {
        bean.setId(entity.getId());
        bean.setName(entity.getName());
        bean.setDepartment(entity.getDepartment());
        bean.setTel(entity.getTel());
        bean.setHobby(entity.getHobby());
    }
}