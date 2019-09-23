package com.sumset.books.services;

import org.springframework.stereotype.Service;

import com.sumset.books.model.Loan;
import com.sumset.books.repository.LoanRepository;

@Service
public class LoanService {
	private final LoanRepository loanRepository;
	
	public LoanService(LoanRepository loanRepository) {
		this.loanRepository = loanRepository;
	}
	
	public Loan update(Loan loan) {
		return this.loanRepository.save(loan);
	}
	
	public Loan findById(long id) {
		return this.loanRepository.findById(id);
	}
}
