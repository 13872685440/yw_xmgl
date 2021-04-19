package com.cat.daily.jsonbean;

import com.cat.boot.jsonbean.BaseAppBean;
import com.cat.boot.model.BaseEntity;
import com.cat.boot.util.StringUtil;
import com.cat.daily.model.StaffcColumn;

import java.util.ArrayList;
import java.util.List;

public class StaffcColumnBean extends BaseAppBean {

    private static final long serialVersionUID = 7777525968411090290L;

    private String id;
    /** 序号*/
    private int num;
    /** 标题*/
    private String title;
    /** 内容 */
    private String content;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public StaffcColumnBean() {}

    public StaffcColumnBean(BaseEntity entity) {
        super(entity);
    }

    public static StaffcColumnBean setThis(StaffcColumn entity) {
        StaffcColumnBean bean = new StaffcColumnBean(entity);
        bean.setId(entity.getId());
        bean.setTitle(entity.getTitle());
        bean.setContent(entity.getContent());
        return bean;
    }

    public static List<StaffcColumnBean> setThis(List<StaffcColumn> entitys) {
        List<StaffcColumnBean> beans = new ArrayList<>();
        if (!StringUtil.isListEmpty(entitys)) {
            for (StaffcColumn entity : entitys) {
                StaffcColumnBean bean = setThis(entity);
                beans.add(bean);
            }
        }
        return beans;
    }

    public static void clone(StaffcColumn bean, StaffcColumnBean entity) {
        bean.setId(entity.getId());
        bean.setTitle(entity.getTitle());
        bean.setContent(entity.getContent());
    }
}