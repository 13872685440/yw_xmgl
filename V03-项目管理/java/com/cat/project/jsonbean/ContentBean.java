package com.cat.project.jsonbean;

import com.cat.boot.jsonbean.BaseAppBean;
import com.cat.boot.model.BaseEntity;
import com.cat.boot.service.BaseService;
import com.cat.boot.util.StringUtil;
import com.cat.dictionary.model.Dictionary;
import com.cat.project.model.Content;

import java.util.ArrayList;
import java.util.List;

public class ContentBean extends BaseAppBean {

    private static final long serialVersionUID = 7777525968411090290L;

    private String id;
    /** 类型 */
    private int type;
    /** 实体bean关键域值 */
    private String keyValue;
    /** 时间*/
    private String datetime;
    /** 内容 */
    private String content;
    /** 状态编号*/
    private String state_code;
    /** 状态名称 */
    private String state_name;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getState_code() {
        return state_code;
    }

    public void setState_code(String state_code) {
        this.state_code = state_code;
    }

    public String getState_name() {
        return state_name;
    }

    public void setState_name(String state_name) {
        this.state_name = state_name;
    }

    public ContentBean() {}

    public ContentBean(BaseEntity entity) {
        super(entity);
    }

    public static ContentBean setThis(Content entity) {
        ContentBean bean = new ContentBean(entity);
        bean.setId(entity.getId());
        bean.setDatetime(entity.getDatetime());
        bean.setContent(entity.getContent());
        if (entity.getState() != null) {
            bean.setState_code(entity.getState().getCode());
            bean.setState_name(entity.getState().getName());
        }
        return bean;
    }

    public static List<ContentBean> setThis(List<Content> entitys) {
        List<ContentBean> beans = new ArrayList<>();
        if (!StringUtil.isListEmpty(entitys)) {
            for (Content bean : entitys) {
                beans.add(setThis(bean));
            }
        }
        return beans;
    }

    public static void clone(Content bean, ContentBean entity, BaseService baseService) {
        bean.setId(entity.getId());
        bean.setType(entity.getType());
        bean.setKeyValue(entity.getKeyValue());
        bean.setDatetime(entity.getDatetime());
        bean.setContent(entity.getContent());
        bean.setState((Dictionary) baseService.findById(Dictionary.class, entity.getState_code()));
    }
}