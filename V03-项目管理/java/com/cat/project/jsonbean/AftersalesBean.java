package com.cat.project.jsonbean;

import com.cat.boot.jsonbean.BaseAppBean;
import com.cat.boot.model.BaseEntity;
import com.cat.boot.service.BaseService;
import com.cat.boot.util.StringUtil;
import com.cat.dictionary.model.Dictionary;
import com.cat.project.model.Aftersales;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class AftersalesBean extends BaseAppBean {

    private static final long serialVersionUID = 7777525968411090290L;

    private String id;

    /** 售后编码*/
    private String code;
    /** 售后编号*/
    private String coding;
    /** 销售合同ID（如果不关联则为空） */
    private String xsht_id;
    /** 销售合同单号（如果不关联则为空） */
    private String xsht_coding;
    /** 对应项目名称 */
    private String projectName;
    /** 性质 */
    private String nature_code;
    /** 性质 */
    private String nature_name;
    /** 描述*/
    private String describe;
    /** 售后往来状态 */
    private String shlwState_code;
    /** 售后往来状态 */
    private String shlwState_name;
    /** 收款与开票状态 */
    private String skykpState_code;
    /** 收款与开票状态 */
    private String skykpState_name;
    /** 备注 */
    private String remark;


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

    public String getCoding() {
        return coding;
    }

    public void setCoding(String coding) {
        this.coding = coding;
    }

    public String getXsht_id() {
        return xsht_id;
    }

    public void setXsht_id(String xsht_id) {
        this.xsht_id = xsht_id;
    }

    public String getXsht_coding() {
        return xsht_coding;
    }

    public void setXsht_coding(String xsht_coding) {
        this.xsht_coding = xsht_coding;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getNature_code() {
        return nature_code;
    }

    public void setNature_code(String nature_code) {
        this.nature_code = nature_code;
    }

    public String getNature_name() {
        return nature_name;
    }

    public void setNature_name(String nature_name) {
        this.nature_name = nature_name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getShlwState_code() {
        return shlwState_code;
    }

    public void setShlwState_code(String shlwState_code) {
        this.shlwState_code = shlwState_code;
    }

    public String getShlwState_name() {
        return shlwState_name;
    }

    public void setShlwState_name(String shlwState_name) {
        this.shlwState_name = shlwState_name;
    }

    public String getSkykpState_code() {
        return skykpState_code;
    }

    public void setSkykpState_code(String skykpState_code) {
        this.skykpState_code = skykpState_code;
    }

    public String getSkykpState_name() {
        return skykpState_name;
    }

    public void setSkykpState_name(String skykpState_name) {
        this.skykpState_name = skykpState_name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public AftersalesBean() {}

    public AftersalesBean(BaseEntity entity) {
        super(entity);
    }

    public static AftersalesBean setThis(Aftersales entity) {
        AftersalesBean bean = new AftersalesBean(entity);
        bean.setId(entity.getId());
        bean.setCode(entity.getCode());
        bean.setCoding(entity.getCoding());
        bean.setXsht_id(entity.getContractId());
        bean.setXsht_coding(entity.getContractCoding());
        bean.setProjectName(entity.getProjectName());
        if (entity.getNature() != null) {
            bean.setNature_code(entity.getNature().getCode());
            bean.setNature_name(entity.getNature().getName());
        }
        bean.setDescribe(entity.getDescribe());
        bean.setRemark(entity.getRemark());
        if (entity.getShlwState() != null) {
            bean.setShlwState_code(entity.getShlwState().getCode());
            bean.setShlwState_name(entity.getShlwState().getName());
        }
        if (entity.getSkykpState() != null) {
            bean.setSkykpState_code(entity.getSkykpState().getCode());
            bean.setSkykpState_name(entity.getSkykpState().getName());
        }
        return bean;
    }

    public static List<AftersalesBean> setThis(List<Aftersales> entitys) {
        List<AftersalesBean> beans = new ArrayList<>();
        if (!StringUtil.isListEmpty(entitys)) {
            for (Aftersales bean : entitys) {
                beans.add(setThis(bean));
            }
        }
        return beans;
    }

    public static void clone(Aftersales bean, AftersalesBean entity, BaseService baseService) {
        bean.setId(entity.getId());
        bean.setCode(entity.getCode());
        bean.setCoding(entity.getCoding());
        bean.setContractId(entity.getXsht_id());
        bean.setContractCoding(entity.getXsht_coding());
        bean.setProjectName(entity.getProjectName());
        bean.setNature((Dictionary) baseService.findById(Dictionary.class, entity.getNature_code()));
        bean.setDescribe(entity.getDescribe());
        bean.setRemark(entity.getRemark());
        if (StringUtils.isNotEmpty(entity.getShlwState_code())) {
            bean.setShlwState((Dictionary) baseService.findById(Dictionary.class, entity.getShlwState_code()));
        }
        if (StringUtils.isNotEmpty(entity.getSkykpState_code())) {
            bean.setSkykpState((Dictionary) baseService.findById(Dictionary.class, entity.getSkykpState_code()));
        }
    }
}