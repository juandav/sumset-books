/**
 * 
 */
package com.sumset.books.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

/**
 * @author juandav
 *
 */
@Data
@Entity
@Table(
	name = "copies",
	uniqueConstraints = { 
		@UniqueConstraint(columnNames = { "code" })
	}
)
public class Copy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String code;
	
	@ManyToOne
    @JoinColumn(name = "book_id")
    private Book books;
	
	@OneToMany(mappedBy = "copies", cascade = CascadeType.ALL)
    private Set<Loan> loans;
}
