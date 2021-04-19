package com.cat.project.model;

import com.cat.boot.model.BaseEntity;
import com.cat.dictionary.model.Dictionary;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 项目管理-售后流程
 */
@Entity
@Table(name = "project_aftersales")
@BatchSize(size = 50)
@DynamicInsert
public class Aftersales extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2433912044649489682L;
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "system-uuid")
	@Column(length = 40)
	private String id;

	/** 售后编码*/
	@Column(length = 100)
	private String code;

	/** 售后编号*/
	@Column(length = 100)
	private String coding;

	/** 销售合同ID（如果不关联则为空） */
	@Column(name = "contract_id",length = 100)
	private String contractId;

	/** 销售合同单号（如果不关联则为空） */
	@Column(name = "contract_coding",length = 100)
	private String contractCoding;

	/** 对应项目名称 */
	@Column(length = 100,nullable = false)
	private String projectName;

	/** 性质 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "nature")
	@BatchSize(size = 50)
	private Dictionary nature;

	/** 描述*/
	@Column(length = 200)
	private String describe;

	/** 售后往来状态 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "shlw_state")
	@BatchSize(size = 50)
	private Dictionary shlwState;

	/** 收款与开票状态 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "skykp_state")
	@BatchSize(size = 50)
	private Dictionary skykpState;

	/** 备注 */
	@Lob
	@Column
	@Basic(fetch = FetchType.LAZY)
	private String remark;

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

	public Dictionary getNature() {
		return nature;
	}

	public void setNature(Dictionary nature) {
		this.nature = nature;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public Dictionary getShlwState() {
		return shlwState;
	}

	public void setShlwState(Dictionary shlwState) {
		this.shlwState = shlwState;
	}

	public Dictionary getSkykpState() {
		return skykpState;
	}

	public void setSkykpState(Dictionary skykpState) {
		this.skykpState = skykpState;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return this.id;
	}

}
