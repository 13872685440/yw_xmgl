package com.cat.project.model;

import com.cat.boot.model.BaseEntity;
import com.cat.dictionary.model.Dictionary;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 项目管理-销售合同-销售合同结算
 */
@Entity
@Table(name = "project_CStatement")
@BatchSize(size = 50)
@DynamicInsert
public class CStatement extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2433912044649489682L;
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "system-uuid")
	@Column(length = 40)
	private String id;

	/**关联销售合同的实体*/
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "contract_id")
	@BatchSize(size = 50)
	private Contract contract;

	/** 销售项目成本*/
	@Column(length = 40)
	private Double salesCost;

	/** 项目利润速算*/
	@Column(length = 40)
	private Double profitVelocity;

	/** 固定成本汇总*/
	@Column(length = 40)
	private Double fixedCSummary;

	/** 货物成本*/
	@Column(length = 40)
	private Double goodsCost;

	/** 合同税务成本*/
	@Column(length = 40)
	private Double contractTaxCost;

	/** 浮动成本汇总*/
	@Column(length = 40)
	private Double floatCSummary;

	/** 差旅成本*/
	@Column(length = 40)
	private Double travelCost;

	/** 货物运输成本*/
	@Column(length = 40)
	private Double transportCost;

	/** 技术支持成本*/
	@Column(length = 40)
	private Double technologyCost;

	/** 其他成本*/
	@Column(length = 40)
	private Double otherCost;

	/** 是否提交（提交后不能编辑）*/
	@Column(length = 40)
	private boolean isSubmit = false;


	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public Double getSalesCost() {
		return salesCost;
	}

	public void setSalesCost(Double salesCost) {
		this.salesCost = salesCost;
	}

	public Double getProfitVelocity() {
		return profitVelocity;
	}

	public void setProfitVelocity(Double profitVelocity) {
		this.profitVelocity = profitVelocity;
	}

	public Double getFixedCSummary() {
		return fixedCSummary;
	}

	public void setFixedCSummary(Double fixedCSummary) {
		this.fixedCSummary = fixedCSummary;
	}

	public Double getGoodsCost() {
		return goodsCost;
	}

	public void setGoodsCost(Double goodsCost) {
		this.goodsCost = goodsCost;
	}

	public Double getContractTaxCost() {
		return contractTaxCost;
	}

	public void setContractTaxCost(Double contractTaxCost) {
		this.contractTaxCost = contractTaxCost;
	}

	public Double getFloatCSummary() {
		return floatCSummary;
	}

	public void setFloatCSummary(Double floatCSummary) {
		this.floatCSummary = floatCSummary;
	}

	public Double getTravelCost() {
		return travelCost;
	}

	public void setTravelCost(Double travelCost) {
		this.travelCost = travelCost;
	}

	public Double getTransportCost() {
		return transportCost;
	}

	public void setTransportCost(Double transportCost) {
		this.transportCost = transportCost;
	}

	public Double getTechnologyCost() {
		return technologyCost;
	}

	public void setTechnologyCost(Double technologyCost) {
		this.technologyCost = technologyCost;
	}

	public Double getOtherCost() {
		return otherCost;
	}

	public void setOtherCost(Double otherCost) {
		this.otherCost = otherCost;
	}

	public boolean isSubmit() {
		return isSubmit;
	}

	public void setSubmit(boolean submit) {
		isSubmit = submit;
	}

	@Override
	public String toString() {
		return this.id;
	}

}
