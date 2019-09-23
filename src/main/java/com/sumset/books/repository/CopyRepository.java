/**
 * Module dependencies
 */
package com.sumset.books.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sumset.books.model.Copy;

/**
 * @author juandav
 *
 */
public interface CopyRepository extends JpaRepository<Copy, Long> {
	       
	@Query("" +
		"SELECT distinct " + 
			"b.title, " +
			"b.description, " +
			"b.photo, " +
			"c.code, " +
			"z.name AS zone, " +
			"ct.name AS category, " +
			"ct.min_age, " +
			"ct.max_age, " +
			"l.date_of_entry, " +
			"l.date_of_out " +
		"FROM Copy c " + 
		"LEFT JOIN c.books b " + 
		"LEFT JOIN b.zones z " + 
		"LEFT JOIN b.categories ct " +
		"LEFT JOIN c.loans l " +
		"WHERE b.title =:bookName "
	)
	public List<?> findBooks(@Param("bookName") String bookName);
	
	@Query(
		value = "SELECT " + 
				"  z.name, " + 
				"  (SELECT " + 
				"    COUNT(*) " + 
				"  FROM public.books b " + 
				"  INNER JOIN public.copies c " + 
				"    ON c.book_id = b.id " + 
				"  WHERE b.zone_id = z.id " + 
				"  GROUP BY b.id) " + 
				"  AS cantidad " + 
				"FROM public.zones z", 
		nativeQuery = true
	)
	public List<?> getTotalBooksByZone();
}