package com.cat.daily.jsonbean;

import com.cat.boot.jsonbean.BaseAppBean;
import com.cat.boot.model.BaseEntity;
import com.cat.boot.util.StringUtil;
import com.cat.daily.model.CommonColumn;
import com.cat.daily.model.Daily;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DailyBean extends BaseAppBean {

    private static final long serialVersionUID = 7777525968411090290L;

    private String id;
    /** 标题*/
    private String title;
    /** 内容 */
    private String content;
    /** 日期 (年月日)*/
    private String dailyDate;
    /** 类型(0:每日记事)*/
    private String type;
    /** 是否重要*/
    private Integer isSign;
    /** 日期（日）*/
    private Integer day;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
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

    public String getDailyDate() {
        return dailyDate;
    }

    public void setDailyDate(String dailyDate) {
        this.dailyDate = dailyDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getIsSign() {
        return isSign;
    }

    public void setIsSign(Integer isSign) {
        this.isSign = isSign;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public DailyBean() {}

    public DailyBean(BaseEntity entity) {
        super(entity);
    }

    public static DailyBean setThis(Daily entity) {
        DailyBean bean = new DailyBean(entity);
        bean.setId(entity.getId());
        bean.setTitle(entity.getTitle());
        bean.setContent(entity.getContent());
        bean.setType(entity.getType());
        bean.setDailyDate(entity.getDailyDate());
        bean.setIsSign(entity.isSign()?1:0);
        return bean;
    }

    public static List<DailyBean> setThis(List<Daily> entitys) throws java.text.ParseException {
        List<DailyBean> beans = new ArrayList<>();
        if (!StringUtil.isListEmpty(entitys)) {
            for (Daily entity : entitys) {
                DailyBean bean = setThis(entity);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat d = new SimpleDateFormat("dd");
                bean.setDay(Integer.valueOf(d.format(sdf.parse(entity.getDailyDate()))));
                beans.add(bean);
            }
        }
        return beans;
    }

    public static void clone(Daily bean, DailyBean entity) {
        bean.setId(entity.getId());
        bean.setTitle(entity.getTitle());
        bean.setContent(entity.getContent());
        bean.setType(entity.getType());
        bean.setDailyDate(entity.getDailyDate());
        bean.setSign(entity.getIsSign().equals(1)?true:false);
    }
}