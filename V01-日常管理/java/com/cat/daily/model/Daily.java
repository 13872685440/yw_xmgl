package com.cat.daily.model;

import com.cat.boot.model.BaseEntity;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


/**
 * 日常管理-每日记事
 */

@Entity
@Table(name = "daily_daily")
@BatchSize(size = 50)
@DynamicInsert
public class Daily extends BaseEntity {

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

	/** 内容 */
	@Lob
	@Column
	@Basic(fetch = FetchType.LAZY)
	private String content;

	/** 日期 */
	@Column(length = 40)
	private String dailyDate;

	/** 类型(0:每日记事)*/
	@Column(length = 40)
	private String type;

	/** 是否重要*/
	@Column(length = 40)
	private boolean isSign = false;


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

	public String getDailyDate() {
		return dailyDate;
	}

	public void setDailyDate(String dailyDate) {
		this.dailyDate = dailyDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isSign() {
		return isSign;
	}

	public void setSign(boolean sign) {
		isSign = sign;
	}

	@Override
	public String toString() {
		return this.id;
	}

}
