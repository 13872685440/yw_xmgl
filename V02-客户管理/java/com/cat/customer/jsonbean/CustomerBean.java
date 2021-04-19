package com.cat.customer.jsonbean;

import com.cat.boot.jsonbean.BaseAppBean;
import com.cat.boot.model.BaseEntity;
import com.cat.boot.service.BaseService;
import com.cat.boot.util.StringUtil;
import com.cat.customer.model.Customer;
import com.cat.dictionary.model.Dictionary;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CustomerBean extends BaseAppBean {

    private static final long serialVersionUID = 7777525968411090290L;

    private String id;
    /** 公司名称*/
    private String corporatName;
    /** 所属业务员*/
    private String salesman;
    /** 地址*/
    private String addr;
    /** 注册资金*/
    private String registerCapital;
    /** 成立日期*/
    private String establishDate;
    /** 法定代表人*/
    private String legalPerson;
    /** 企业网站*/
    private String enterpriseWebsite;
    /** 企业规模（人数）*/
   private Integer enterpriseScale;
    /** 所属行业*/
    private String industry;
    /** 在所属行业位置*/
    private String industryPosition;
    /** 客户分级*/
    private String customerRating;
    /** 主要业务方向*/
    private String businessDirection;
    /** 相关成功案例*/
    private String successCase;
    /** 与我司相关业务范畴*/
    private String businessScope;
    /** 客户年AV采购额预估*/
    private String avEstimate;
    /** 客户从我司采购额预估*/
    private String myEstimate;
    /** 近期合作目标*/
    private String nearCooTtarget;
    /** 远期合作目标*/
    private String farCooTtarget;
    /** 公司组织架构图(部门负责人及联系方式)*/
    private String framework;
    /** 部门负责人*/
    private String depHead;
    /** 部门负责人联系方式*/
    private String depHeadTel;
    /** 备注*/
    private String remark;

    public String getCorporatName() {
        return corporatName;
    }

    public void setCorporatName(String corporatName) {
        this.corporatName = corporatName;
    }

    public String getSalesman() {
        return salesman;
    }

    public void setSalesman(String salesman) {
        this.salesman = salesman;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getRegisterCapital() {
        return registerCapital;
    }

    public void setRegisterCapital(String registerCapital) {
        this.registerCapital = registerCapital;
    }

    public String getEstablishDate() {
        return establishDate;
    }

    public void setEstablishDate(String establishDate) {
        this.establishDate = establishDate;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public String getEnterpriseWebsite() {
        return enterpriseWebsite;
    }

    public void setEnterpriseWebsite(String enterpriseWebsite) {
        this.enterpriseWebsite = enterpriseWebsite;
    }

    public Integer getEnterpriseScale() {
        return enterpriseScale;
    }

    public void setEnterpriseScale(Integer enterpriseScale) {
        this.enterpriseScale = enterpriseScale;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getIndustryPosition() {
        return industryPosition;
    }

    public void setIndustryPosition(String industryPosition) {
        this.industryPosition = industryPosition;
    }

    public String getCustomerRating() {
        return customerRating;
    }

    public void setCustomerRating(String customerRating) {
        this.customerRating = customerRating;
    }

    public String getBusinessDirection() {
        return businessDirection;
    }

    public void setBusinessDirection(String businessDirection) {
        this.businessDirection = businessDirection;
    }

    public String getSuccessCase() {
        return successCase;
    }

    public void setSuccessCase(String successCase) {
        this.successCase = successCase;
    }

    public String getBusinessScope() {
        return businessScope;
    }

    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope;
    }

    public String getAvEstimate() {
        return avEstimate;
    }

    public void setAvEstimate(String avEstimate) {
        this.avEstimate = avEstimate;
    }

    public String getMyEstimate() {
        return myEstimate;
    }

    public void setMyEstimate(String myEstimate) {
        this.myEstimate = myEstimate;
    }

    public String getNearCooTtarget() {
        return nearCooTtarget;
    }

    public void setNearCooTtarget(String nearCooTtarget) {
        this.nearCooTtarget = nearCooTtarget;
    }

    public String getFarCooTtarget() {
        return farCooTtarget;
    }

    public void setFarCooTtarget(String farCooTtarget) {
        this.farCooTtarget = farCooTtarget;
    }

    public String getFramework() {
        return framework;
    }

    public void setFramework(String framework) {
        this.framework = framework;
    }

    public String getDepHead() {
        return depHead;
    }

    public void setDepHead(String depHead) {
        this.depHead = depHead;
    }

    public String getDepHeadTel() {
        return depHeadTel;
    }

    public void setDepHeadTel(String depHeadTel) {
        this.depHeadTel = depHeadTel;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }



    public CustomerBean() {}

    public CustomerBean(BaseEntity entity) {
        super(entity);
    }

    public static CustomerBean setThis(Customer entity) {
        CustomerBean bean = new CustomerBean(entity);
        bean.setId(entity.getId());
        bean.setCorporatName(entity.getCorporatName());
        bean.setSalesman(entity.getSalesman());
        bean.setAddr(entity.getAddr());
        bean.setRegisterCapital(entity.getRegisterCapital());
        bean.setEstablishDate(entity.getEstablishDate());
        bean.setLegalPerson(entity.getLegalPerson());
        bean.setEnterpriseWebsite(entity.getEnterpriseWebsite());
        bean.setEnterpriseScale(entity.getEnterpriseScale());
        bean.setIndustry(entity.getIndustry());
        bean.setIndustryPosition(entity.getIndustryPosition());
        bean.setCustomerRating(entity.getCustomerRating());
        bean.setBusinessDirection(entity.getBusinessDirection());
        bean.setSuccessCase(entity.getSuccessCase());
        bean.setBusinessScope(entity.getBusinessScope());
        bean.setAvEstimate(entity.getAvEstimate());
        bean.setMyEstimate(entity.getMyEstimate());
        bean.setNearCooTtarget(entity.getNearCooTtarget());
        bean.setFarCooTtarget(entity.getFarCooTtarget());
        bean.setFramework(entity.getFramework());
        bean.setDepHead(entity.getDepHead());
        bean.setDepHeadTel(entity.getDepHeadTel());
        bean.setRemark(entity.getRemark());
        return bean;
    }



    public static List<CustomerBean> setThis(List<Customer> entitys) {
        List<CustomerBean> beans = new ArrayList<>();
        if (!StringUtil.isListEmpty(entitys)) {
            for (Customer entity : entitys) {
                CustomerBean bean = setThis(entity);
                beans.add(bean);
            }
        }
        return beans;
    }

    public static void clone(Customer entity,Map<String, Object> map) {
        entity.setKey(map.containsKey("key")?map.get("key").toString():null);
        entity.setCorporatName(map.containsKey("corporatName")?map.get("corporatName").toString():null);
        entity.setSalesman(map.containsKey("salesman")?map.get("salesman").toString():null);
        entity.setAddr(map.containsKey("addr")?map.get("addr").toString():null);
        entity.setRegisterCapital(map.containsKey("registerCapital")?map.get("registerCapital").toString():null);
        entity.setEstablishDate(map.containsKey("establishDate")?map.get("establishDate").toString():null);
        entity.setLegalPerson(map.containsKey("legalPerson")?map.get("legalPerson").toString():null);
        entity.setEnterpriseWebsite(map.containsKey("enterpriseWebsite")?map.get("enterpriseWebsite").toString():null);
        entity.setEnterpriseScale(map.containsKey("enterpriseScale")?Integer.valueOf(map.get("enterpriseScale").toString()):null);
        entity.setIndustry(map.containsKey("industry")?map.get("industry").toString():null);
        entity.setIndustryPosition(map.containsKey("industryPosition")?map.get("industryPosition").toString():null);
        entity.setCustomerRating(map.containsKey("customerRating")?map.get("customerRating").toString():null);
        entity.setBusinessDirection(map.containsKey("businessDirection")?map.get("businessDirection").toString():null);
        entity.setSuccessCase(map.containsKey("successCase")?map.get("successCase").toString():null);
        entity.setBusinessScope(map.containsKey("businessScope")?map.get("businessScope").toString():null);
        entity.setAvEstimate(map.containsKey("avEstimate")?map.get("avEstimate").toString():null);
        entity.setMyEstimate(map.containsKey("myEstimate")?map.get("myEstimate").toString():null);
        entity.setNearCooTtarget(map.containsKey("nearCooTtarget")?map.get("nearCooTtarget").toString():null);
        entity.setFarCooTtarget(map.containsKey("farCooTtarget")?map.get("farCooTtarget").toString():null);
        entity.setFramework(map.containsKey("framework")?map.get("framework").toString():null);
        entity.setDepHead(map.containsKey("depHead")?map.get("depHead").toString():null);
        entity.setDepHeadTel(map.containsKey("depHeadTel")?map.get("depHeadTel").toString():null);
        entity.setRemark(map.containsKey("remark")?map.get("remark").toString():null);
    }

    public static void clone(Customer bean, CustomerBean entity, BaseService baseService) {
        bean.setId(entity.getId());
        bean.setCorporatName(entity.getCorporatName());
        bean.setSalesman(entity.getSalesman());
        bean.setAddr(entity.getAddr());
        bean.setRegisterCapital(entity.getRegisterCapital());
        bean.setEstablishDate(entity.getEstablishDate());
        bean.setLegalPerson(entity.getLegalPerson());
        bean.setEnterpriseWebsite(entity.getEnterpriseWebsite());
        bean.setEnterpriseScale(entity.getEnterpriseScale());
        bean.setIndustry(entity.getIndustry());
        bean.setIndustryPosition(entity.getIndustryPosition());
        bean.setCustomerRating(entity.getCustomerRating());
        bean.setBusinessDirection(entity.getBusinessDirection());
        bean.setSuccessCase(entity.getSuccessCase());
        bean.setBusinessScope(entity.getBusinessScope());
        bean.setAvEstimate(entity.getAvEstimate());
        bean.setMyEstimate(entity.getMyEstimate());
        bean.setNearCooTtarget(entity.getNearCooTtarget());
        bean.setFarCooTtarget(entity.getFarCooTtarget());
        bean.setFramework(entity.getFramework());
        bean.setDepHead(entity.getDepHead());
        bean.setDepHeadTel(entity.getDepHeadTel());
        bean.setRemark(entity.getRemark());
    }
}