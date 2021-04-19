package com.cat.project.model;

import com.cat.boot.model.BaseEntity;
import com.cat.dictionary.model.Dictionary;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 项目管理-支持与报价
 * 		项目跟进（1=售前支持与设计报价）
 * 		销售合同（）
 * 		设备采购（）
 * 		售后（）
 */
@Entity
@Table(name = "project_Offer")
@BatchSize(size = 50)
@DynamicInsert
public class Offer extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2433912044649489682L;
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "system-uuid")
	@Column(length = 40)
	private String id;

	/** 类型(项目跟进（）*/
	@Column(length = 40)
	private int type;

	/** 实体名称*/
	@Column(nullable = false, length = 50)
	private String keyId;

	/** 实体bean关键域值 */
	@Column(nullable = false, length = 50)
	private String keyValue;

	/** 时间*/
	@Column(length = 100)
	private String datetime;

	/** 比例*/
	@Column(length = 100)
	private Double ratio;

	/** 价格*/
	@Column(length = 100)
	private Double price;

	/** 内容 */
	@Lob
	@Column
	@Basic(fetch = FetchType.LAZY)
	private String content;

	/** 状态 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "state")
	@BatchSize(size = 50)
	private Dictionary state;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getKeyId() {
		return keyId;
	}

	public void setKeyId(String keyId) {
		this.keyId = keyId;
	}

	public String getKeyValue() {
		return keyValue;
	}

	public void setKeyValue(String keyValue) {
		this.keyValue = keyValue;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Dictionary getState() {
		return state;
	}

	public void setState(Dictionary state) {
		this.state = state;
	}

	public Double getRatio() {
		return ratio;
	}

	public void setRatio(Double ratio) {
		this.ratio = ratio;
	}

	@Override
	public String toString() {
		return this.id;
	}

}
