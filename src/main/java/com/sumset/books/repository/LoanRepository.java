/**
 * 
 */
package com.sumset.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sumset.books.model.Loan;

/**
 * @author juandav
 *
 */
public interface LoanRepository extends JpaRepository<Loan, Long> {
	@Query("" +
		"SELECT " + 
		"COUNT(*) AS Loans " + 
		"FROM Loan t " + 
		"WHERE t.date_of_out IS NULL " + 
		"GROUP BY t.id "
	)
	public Object getTotalLoanBooks();
	
	public Loan findById(long id);
}
