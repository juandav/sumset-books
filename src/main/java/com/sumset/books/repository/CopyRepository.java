/**
 * Module dependencies
 */
package com.sumset.books.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sumset.books.model.Copy;
import com.sumset.books.repository.dto.BookDTO;

/**
 * @author juandav
 *
 */
public interface CopyRepository extends JpaRepository<Copy, Long> {
	       
	@Query("" +
		"SELECT " + 
			"b.title, " +
			"b.description, " +
			"b.photo, " +
			"c.code, " +
			"z.name AS zone, " +
			"ct.name AS category, " +
			"ct.min_age, " +
			"ct.max_age " +
		"FROM Copy c " + 
		"LEFT JOIN c.books b " + 
		"LEFT JOIN b.zones z " + 
		"LEFT JOIN b.categories ct " + 
		"WHERE b.title =:bookName "
	)
	public List<BookDTO> findBooks(@Param("bookName") String bookName);
}