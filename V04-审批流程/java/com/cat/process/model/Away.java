package com.cat.process.model;

import com.cat.boot.model.BaseEntity;
import com.cat.system.model.User;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 审批流程-出差流程
 */
@Entity
@Table(name = "process_away")
@BatchSize(size = 50)
@DynamicInsert
public class Away extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2433912044649489682L;
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "system-uuid")
	@Column(length = 40)
	private String id;

	/** 出差计划与目的 */
	@Column(length = 512)
	private String plan;

	/** 行程安排 */
	@Column(length = 512)
	private String scheduling;

	/** 组织机构*/
	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@JoinTable(name = "Process_Away_User", joinColumns = {
			@JoinColumn(name = "Away_ID") }, inverseJoinColumns = { @JoinColumn(name = "User_ID") })
	@OrderBy("code")
	@BatchSize(size = 50)
	private Set<User> colleagues = new HashSet<User>();

	/** 出差成果反馈 */
	@Column(length = 512)
	private String feedback;

	/** 备注*/
	@Column(length = 512)
	private String remark;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public String getScheduling() {
		return scheduling;
	}

	public void setScheduling(String scheduling) {
		this.scheduling = scheduling;
	}

	public Set<User> getColleagues() {
		return colleagues;
	}

	public void setColleagues(Set<User> colleagues) {
		this.colleagues = colleagues;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
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
