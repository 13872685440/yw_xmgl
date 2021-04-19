package com.cat.project.model;

import com.cat.boot.model.BaseEntity;
import com.cat.dictionary.model.Dictionary;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 项目管理-销售合同
 */
@Entity
@Table(name = "project_contract")
@BatchSize(size = 50)
@DynamicInsert
public class Contract extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2433912044649489682L;
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "system-uuid")
	@Column(length = 40)
	private String id;

	/** 项目跟单ID（如果不关联则为空） */
	@Column(name = "schedule_id",length = 100)
	private String scheduleId;

	/** 项目跟单单号（如果不关联则为空） */
	@Column(name = "schedule_coding",length = 100)
	private String scheduleCoding;

	/** 销售合同号 */
	@Column(length = 100,nullable = false)
	private String coding;

	/** 合同甲方全称 */
	@Column(length = 100,nullable = false)
	private String partyaName;

	/** 项目名称 */
	@Column(length = 4,nullable = false)
	private String projectName;

	/** 销售合同金额*/
	@Column(length = 40,nullable = false)
	private Double money;

	/** 开票金额*/
	@Column(length = 40)
	private Double kpmoney = 0d;

	/** 收款金额*/
	@Column(length = 40)
	private Double skmoney = 0d;

	/** 项目来源 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "source")
	@BatchSize(size = 50)
	private Dictionary source;

	/** 合同质保期*/
	@Column(length = 40)
	private String warranty;

	/** 合同收款次数与金额 */
	@Column(length = 100)
	private String norm;

	/** 最后一次收款时间*/
	@Column(length = 100)
	private String lastskdate;

	/** 合同扫码状态 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "htsm_state")
	@BatchSize(size = 50)
	private Dictionary htsmState;

	/** 发货状态*/
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fh_state")
	@BatchSize(size = 50)
	private Dictionary fhState;

	/** 售中支持状态 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "szzc_state")
	@BatchSize(size = 50)
	private Dictionary szzcState;

	/** 收款状态 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sk_state")
	@BatchSize(size = 50)
	private Dictionary skState;

	/** 开票状态 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "kp_state")
	@BatchSize(size = 50)
	private Dictionary kpState;

	/** 合同结算状态 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "htjs_state")
	@BatchSize(size = 50)
	private Dictionary htjsState;

	/** 是否关联（0=未关联；1=关联采购流程；2=关联售后流程；9=全部关联）*/
	@Column(length = 40)
	private int isRelation = 0;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(String scheduleId) {
		this.scheduleId = scheduleId;
	}

	public String getScheduleCoding() {
		return scheduleCoding;
	}

	public void setScheduleCoding(String scheduleCoding) {
		this.scheduleCoding = scheduleCoding;
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

	public Dictionary getSource() {
		return source;
	}

	public void setSource(Dictionary source) {
		this.source = source;
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

	public String getLastskdate() {
		return lastskdate;
	}

	public void setLastskdate(String lastskdate) {
		this.lastskdate = lastskdate;
	}

	public Dictionary getHtsmState() {
		return htsmState;
	}

	public void setHtsmState(Dictionary htsmState) {
		this.htsmState = htsmState;
	}

	public Dictionary getFhState() {
		return fhState;
	}

	public void setFhState(Dictionary fhState) {
		this.fhState = fhState;
	}

	public Dictionary getSzzcState() {
		return szzcState;
	}

	public void setSzzcState(Dictionary szzcState) {
		this.szzcState = szzcState;
	}

	public Dictionary getSkState() {
		return skState;
	}

	public void setSkState(Dictionary skState) {
		this.skState = skState;
	}

	public Dictionary getKpState() {
		return kpState;
	}

	public void setKpState(Dictionary kpState) {
		this.kpState = kpState;
	}

	public Dictionary getHtjsState() {
		return htjsState;
	}

	public void setHtjsState(Dictionary htjsState) {
		this.htjsState = htjsState;
	}

	public int getIsRelation() {
		return isRelation;
	}

	public void setIsRelation(int isRelation) {
		this.isRelation = isRelation;
	}

	@Override
	public String toString() {
		return this.id;
	}

}
