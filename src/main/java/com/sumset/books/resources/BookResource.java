/**
 * 
 */
package com.sumset.books.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sumset.books.services.CopyService;

/**
 * @author juandav
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/books")
public class BookResource {
	@Autowired
	CopyService copyService;
	
	@GetMapping("/{book_name}")
	public ResponseEntity<List<?>> searchBook(@PathVariable("book_name") String bookName) {
		List<?> books = this.copyService.findAllBooks(bookName);
		if (books == null) {
			return new ResponseEntity<List<?>>(HttpStatus.NOT_FOUND);
		} else {
			return ResponseEntity.ok(books);
		}
	}
	
	@PostMapping("/totalLoans")
	public ResponseEntity<Object> totalLoans() {
		Object totalLoans = this.copyService.getTotalLoanBooks();
		return ResponseEntity.ok(totalLoans);
	}
	
	@PostMapping("/booksByZone")
	public ResponseEntity<List<?>> totalBooksByZone() {
		List<?> totalBooksByZone = this.copyService.getTotalBooksByZone();
		return ResponseEntity.ok(totalBooksByZone);
	}
}
