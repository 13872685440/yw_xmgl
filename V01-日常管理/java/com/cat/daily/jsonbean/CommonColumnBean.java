package com.cat.daily.jsonbean;

import com.cat.boot.jsonbean.BaseAppBean;
import com.cat.boot.model.BaseEntity;
import com.cat.boot.util.StringUtil;
import com.cat.daily.model.CommonColumn;

import java.util.ArrayList;
import java.util.List;

public class CommonColumnBean extends BaseAppBean {

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

    public CommonColumnBean() {}

    public CommonColumnBean(BaseEntity entity) {
        super(entity);
    }

    public static CommonColumnBean setThis(CommonColumn entity) {
        CommonColumnBean bean = new CommonColumnBean(entity);
        bean.setId(entity.getId());
        bean.setTitle(entity.getTitle());
        bean.setContent(entity.getContent());
        return bean;
    }

    public static List<CommonColumnBean> setThis(List<CommonColumn> entitys) {
        List<CommonColumnBean> beans = new ArrayList<>();
        if (!StringUtil.isListEmpty(entitys)) {
            for (CommonColumn entity : entitys) {
                CommonColumnBean bean = setThis(entity);
                beans.add(bean);
            }
        }
        return beans;
    }

    public static void clone(CommonColumn bean, CommonColumnBean entity) {
        bean.setId(entity.getId());
        bean.setTitle(entity.getTitle());
        bean.setContent(entity.getContent());
    }
}