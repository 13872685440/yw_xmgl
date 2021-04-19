package com.cat.project.jsonbean;

import com.cat.boot.jsonbean.BaseAppBean;
import com.cat.boot.util.StringUtil;
import com.cat.project.model.CStatement;
import com.cat.project.model.Contract;

import java.util.ArrayList;
import java.util.List;


/**
 * 项目管理-销售合同-销售合同结算
 */
public class CStatementBean extends BaseAppBean {

	private static final long serialVersionUID = 2433912044649489682L;

	private String id;

	/** 销售合同单号 */
	private String c_id;
	/** 销售合同单号 */
	private String coding;
	/** 合同甲方全称 */
	private String partyaName;
	/** 项目名称 */
	private String projectName;
	/** 销售合同金额 */
	private Double money;
	/** 项目来源编号*/
	private String source_code;
	/** 项目来源名称 */
	private String source_name;

	/** 销售项目成本*/
	private Double salesCost;
	/** 项目利润速算*/
	private Double profitVelocity;

	/** 固定成本汇总*/
	private Double fixedCSummary;
	/** 货物成本*/
	private Double goodsCost;
	/** 合同税务成本*/
	private Double contractTaxCost;

	/** 浮动成本汇总*/
	private Double floatCSummary;
	/** 差旅成本*/
	private Double travelCost;
	/** 货物运输成本*/
	private Double transportCost;
	/** 技术支持成本*/
	private Double technologyCost;
	/** 其他成本*/
	private Double otherCost;

	/** 是否提交（提交后不能编辑）*/
	private Integer submitNot;

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	public String getC_id() {
		return c_id;
	}

	public void setC_id(String c_id) {
		this.c_id = c_id;
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

	public Integer getSubmitNot() {
		return submitNot;
	}

	public void setSubmitNot(Integer submitNot) {
		this.submitNot = submitNot;
	}

	public static CStatementBean setThis(CStatement entity) {
		CStatementBean bean = new CStatementBean();
		bean.setId(entity.getId());
		bean.setC_id(entity.getContract().getId());
		bean.setCoding(entity.getContract().getCoding());
		bean.setPartyaName(entity.getContract().getPartyaName());
		bean.setProjectName(entity.getContract().getProjectName());
		bean.setMoney(entity.getContract().getMoney());
		if (entity.getContract().getSource() != null) {
			bean.setSource_code(entity.getContract().getSource().getCode());
			bean.setSource_name(entity.getContract().getSource().getName());
		}
		bean.setGoodsCost(entity.getGoodsCost());
		bean.setContractTaxCost(entity.getContractTaxCost());
		bean.setTravelCost(entity.getTravelCost());
		bean.setTransportCost(entity.getTransportCost());
		bean.setTechnologyCost(entity.getTechnologyCost());
		bean.setOtherCost(entity.getOtherCost());
		bean.setSalesCost(entity.getSalesCost());
		bean.setProfitVelocity(entity.getProfitVelocity());
		bean.setFixedCSummary(entity.getFixedCSummary());
		bean.setFloatCSummary(entity.getFloatCSummary());
		bean.setSubmitNot(entity.isSubmit()?1:0);
		return bean;
	}

	public static CStatementBean setThis(Contract entity) {
		CStatementBean bean = new CStatementBean();
		bean.setC_id(entity.getId());
		bean.setCoding(entity.getCoding());
		bean.setPartyaName(entity.getPartyaName());
		bean.setProjectName(entity.getProjectName());
		bean.setMoney(entity.getMoney());
		if (entity.getSource() != null) {
			bean.setSource_code(entity.getSource().getCode());
			bean.setSource_name(entity.getSource().getName());
		}
		return bean;
	}

	public static List<CStatementBean> setThis(List<CStatement> entitys) {
		List<CStatementBean> beans = new ArrayList<>();
		if (!StringUtil.isListEmpty(entitys)) {
			for (CStatement bean : entitys) {
				beans.add(setThis(bean));
			}
		}
		return beans;
	}

	public static void clone(CStatement bean, CStatementBean entity) {
		bean.setId(entity.getId());
		bean.setGoodsCost(entity.getGoodsCost());
		bean.setContractTaxCost(entity.getContractTaxCost());
		bean.setTravelCost(entity.getTravelCost());
		bean.setTransportCost(entity.getTransportCost());
		bean.setTechnologyCost(entity.getTechnologyCost());
		bean.setOtherCost(entity.getOtherCost());
		bean.setSalesCost(entity.getSalesCost());
		bean.setProfitVelocity(entity.getProfitVelocity());
		bean.setFixedCSummary(entity.getFixedCSummary());
		bean.setFloatCSummary(entity.getFloatCSummary());
		bean.setSubmit(entity.getSubmitNot()==1?true:false);
	}
}
