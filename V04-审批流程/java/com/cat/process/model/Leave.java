package com.cat.process.model;

import com.cat.boot.model.BaseEntity;
import com.cat.dictionary.model.Dictionary;
import com.cat.system.model.PostInformation;
import com.cat.system.model.User;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 审批流程-请假流程
 */
@Entity
@Table(name = "process_leave")
@BatchSize(size = 50)
@DynamicInsert
public class Leave extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2433912044649489682L;
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "system-uuid")
	@Column(length = 40)
	private String id;

	/** 请假类型 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "leavetype")
	@BatchSize(size = 50)
	private Dictionary leavetType;

	/** 开始日期 */
	@Column(length = 100)
	private String startDate;

	/** 开始时间(上午) */
	@Column(length = 100)
	private String startTime;

	/** 结束日期 */
	@Column(length = 512)
	private String endDate;

	/** 开始时间(下午) */
	@Column(length = 100)
	private String endTime;

	/** 请假时长 */
	@Column(length = 512)
	private String duration;

	/** 说明 */
	@Column(length = 512)
	private String explain;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Dictionary getLeavetType() {
		return leavetType;
	}

	public void setLeavetType(Dictionary leavetType) {
		this.leavetType = leavetType;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getExplain() {
		return explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}

	@Override
	public String toString() {
		return this.id;
	}

}
