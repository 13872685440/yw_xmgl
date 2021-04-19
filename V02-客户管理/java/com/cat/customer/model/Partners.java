package com.cat.customer.model;

import com.cat.boot.model.BaseEntity;
import com.cat.dictionary.model.Dictionary;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 客户管理-客户管理-合作伙伴
 */
@Entity
@Table(name = "customer_Partners")
@BatchSize(size = 50)
@DynamicInsert
public class Partners extends BaseEntity {


	private static final long serialVersionUID = 2433912044649489682L;
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "system-uuid")
	@Column(length = 40)
	private String id;

	/**关联客户管理实体*/
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	@BatchSize(size = 50)
	private Customer customer;

	/** 公司名称*/
	@Column(length = 100)
	private String corporatName;

	/** 合作规模*/
	@Column(length = 100)
	private String cooperationScale;

	/** 合作方式*/
	@Column(length = 100)
	private String cooperationMode;

	/** 评估*/
	@Column(length = 100)
	private String assess;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getCorporatName() {
		return corporatName;
	}

	public void setCorporatName(String corporatName) {
		this.corporatName = corporatName;
	}

	public String getCooperationScale() {
		return cooperationScale;
	}

	public void setCooperationScale(String cooperationScale) {
		this.cooperationScale = cooperationScale;
	}

	public String getCooperationMode() {
		return cooperationMode;
	}

	public void setCooperationMode(String cooperationMode) {
		this.cooperationMode = cooperationMode;
	}

	public String getAssess() {
		return assess;
	}

	public void setAssess(String assess) {
		this.assess = assess;
	}

	@Override
	public String toString() {
		return this.id;
	}

}
