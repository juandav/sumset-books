/**
 * 
 */
package com.sumset.books.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sumset.books.repository.CopyRepository;
import com.sumset.books.repository.dto.BookDTO;

/**
 * @author juadnav
 *
 */
@Service
public class CopyService {
	private final CopyRepository copyRepository;
	
	public CopyService(CopyRepository copyRepository) {
		this.copyRepository = copyRepository;
	}
	
	public List<BookDTO> findAllBooks(String bookName){
		return this.copyRepository.findBooks(bookName);
	}
}