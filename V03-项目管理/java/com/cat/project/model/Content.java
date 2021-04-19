package com.cat.project.model;

import com.cat.boot.model.BaseEntity;
import com.cat.dictionary.model.Dictionary;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 项目管理-内容管理
 * 		项目跟进（1=跟单记录；2=成败总结）
 * 		销售合同（3=发货记录；4=售中支持记录）
 * 		设备采购（5=收货记录）
 * 		售后（6=售后来往记录））
 */
@Entity
@Table(name = "project_Content")
@BatchSize(size = 50)
@DynamicInsert
public class Content extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2433912044649489682L;
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "system-uuid")
	@Column(length = 40)
	private String id;

	/** 类型(
	 * 项目跟进（1=跟单记录；2=售前支持与设计报价；3=成败总结）；
	 * 销售合同（4=销售合同扫描；5=发货记录；6=售中支持记录）；
	 * 设备采购（7=采购合同扫描；8=付款与收票记录；9=收货记录；10=退换货记录） ；
	 * 售后（11=售后来往记录；12=收款与开票记录））*/
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Dictionary getState() {
		return state;
	}

	public void setState(Dictionary state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return this.id;
	}

}
