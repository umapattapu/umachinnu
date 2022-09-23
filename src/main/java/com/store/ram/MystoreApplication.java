package com.store.ram;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.store.ram.entity.Customer;
import com.store.ram.entity.Loan;
import com.store.ram.repository.CustomerRepository;
import com.store.ram.repository.LoanRepository;

@SpringBootApplication
public class MystoreApplication  implements CommandLineRunner{

	@Autowired
	private  CustomerRepository rp;
	
	@Autowired
	private LoanRepository lr;
	
	public static void main(String[] args) {
		SpringApplication.run(MystoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("I am started");
		Customer c1 = new Customer("Ramyarjun","IT",801953);
		Customer c2 = new Customer("Arjun","Admin",967641);
	    Customer c3 = new Customer("Priya","System Engineer",4266);
		//rp.save(c1);
		//rp.save(c2);
		//rp.save(c3);
		Loan l1 = new Loan(1240654,500000.00,c1);
		Loan l2 = new Loan(1240655,500001.00,c2);
		Loan l3 = new Loan(1240656,500003.00,c3);
		//lr.save(l1);
		//lr.save(l2);
		//lr.save(l3);
		
		//System.out.println(lr.findAll());
		
		
		
		
	}
	

}
