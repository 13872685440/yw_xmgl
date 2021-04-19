package com.cat.project.model;

import com.cat.boot.model.BaseEntity;
import com.cat.dictionary.model.Dictionary;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 项目管理-采购流程
 */
@Entity
@Table(name = "project_Equipment")
@BatchSize(size = 50)
@DynamicInsert
public class Equipment extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2433912044649489682L;
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "system-uuid")
	@Column(length = 40)
	private String id;

	/** 采购合同编码*/
	@Column(length = 100)
	private String code;

	/** 采购合同号*/
	@Column(length = 100)
	private String coding;

	/** 销售合同ID（如果不关联则为空） */
	@Column(name = "contract_id",length = 100)
	private String contractId;

	/** 销售合同单号（如果不关联则为空） */
	@Column(name = "contract_coding",length = 100)
	private String contractCoding;

	/** 对应项目名称*/
	@Column(length = 100)
	private String projectName;

	 /** 供应商名称*/
	 @Column(length = 100)
	 private String supplierName;

	 /** 采购合同金额*/
	 @Column(length = 100)
	 private Double money;

	 /** 合同质保期*/
	 @Column(length = 100)
	 private String warranty;

	 /** 最后一次付款时间*/
	 @Column(length = 100)
	 private String lastfkdate;

	/** 采购合同扫描状态 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cghtsm_state")
	@BatchSize(size = 50)
	private Dictionary cghtsmState;

	/** 付款与收票状态 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fkysp_state")
	@BatchSize(size = 50)
	private Dictionary fkyspState;

	/** 收货状态 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sh_state")
	@BatchSize(size = 50)
	private Dictionary shState;

	/** 退换货状态 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "thh_state")
	@BatchSize(size = 50)
	private Dictionary thhState;

	public String getId() {
		return id;
	}

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

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public String getContractCoding() {
		return contractCoding;
	}

	public void setContractCoding(String contractCoding) {
		this.contractCoding = contractCoding;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public String getWarranty() {
		return warranty;
	}

	public void setWarranty(String warranty) {
		this.warranty = warranty;
	}

	public String getLastfkdate() {
		return lastfkdate;
	}

	public void setLastfkdate(String lastfkdate) {
		this.lastfkdate = lastfkdate;
	}

	public Dictionary getCghtsmState() {
		return cghtsmState;
	}

	public void setCghtsmState(Dictionary cghtsmState) {
		this.cghtsmState = cghtsmState;
	}

	public Dictionary getFkyspState() {
		return fkyspState;
	}

	public void setFkyspState(Dictionary fkyspState) {
		this.fkyspState = fkyspState;
	}

	public Dictionary getShState() {
		return shState;
	}

	public void setShState(Dictionary shState) {
		this.shState = shState;
	}

	public Dictionary getThhState() {
		return thhState;
	}

	public void setThhState(Dictionary thhState) {
		this.thhState = thhState;
	}

	@Override
	public String toString() {
		return this.id;
	}

}
