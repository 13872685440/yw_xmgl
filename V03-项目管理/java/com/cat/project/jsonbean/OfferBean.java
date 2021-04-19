package com.cat.project.jsonbean;

import com.cat.boot.jsonbean.BaseAppBean;
import com.cat.boot.model.BaseEntity;
import com.cat.boot.service.BaseService;
import com.cat.boot.util.StringUtil;
import com.cat.dictionary.model.Dictionary;
import com.cat.project.model.Offer;

import java.util.ArrayList;
import java.util.List;

public class OfferBean extends BaseAppBean {

    private static final long serialVersionUID = 7777525968411090290L;

    private String id;
    /** 类型 */
    private int type;
    /** 实体bean关键域值 */
    private String keyValue;
    /** 时间*/
    private String datetime;
    /** 价格*/
    private Double price;
    /** 比例*/
    private Double ratio;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getRatio() {
        return ratio;
    }

    public void setRatio(Double ratio) {
        this.ratio = ratio;
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

    public OfferBean() {}

    public OfferBean(BaseEntity entity) {
        super(entity);
    }

    public static OfferBean setThis(Offer entity) {
        OfferBean bean = new OfferBean(entity);
        bean.setId(entity.getId());
        bean.setDatetime(entity.getDatetime());
        bean.setRatio(entity.getRatio());
        bean.setPrice(entity.getPrice());
        bean.setContent(entity.getContent());
        if (entity.getState() != null) {
            bean.setState_code(entity.getState().getCode());
            bean.setState_name(entity.getState().getName());
        }
        return bean;
    }

    public static List<OfferBean> setThis(List<Offer> entitys) {
        List<OfferBean> beans = new ArrayList<>();
        if (!StringUtil.isListEmpty(entitys)) {
            for (Offer bean : entitys) {
                beans.add(setThis(bean));
            }
        }
        return beans;
    }

    public static void clone(Offer bean, OfferBean entity, BaseService baseService) {
        bean.setId(entity.getId());
        bean.setType(entity.getType());
        bean.setKeyValue(entity.getKeyValue());
        bean.setPrice(entity.getPrice());
        bean.setDatetime(entity.getDatetime());
        bean.setContent(entity.getContent());
        bean.setState((Dictionary) baseService.findById(Dictionary.class, entity.getState_code()));
    }
}