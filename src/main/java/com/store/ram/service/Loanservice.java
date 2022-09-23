package com.store.ram.service;

import java.util.List;
import java.util.Optional;

import com.store.ram.DTO.CustomerDTO;
import com.store.ram.DTO.LoanDTO;
import com.store.ram.entity.Loan;
import com.store.ram.exception.RamStoreException;

public interface Loanservice {
	public List<LoanDTO> getAll() throws RamStoreException  ;
	public LoanDTO getCustomer(Integer loanId) throws RamStoreException ;
	public String deleteByID(Integer loanId) throws RamStoreException ;
	public LoanDTO AddCustomer(LoanDTO c)throws RamStoreException ;
	//public LoanDTO upDateLoanDetails(Integer id,String department)throws RamStoreException;


}
