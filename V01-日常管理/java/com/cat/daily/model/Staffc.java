package com.cat.daily.model;

import com.cat.boot.model.BaseEntity;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


/**
 * 日常管理-内部通讯（员工）
 */

@Entity
@Table(name = "daily_staffc")
@BatchSize(size = 50)
@DynamicInsert
public class Staffc extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2433912044649489682L;
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "system-uuid")
	@Column(length = 40)
	private String id;

	/** 姓名*/
	@Column(length = 40)
	private String name;

	/** 办公电话*/
	@Column(length = 40)
	private String worktel;

	/** 个人电话*/
	@Column(length = 40)
	private String phone;

	/** 地址*/
	@Column(length = 200)
	private String address;

	/** 电子邮件*/
	@Column(length = 200)
	private String email;

	/** 备注 */
	@Lob
	@Column
	@Basic(fetch = FetchType.LAZY)
	private String remark;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWorktel() {
		return worktel;
	}

	public void setWorktel(String worktel) {
		this.worktel = worktel;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
