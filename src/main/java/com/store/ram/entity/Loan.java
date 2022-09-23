package com.store.ram.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="loan_table")
public class Loan {
	
	@Id
	private Integer loanId;
	private Double amount;
	
	@JoinColumn(name="id")
	@ManyToOne(cascade=CascadeType.ALL , fetch = FetchType.EAGER)
	private Customer customer;
	public Integer getLoanId() {
		return loanId;
	}
	public void setLoanId(Integer loanId) {
		this.loanId = loanId;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Loan() {
		
	}
	public Loan(Integer loanId, Double amount, Customer customer) {
		
		this.loanId = loanId;
		this.amount = amount;
		this.customer = customer;
	}
	
	
	
}
