 package com.store.ram.api;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.ram.DTO.LoanDTO;
import com.store.ram.entity.Loan;
import com.store.ram.exception.RamStoreException;
import com.store.ram.service.ServiceImpl;
import com.store.ram.service.ServiceImpl;

@RestController
@RequestMapping(path="loan-api")
public class Urls {
	
	@Autowired
	private ServiceImpl SI; 
	
	@Autowired
	private ServiceImpl lsi;
	
	/**
	@PutMapping(path = "loandetails/{id}")
	public ResponseEntity<LoanDTO> upDateLoanDetails(@PathVariable("id")Integer id,String department,
	  @RequestBody LoanDTO customer) throws RamStoreException{
		customer = lsi.upDateLoanDetails(id, customer.getCustomer().getDepartment());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(customer);
	}*/
	
	@GetMapping(path="GET/Loan/{loanId}")
	public ResponseEntity<LoanDTO> getCustomer(@PathVariable("loanId")Integer loanId) throws RamStoreException{
		LoanDTO ldto = lsi.getCustomer(loanId);
		return ResponseEntity.ok(ldto);
	}
	
	@PostMapping(path = "POST/Loan/addEmployee")
	public ResponseEntity<LoanDTO> addLoanDetails(@RequestBody LoanDTO loan) throws RamStoreException{
		loan =  lsi.AddCustomer(loan);
		String message = "LOAN_DETAILS_INSERTED_SUCCESSFULLY";
		System.out.println(message);
		return ResponseEntity.status(HttpStatus.CREATED).body(loan);
	}
	
	@DeleteMapping(path="DELETE/Loan/{loanId}")
	public ResponseEntity<String> deleteLoanID(@PathVariable("loanId")Integer loanId) throws RamStoreException{
		String loan = lsi.deleteByID(loanId);
		
		 return ResponseEntity.ok(loan);
	}
	
	@GetMapping(path="GET/loandetails")
	public ResponseEntity<List<LoanDTO>> getAll() throws RamStoreException{
		List<LoanDTO> ldto = lsi.getAll();
		return ResponseEntity.ok(ldto);
	}
	
	
	
}
