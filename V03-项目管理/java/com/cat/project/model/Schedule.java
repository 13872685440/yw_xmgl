package com.cat.project.model;

import com.cat.boot.model.BaseEntity;
import com.cat.dictionary.model.Dictionary;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 项目管理-项目跟进
 */
@Entity
@Table(name = "project_schedule")
@BatchSize(size = 50)
@DynamicInsert
public class Schedule extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2433912044649489682L;
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "system-uuid")
	@Column(length = 40)
	private String id;

	/** 编号*/
	@Column(length = 40)
	private String code;

	/** 跟单号 */
	@Column(length = 100)
	private String coding;

	/** 客户公司名称 */
	@Column(length = 100)
	private String companyName;

	/** 项目名称 */
	@Column(length = 100)
	private String projectName;

	/** 项目负责人 */
	@Column(length = 40)
	private String directorName;

	/** 项目负责人联系方式*/
	@Column(length = 40)
	private String directorPhone;

	/** 项目来源 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "source")
	@BatchSize(size = 50)
	private Dictionary source;


	/** 跟单记录状态 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "gdjl_state")
	@BatchSize(size = 50)
	private Dictionary gdjlState;

	/** 售前支持与设计报价状态 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "zsbj_state")
	@BatchSize(size = 50)
	private Dictionary zsbjState;

	/** 成败总结状态 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cbzj_state")
	@BatchSize(size = 50)
	private Dictionary cbzjState;

	/** 销售合同ID（如果销售合同中关联后回填到此字段）*/
	@Column(length = 100)
	private String contractId;

	/** 销售合同号（如果销售合同中关联后回填到此字段）*/
	@Column(length = 100)
	private String contractCodding;

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

	public String getDirectorPhone() {
		return directorPhone;
	}

	public void setDirectorPhone(String directorPhone) {
		this.directorPhone = directorPhone;
	}

	public Dictionary getSource() {
		return source;
	}

	public void setSource(Dictionary source) {
		this.source = source;
	}

	public String getCoding() {
		return coding;
	}

	public void setCoding(String coding) {
		this.coding = coding;
	}

	public Dictionary getGdjlState() {
		return gdjlState;
	}

	public void setGdjlState(Dictionary gdjlState) {
		this.gdjlState = gdjlState;
	}

	public Dictionary getZsbjState() {
		return zsbjState;
	}

	public void setZsbjState(Dictionary zsbjState) {
		this.zsbjState = zsbjState;
	}

	public Dictionary getCbzjState() {
		return cbzjState;
	}

	public void setCbzjState(Dictionary cbzjState) {
		this.cbzjState = cbzjState;
	}

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public String getContractCodding() {
		return contractCodding;
	}

	public void setContractCodding(String contractCodding) {
		this.contractCodding = contractCodding;
	}

	@Override
	public String toString() {
		return this.id;
	}

	public Schedule(){}

	public Schedule(String id) {
		this.id = id;
	}
}
