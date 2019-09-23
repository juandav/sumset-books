/**
 * 
 */
package com.sumset.books.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sumset.books.model.Loan;
import com.sumset.books.repository.dto.LoanDTO;
import com.sumset.books.services.LoanService;

/**
 * @author juandav
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/loan")
public class LoanResource {
	
   @Autowired
   LoanService loanService;
	
	@PutMapping("/{id}")
	public ResponseEntity<Loan> updateLoan(
		@PathVariable("id") long id,
		LoanDTO loanDto
	) {
		Loan loan = this.loanService.findById(id);
		
		if (loan == null) {
			return new ResponseEntity<Loan>(HttpStatus.NOT_FOUND);
		} else {
			loan.setDate_of_entry(loanDto.getDate_of_entry());
			loan.setDate_of_out(loanDto.getDate_of_out());
			loan.setUsers(loanDto.getUsers());
			loan.setCopies(loanDto.getCopies());
		}
		return new ResponseEntity<>(this.loanService.update(loan), HttpStatus.OK);
	}
}
