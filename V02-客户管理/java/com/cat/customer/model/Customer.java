package com.cat.customer.model;

import com.cat.boot.model.BaseEntity;
import com.cat.dictionary.model.Dictionary;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;


/**
 * 客户管理-客户管理
 */

@Entity
@Table(name = "customer_Customer")
@BatchSize(size = 50)
@DynamicInsert
public class Customer extends BaseEntity {

	private static final long serialVersionUID = 2433912044649489682L;

	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "system-uuid")
	@Column(length = 40)
	private String id;

	/** 公司名称*/
	@Column(length = 100)
	private String corporatName;

	/** 所属业务员*/
	@Column(length = 100)
	private String salesman;

	/** 地址*/
	@Column(length = 100)
	private String addr;

	/** 注册资金*/
	@Column(length = 100)
	private String registerCapital;

	/** 成立日期*/
	@Column(length = 100)
	private String establishDate;

	/** 法定代表人*/
	@Column(length = 100)
	private String legalPerson;

	/** 企业网站*/
	@Column(length = 100)
	private String enterpriseWebsite;

	/** 企业规模（人数）*/
	@Column(length = 100)
	private Integer enterpriseScale;

	/** 所属行业*/
	@Column(length = 100)
	private String industry;

	/** 在所属行业位置*/
	@Column(length = 100)
	private String industryPosition;

	/** 客户分级*/
	@Column(length = 100)
	private String customerRating;

	/** 主要业务方向*/
	@Column(length = 512)
	private String businessDirection;

	/** 相关成功案例*/
	@Column(length = 512)
	private String successCase;

	/** 与我司相关业务范畴*/
	@Column(length = 512)
	private String businessScope;

	/** 客户年AV采购额预估*/
	@Column(length = 100)
	private String avEstimate;

	/** 客户从我司采购额预估*/
	@Column(length = 100)
	private String myEstimate;

	/** 近期合作目标*/
	@Column(length = 512)
	private String nearCooTtarget;

	/** 远期合作目标*/
	@Column(length = 512)
	private String farCooTtarget;

	/** 公司组织架构图(部门负责人及联系方式)*/
	@Column(length = 512)
	private String framework;

	/** 部门负责人*/
	@Column(length = 100)
	private String depHead;

	/** 部门负责人联系方式*/
	@Column(length = 100)
	private String depHeadTel;

	/** 备注*/
	@Column(length = 512)
	private String remark;

	@Transient
	private String key;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return this.id;
	}

}
