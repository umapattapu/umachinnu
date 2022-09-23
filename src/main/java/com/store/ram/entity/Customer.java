package com.store.ram.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ram_store")
public class Customer {
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Integer id;
	  @Column(name = "Name")
      private String name;
	  @Column(name = "Department")
      private String department;
	  @Column(name = "mobile")
      private long mobile;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", department=" + department + ", mobile=" + mobile + "]";
	}
	public Customer(String name, String department, long mobile) {
		this.name = name;
		this.department = department;
		this.mobile = mobile;
	}
	public Customer() {
		
	}
      
      
}
