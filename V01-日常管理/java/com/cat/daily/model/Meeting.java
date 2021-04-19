package com.cat.daily.model;

import com.cat.boot.model.BaseEntity;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


/**
 * 日常管理-部门会议记录
 */

@Entity
@Table(name = "daily_meeting")
@BatchSize(size = 50)
@DynamicInsert
public class Meeting extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2433912044649489682L;
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "system-uuid")
	@Column(length = 40)
	private String id;

	/** 标题*/
	@Column(length = 40)
	private String title;

	/** 会议日期*/
	@Column(length = 100)
	private String meetingDate;

	/** 会议开始时间 */
	@Column(length = 100)
	private String stime;

	/** 会议结束时间 */
	@Column(length = 100)
	private String etime;

	/** 会议主持人 */
	@Column(length = 100)
	private String host;

	/** 会议召开地址*/
	@Column(length = 100)
	private String addr;

	/** 内容 */
	@Lob
	@Column
	@Basic(fetch = FetchType.LAZY)
	private String content;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMeetingDate() {
		return meetingDate;
	}

	public void setMeetingDate(String meetingDate) {
		this.meetingDate = meetingDate;
	}

	public String getStime() {
		return stime;
	}

	public void setStime(String stime) {
		this.stime = stime;
	}

	public String getEtime() {
		return etime;
	}

	public void setEtime(String etime) {
		this.etime = etime;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return this.id;
	}

}
