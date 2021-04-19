package com.cat.project.jsonbean;

import com.cat.boot.jsonbean.BaseAppBean;
import com.cat.boot.model.BaseEntity;
import com.cat.boot.service.BaseService;
import com.cat.boot.util.StringUtil;
import com.cat.dictionary.model.Dictionary;
import com.cat.project.model.Contract;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ContractBean extends BaseAppBean {

    private static final long serialVersionUID = 7777525968411090290L;

    private String id;
    /**
     * 项目跟单-ID
     */
    private String xmgd_id;
    /**
     * 项目跟单-跟单号
     */
    private String xmgd_coding;
    /**
     * 销售合同单号
     */
    private String coding;
    /**
     * 合同甲方全称
     */
    private String partyaName;
    /**
     * 项目名称
     */
    private String projectName;
    /**
     * 销售合同金额
     */
    private Double money;
    /**
     * 开票金额
     */
    private Double kpmoney;
    /**
     * 收款金额
     */
    private Double skmoney;
    /**
     * 项目来源编号
     */
    private String source_code;
    /**
     * 项目来源名称
     */
    private String source_name;
    /**
     * 合同质保期
     */
    private String warranty;

    /**
     * 最后一次收款时间
     */
    private String lastskdate;

    /**
     * 合同收款次数与金额
     */
    private String norm;
    /**
     * 合同扫码状态-编号
     */
    private String htsmState_code;
    /**
     * 合同扫码状态-名称
     */
    private String htsmState_name;
    /**
     * 发货状态-编号
     */
    private String fhState_code;
    /**
     * 发货状态-名称
     */
    private String fhState_name;
    /**
     * 售中支持状态 -编号
     */
    private String szzcState_code;
    /**
     * 售中支持状态-名称
     */
    private String szzcState_name;
    /**
     * 收款状态 -编号
     */
    private String skState_code;
    /**
     * 收款状态 -名称
     */
    private String skState_name;
    /**
     * 开票状态 -编号
     */
    private String kpState_code;
    /**
     * 开票状态 -名称
     */
    private String kpState_name;
    /**
     * 合同结算状态 -编号
     */
    private String htjsState_code;
    /**
     * 合同结算状态 -名称
     */
    private String htjsState_name;


    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getXmgd_id() {
        return xmgd_id;
    }

    public void setXmgd_id(String xmgd_id) {
        this.xmgd_id = xmgd_id;
    }

    public String getXmgd_coding() {
        return xmgd_coding;
    }

    public void setXmgd_coding(String xmgd_coding) {
        this.xmgd_coding = xmgd_coding;
    }

    public String getCoding() {
        return coding;
    }

    public void setCoding(String coding) {
        this.coding = coding;
    }

    public String getPartyaName() {
        return partyaName;
    }

    public void setPartyaName(String partyaName) {
        this.partyaName = partyaName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Double getKpmoney() {
        return kpmoney;
    }

    public void setKpmoney(Double kpmoney) {
        this.kpmoney = kpmoney;
    }

    public Double getSkmoney() {
        return skmoney;
    }

    public void setSkmoney(Double skmoney) {
        this.skmoney = skmoney;
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

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public String getNorm() {
        return norm;
    }

    public void setNorm(String norm) {
        this.norm = norm;
    }

    public String getHtsmState_code() {
        return htsmState_code;
    }

    public void setHtsmState_code(String htsmState_code) {
        this.htsmState_code = htsmState_code;
    }

    public String getHtsmState_name() {
        return htsmState_name;
    }

    public void setHtsmState_name(String htsmState_name) {
        this.htsmState_name = htsmState_name;
    }

    public String getFhState_code() {
        return fhState_code;
    }

    public void setFhState_code(String fhState_code) {
        this.fhState_code = fhState_code;
    }

    public String getFhState_name() {
        return fhState_name;
    }

    public void setFhState_name(String fhState_name) {
        this.fhState_name = fhState_name;
    }

    public String getSzzcState_code() {
        return szzcState_code;
    }

    public void setSzzcState_code(String szzcState_code) {
        this.szzcState_code = szzcState_code;
    }

    public String getSzzcState_name() {
        return szzcState_name;
    }

    public void setSzzcState_name(String szzcState_name) {
        this.szzcState_name = szzcState_name;
    }

    public String getSkState_code() {
        return skState_code;
    }

    public void setSkState_code(String skState_code) {
        this.skState_code = skState_code;
    }

    public String getSkState_name() {
        return skState_name;
    }

    public void setSkState_name(String skState_name) {
        this.skState_name = skState_name;
    }

    public String getKpState_code() {
        return kpState_code;
    }

    public void setKpState_code(String kpState_code) {
        this.kpState_code = kpState_code;
    }

    public String getKpState_name() {
        return kpState_name;
    }

    public void setKpState_name(String kpState_name) {
        this.kpState_name = kpState_name;
    }

    public String getHtjsState_code() {
        return htjsState_code;
    }

    public void setHtjsState_code(String htjsState_code) {
        this.htjsState_code = htjsState_code;
    }

    public String getHtjsState_name() {
        return htjsState_name;
    }

    public void setHtjsState_name(String htjsState_name) {
        this.htjsState_name = htjsState_name;
    }

    public String getLastskdate() {
        return lastskdate;
    }

    public void setLastskdate(String lastskdate) {
        this.lastskdate = lastskdate;
    }

    public ContractBean() {
    }

    public ContractBean(BaseEntity entity) {
        super(entity);
    }

    public static ContractBean setThis(Contract entity) {
        ContractBean bean = new ContractBean(entity);
        bean.setId(entity.getId());
        bean.setCoding(entity.getCoding());
        bean.setXmgd_id(entity.getScheduleId());
        bean.setXmgd_coding(entity.getScheduleCoding());
        bean.setPartyaName(entity.getPartyaName());
        bean.setProjectName(entity.getProjectName());
        bean.setMoney(entity.getMoney());
        bean.setKpmoney(entity.getKpmoney());
        bean.setSkmoney(entity.getSkmoney());
        bean.setWarranty(entity.getWarranty());
        bean.setNorm(entity.getNorm());
        bean.setLastskdate(entity.getLastskdate());
        if (entity.getSource() != null) {
            bean.setSource_code(entity.getSource().getCode());
            bean.setSource_name(entity.getSource().getName());
        }
        if (entity.getHtsmState() != null) {
            bean.setHtsmState_code(entity.getHtsmState().getCode());
            bean.setHtsmState_name(entity.getHtsmState().getName());
        }
        if (entity.getFhState() != null) {
            bean.setFhState_code(entity.getFhState().getCode());
            bean.setFhState_name(entity.getFhState().getName());
        }
        if (entity.getSzzcState() != null) {
            bean.setSzzcState_code(entity.getSzzcState().getCode());
            bean.setSzzcState_name(entity.getSzzcState().getName());
        }
        if (entity.getSkState() != null) {
            bean.setSkState_code(entity.getSkState().getCode());
            bean.setSkState_name(entity.getSkState().getName());
        }
        if (entity.getKpState() != null) {
            bean.setKpState_code(entity.getKpState().getCode());
            bean.setKpState_name(entity.getKpState().getName());
        }
        if (entity.getHtjsState() != null) {
            bean.setHtjsState_code(entity.getHtjsState().getCode());
            bean.setHtjsState_name(entity.getHtjsState().getName());
        }
        return bean;
    }

    public static List<ContractBean> setThis(List<Contract> entitys) {
        List<ContractBean> beans = new ArrayList<>();
        if (!StringUtil.isListEmpty(entitys)) {
            for (Contract entity : entitys) {
                beans.add(setThis(entity));
            }
        }
        return beans;
    }

    public static List<ContractBean> setSelect(List<Contract> entitys) {
        List<ContractBean> beans = new ArrayList<>();
        if (!StringUtil.isListEmpty(entitys)) {
            for (Contract entity : entitys) {
                ContractBean bean = new ContractBean();
                bean.setId(entity.getId());
                bean.setCoding(entity.getCoding());
                beans.add(bean);
            }
        }
        return beans;
    }

    public static void clone(Contract bean, ContractBean entity, BaseService baseService) {
        bean.setId(entity.getId());
        bean.setScheduleId(entity.getXmgd_id());
        bean.setScheduleCoding(entity.getXmgd_coding());
        bean.setCoding(entity.getCoding());
        bean.setPartyaName(entity.getPartyaName());
        bean.setProjectName(entity.getProjectName());
        bean.setMoney(entity.getMoney());
        bean.setWarranty(entity.getWarranty());
        bean.setNorm(entity.getNorm());
        bean.setLastskdate(entity.getLastskdate());
        bean.setSource((Dictionary) baseService.findById(Dictionary.class, entity.getSource_code()));
        if (StringUtils.isNotEmpty(entity.getHtsmState_code())) {
            bean.setHtsmState((Dictionary) baseService.findById(Dictionary.class, entity.getHtsmState_code()));
        }
        if (StringUtils.isNotEmpty(entity.getFhState_code())) {
            bean.setFhState((Dictionary) baseService.findById(Dictionary.class, entity.getFhState_code()));
        }
        if (StringUtils.isNotEmpty(entity.getSzzcState_code())) {
            bean.setSzzcState((Dictionary) baseService.findById(Dictionary.class, entity.getSzzcState_code()));
        }
        if (StringUtils.isNotEmpty(entity.getSkState_code())) {
            bean.setSkState((Dictionary) baseService.findById(Dictionary.class, entity.getSkState_code()));
        }
        if (StringUtils.isNotEmpty(entity.getKpState_code())) {
            bean.setKpState((Dictionary) baseService.findById(Dictionary.class, entity.getKpState_code()));
        }
        if (StringUtils.isNotEmpty(entity.getHtjsState_code())) {
            bean.setHtjsState((Dictionary) baseService.findById(Dictionary.class, entity.getHtjsState_code()));
        }
    }
}