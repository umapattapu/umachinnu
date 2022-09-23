package com.store.ram.service;

import java.util.ArrayList;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.store.ram.DTO.LoanDTO;
import com.store.ram.entity.Customer;
import com.store.ram.entity.Loan;
import com.store.ram.exception.RamStoreException;
import com.store.ram.repository.CustomerRepository;
import com.store.ram.repository.LoanRepository;

@Service
@Transactional
public class ServiceImpl implements Loanservice{
	
	@Autowired
	private LoanRepository lp;
	
	private CustomerRepository cr;

	@Override
	public List<LoanDTO> getAll() throws RamStoreException {
		// TODO Auto-generated method stub
		Iterable<Loan> loan = lp.findAll();
		List<LoanDTO> loan1 = new ArrayList<>();
		loan.forEach(Loan->{
			LoanDTO ldto = new LoanDTO();
			ldto.setLoanId(Loan.getLoanId());
			ldto.setAmount(Loan.getAmount());
			ldto.setCustomer(Loan.getCustomer());
			loan1.add(ldto);
			
		});
		if(loan1.isEmpty()) {
			throw new RamStoreException("SERVICE_CUSTOMER_NOT_FOUND");
		}
		
		return loan1;
	}

	@Override
	public LoanDTO getCustomer(Integer loanId) throws RamStoreException {
		// TODO Auto-generated method stub
		Optional<Loan> optional = lp.findById(loanId);
		Loan loan = optional.orElseThrow(()-> new RamStoreException("CUSTOMER_ID_NOT_FOUND"));
		LoanDTO loandto = new LoanDTO();
		loandto.setLoanId(loan.getLoanId());
		loandto.setAmount(loan.getAmount());
		loandto.setCustomer(loan.getCustomer());
		return loandto;
	}

	@Override
	public String deleteByID(Integer loanId) throws RamStoreException {
		// TODO Auto-generated method stub
		Optional<Loan> loanDelete = lp.findById(loanId);
		loanDelete.orElseThrow(()-> new RamStoreException("CUSTOMER_ID_NOT_FOUND"));
		lp.deleteById(loanId);
		return "SERVICE.CUSTOMERID_DELETED_SUCCESSFULLY!!!!";
	}

	@Override
	public LoanDTO AddCustomer(LoanDTO c) throws RamStoreException {
		// TODO Auto-generated method stub
      Loan loan = new Loan();
      loan.setLoanId(c.getLoanId());
      loan.setAmount(c.getAmount());
      Customer customer = new Customer();
      customer.setName(c.getCustomer().getName());
      customer.setMobile(c.getCustomer().getMobile());
      customer.setDepartment(c.getCustomer().getDepartment());
      loan.setCustomer(customer);
      lp.save(loan);
		return c;
	}
/**
@Override
public LoanDTO upDateLoanDetails(Integer id, String department) throws RamStoreException {
		// TODO Auto-generated method stub
Optional<Customer> optional = cr.findById(id);
Customer customer = optional.orElseThrow(() -> new RamStoreException("Service.CUSTOMER_NOT_FOUND"));
customer.setDepartment(department);
return lp.save(customer);
	}
*/
	/**
	@Override
	public Integer addLoanDetails(Loan loan) throws RamStoreException {
		loan.setAmount(loan.getAmount());;
		Customer customer = new Customer();
		customer.setName(loan.getCustomer().getName());
		customer.setMobile(loan.getCustomer().getMobile());
		customer.setDepartment(loan.getCustomer().getDepartment());
		loan.setCustomer(customer);
		lp.save(loan);
		return loan.getLoanId();
	}*/

}
