/**
 * 
 */
package com.sumset.books.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sumset.books.repository.CopyRepository;
import com.sumset.books.repository.LoanRepository;

/**
 * @author juadnav
 *
 */
@Service
public class CopyService {
	private final CopyRepository copyRepository;
	private final LoanRepository loanRepository;
	
	public CopyService(CopyRepository copyRepository, LoanRepository loanRepository) {
		this.copyRepository = copyRepository;
		this.loanRepository = loanRepository;
	}
	
	public List<?> findAllBooks(String bookName){
		return this.copyRepository.findBooks(bookName);
	}
	
	public List<?> getTotalBooksByZone() {
		return this.copyRepository.getTotalBooksByZone();
	}
	
	public Object getTotalLoanBooks() {
		return this.loanRepository.getTotalLoanBooks();
	}
	
}