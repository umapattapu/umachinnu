package com.store.ram.DTO;

import com.store.ram.entity.Customer;

public class LoanDTO {
	private Integer loanId;
	private Double amount;
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
	public LoanDTO(Integer loanId, Double amount, Customer customer) {
		this.loanId = loanId;
		this.amount = amount;
		this.customer = customer;
	}
	public LoanDTO() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "LoanDTO [loanId=" + loanId + ", amount=" + amount + ", customer=" + customer + "]";
	}
	
	
}
