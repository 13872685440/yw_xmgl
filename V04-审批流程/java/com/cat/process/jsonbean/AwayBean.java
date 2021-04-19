package com.cat.process.jsonbean;

import com.cat.boot.jsonbean.BaseAppBean;
import com.cat.boot.model.BaseEntity;
import com.cat.boot.service.BaseService;
import com.cat.boot.util.NameQueryUtil;
import com.cat.boot.util.StringUtil;
import com.cat.dictionary.model.Dictionary;
import com.cat.process.model.Away;
import com.cat.project.model.Schedule;
import com.cat.system.model.User;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class AwayBean extends BaseAppBean {

    private static final long serialVersionUID = 7777525968411090290L;

    private String id;

    /** 出差计划与目的 */
    private String plan;
    /** 行程安排 */
    private String scheduling;
    /** 出差成果反馈 */
    private String feedback;
    /** 备注*/
    private String remark;

    /** 同行人员 */
    private List<String> colleagues = new ArrayList<String>();

    private List<String> colleagues_names = new ArrayList<String>();

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getScheduling() {
        return scheduling;
    }

    public void setScheduling(String scheduling) {
        this.scheduling = scheduling;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<String> getColleagues() {
        return colleagues;
    }

    public void setColleagues(List<String> colleagues) {
        this.colleagues = colleagues;
    }

    public List<String> getColleagues_names() {
        return colleagues_names;
    }

    public void setColleagues_names(List<String> colleagues_names) {
        this.colleagues_names = colleagues_names;
    }

    public AwayBean() {}

    public AwayBean(BaseEntity entity) {
        super(entity);
    }

    public static AwayBean setThis(Away entity) {
        AwayBean bean = new AwayBean(entity);
        bean.setId(entity.getId());
        bean.setPlan(entity.getPlan());
        bean.setScheduling(entity.getScheduling());
        bean.setFeedback(entity.getFeedback());
        bean.setRemark(entity.getRemark());
        if(!StringUtil.isSetEmpty(entity.getColleagues())) {
            for (User user : entity.getColleagues()) {
                bean.getColleagues().add(user.getId());
                bean.getColleagues_names().add(user.getName());
            }
        }
        return bean;
    }

    public static List<AwayBean> setThis(List<Away> entitys) {
        List<AwayBean> beans = new ArrayList<>();
        if (!StringUtil.isListEmpty(entitys)) {
            for (Away bean : entitys) {
                beans.add(setThis(bean));
            }
        }
        return beans;
    }

    public static void clone(Away bean, AwayBean entity,BaseService baseService) {
        bean.setId(entity.getId());
        bean.setPlan(entity.getPlan());
        bean.setScheduling(entity.getScheduling());
        bean.setFeedback(entity.getFeedback());
        bean.setRemark(entity.getRemark());
        if (!StringUtil.isListEmpty(entity.getColleagues())) {
            List<User> as = (List<User>) baseService.getList("User", null, true,
                    NameQueryUtil.setParams("id", entity.getColleagues()));
            if (!StringUtil.isListEmpty(as)) {
                bean.getColleagues().clear();
                bean.getColleagues().addAll(as);
            } else {
                bean.setColleagues(null);
            }
        } else {
            bean.setColleagues(null);
        }
    }
}