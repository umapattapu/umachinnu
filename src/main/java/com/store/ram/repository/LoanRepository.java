package com.store.ram.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.ram.entity.Loan;

public interface LoanRepository extends JpaRepository<Loan, Integer>{
	
	List<Loan> findByLoanId(int loanid);

}
