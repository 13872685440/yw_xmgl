package com.cat.project.jsonbean;

import com.cat.boot.jsonbean.BaseAppBean;
import com.cat.boot.model.BaseEntity;
import com.cat.boot.service.BaseService;
import com.cat.boot.util.StringUtil;
import com.cat.dictionary.model.Dictionary;
import com.cat.project.model.Schedule;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ScheduleBean extends BaseAppBean {

    private static final long serialVersionUID = 7777525968411090290L;

    private String id;

    /** 编号*/
    private String code;
    /** 跟单号 */
    private String coding;
    /** 客户公司名称 */
    private String companyName;
    /** 项目名称 */
    private String projectName;
    /** 项目负责人 */
    private String directorName;
    /** 项目负责人联系方式*/
    private String directorPhone;
    /** 项目来源编号*/
    private String source_code;
    /** 项目来源名称 */
    private String source_name;

    /** 跟单记录状态编码 */
    private String gdjlState_code;
    /** 跟单记录状态编名称*/
    private String gdjlState_name;
    /** 售前支持与设计报价状态编码 */
    private String zsbjState_code;
    /** 售前支持与设计报价状态名称 */
    private String zsbjState_name;
    /** 成败总结状态编码*/
    private String cbzjState_code;
    /** 成败总结状态名称 */
    private String cbzjState_name;

    /** 销售合同号（如果销售合同中关联后回填到此字段）*/
    private String xshtCodding;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getSource_code() {
        return source_code;
    }

    public void setSource_code(String source_code) {
        this.source_code = source_code;
    }

    public String getSource_name() {
        return source_name;
    }

    public void setSource_name(String source_name) {
        this.source_name = source_name;
    }

    public String getDirectorPhone() {
        return directorPhone;
    }

    public void setDirectorPhone(String directorPhone) {
        this.directorPhone = directorPhone;
    }

    public String getCoding() {
        return coding;
    }

    public void setCoding(String coding) {
        this.coding = coding;
    }

    public String getGdjlState_code() {
        return gdjlState_code;
    }

    public void setGdjlState_code(String gdjlState_code) {
        this.gdjlState_code = gdjlState_code;
    }

    public String getGdjlState_name() {
        return gdjlState_name;
    }

    public void setGdjlState_name(String gdjlState_name) {
        this.gdjlState_name = gdjlState_name;
    }

    public String getZsbjState_code() {
        return zsbjState_code;
    }

    public void setZsbjState_code(String zsbjState_code) {
        this.zsbjState_code = zsbjState_code;
    }

    public String getZsbjState_name() {
        return zsbjState_name;
    }

    public void setZsbjState_name(String zsbjState_name) {
        this.zsbjState_name = zsbjState_name;
    }

    public String getCbzjState_code() {
        return cbzjState_code;
    }

    public void setCbzjState_code(String cbzjState_code) {
        this.cbzjState_code = cbzjState_code;
    }

    public String getCbzjState_name() {
        return cbzjState_name;
    }

    public void setCbzjState_name(String cbzjState_name) {
        this.cbzjState_name = cbzjState_name;
    }

    public String getXshtCodding() {
        return xshtCodding;
    }

    public void setXshtCodding(String xshtCodding) {
        this.xshtCodding = xshtCodding;
    }

    public ScheduleBean() {}

    public ScheduleBean(BaseEntity entity) {
        super(entity);
    }

    public static ScheduleBean setThis(Schedule entity) {
        ScheduleBean bean = new ScheduleBean(entity);
        bean.setId(entity.getId());
        bean.setCode(entity.getCode());
        bean.setCoding(entity.getCoding());
        bean.setCompanyName(entity.getCompanyName());
        bean.setProjectName(entity.getProjectName());
        bean.setDirectorName(entity.getDirectorName());
        bean.setDirectorPhone(entity.getDirectorPhone());
        bean.setXshtCodding(entity.getContractCodding());
        if (entity.getSource() != null) {
            bean.setSource_code(entity.getSource().getCode());
            bean.setSource_name(entity.getSource().getName());
        }
        if(entity.getGdjlState()!=null) {
            bean.setGdjlState_code(entity.getGdjlState().getCode());
            bean.setGdjlState_name(entity.getGdjlState().getName());
        }
        if(entity.getZsbjState()!=null) {
            bean.setZsbjState_code(entity.getZsbjState().getCode());
            bean.setZsbjState_name(entity.getZsbjState().getName());
        }
        if(entity.getCbzjState()!=null) {
            bean.setCbzjState_code(entity.getCbzjState().getCode());
            bean.setCbzjState_name(entity.getCbzjState().getName());
        }
        return bean;
    }

    public static List<ScheduleBean> setThis(List<Schedule> entitys) {
        List<ScheduleBean> beans = new ArrayList<>();
        if (!StringUtil.isListEmpty(entitys)) {
            for (Schedule bean : entitys) {
                beans.add(setThis(bean));
            }
        }
        return beans;
    }

    public static List<ScheduleBean> setSelect(List<Schedule> entitys) {
        List<ScheduleBean> beans = new ArrayList<>();
        if (!StringUtil.isListEmpty(entitys)) {
            for (Schedule entity : entitys) {
                ScheduleBean bean = new ScheduleBean();
                bean.setId(entity.getId());
                bean.setCoding(entity.getCoding());
                beans.add(bean);
            }
        }
        return beans;
    }

    public static void clone(Schedule bean, ScheduleBean entity, BaseService baseService) {
        bean.setId(entity.getId());
        bean.setCompanyName(entity.getCompanyName());
        bean.setProjectName(entity.getProjectName());
        bean.setDirectorName(entity.getDirectorName());
        bean.setDirectorPhone(entity.getDirectorPhone());
        bean.setSource((Dictionary) baseService.findById(Dictionary.class, entity.getSource_code()));
        if (StringUtils.isNotEmpty(entity.getGdjlState_code())) {
            bean.setGdjlState((Dictionary) baseService.findById(Dictionary.class, entity.getGdjlState_code()));
        }
        if (StringUtils.isNotEmpty(entity.getZsbjState_code())) {
            bean.setZsbjState((Dictionary) baseService.findById(Dictionary.class,entity.getZsbjState_code()));
        }
        if (StringUtils.isNotEmpty(entity.getCbzjState_code())) {
            bean.setCbzjState((Dictionary) baseService.findById(Dictionary.class,entity.getCbzjState_code()));
        }
    }
}