package com.cat.customer.model;

import com.cat.boot.model.BaseEntity;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


/**
 * 客户管理-客户管理-决策部门与人员
 */

@Entity
@Table(name = "customer_DecisionMaker")
@BatchSize(size = 50)
@DynamicInsert
public class DecisionMaker extends BaseEntity {

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

	/** 姓名*/
	@Column(length = 100)
	private String name;

	/** 部门*/
	@Column(length = 100)
	private String department;

	/** 联系方式*/
	@Column(length = 100)
	private String tel;

	/** 兴趣爱好*/
	@Column(length = 512)
	private String hobby;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return this.id;
	}

}
