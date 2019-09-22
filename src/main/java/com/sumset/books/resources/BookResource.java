/**
 * 
 */
package com.sumset.books.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sumset.books.repository.dto.BookDTO;
import com.sumset.books.services.CopyService;

/**
 * @author juadnav
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/books")
public class BookResource {
	@Autowired
	CopyService copyService;
	
	@GetMapping("/{book_name}")
	public ResponseEntity<List<BookDTO>> searchBook(@PathVariable("book_name") String bookName) {
		// System.out.println("Fair use of System.out.println(..). " + bookName);
		return ResponseEntity.ok(this.copyService.findAllBooks(bookName));
	}
}
