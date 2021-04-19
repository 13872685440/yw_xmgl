package com.cat.daily.jsonbean;

import com.cat.boot.jsonbean.BaseAppBean;
import com.cat.boot.model.BaseEntity;
import com.cat.boot.util.StringUtil;
import com.cat.daily.model.Meeting;
import com.cat.daily.model.Staffc;

import java.util.ArrayList;
import java.util.List;

public class StaffcBean extends BaseAppBean {

    private static final long serialVersionUID = 7777525968411090290L;

    /** 姓名*/
    private String name;
    /** 办公电话*/
    private String worktel;
    /** 个人电话*/
    private String phone;
    /** 地址*/
    private String address;
    /** 电子邮件*/
    private String email;
    /** 备注 */
    private String remark;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWorktel() {
        return worktel;
    }

    public void setWorktel(String worktel) {
        this.worktel = worktel;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public StaffcBean() {}

    public StaffcBean(BaseEntity entity) {
        super(entity);
    }

    public static StaffcBean setThis(Staffc entity) {
        StaffcBean bean = new StaffcBean(entity);
        bean.setId(entity.getId());
        bean.setName(entity.getName());
        bean.setWorktel(entity.getWorktel());
        bean.setPhone(entity.getPhone());
        bean.setAddress(entity.getAddress());
        bean.setEmail(entity.getEmail());
        bean.setRemark(entity.getRemark());
        return bean;
    }

    public static List<StaffcBean> setThis(List<Staffc> entitys) {
        List<StaffcBean> beans = new ArrayList<>();
        if (!StringUtil.isListEmpty(entitys)) {
            for (Staffc entity : entitys) {
                StaffcBean bean = setThis(entity);
                beans.add(bean);
            }
        }
        return beans;
    }

    public static void clone(Staffc bean, StaffcBean entity) {
        bean.setId(entity.getId());
        bean.setName(entity.getName());
        bean.setWorktel(entity.getWorktel());
        bean.setPhone(entity.getPhone());
        bean.setAddress(entity.getAddress());
        bean.setEmail(entity.getEmail());
        bean.setRemark(entity.getRemark());
    }
}