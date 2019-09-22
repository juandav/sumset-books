/**
 * Module dependencies
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
	name="books", 
	uniqueConstraints = { 
		@UniqueConstraint(columnNames = { "ISBN" }),
	}
)
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String ISBN;
	private String title;
	private String description;
	private String photo;
	@ManyToOne
    @JoinColumn(name = "zone_id")
    private Zone zones;
	@ManyToOne
    @JoinColumn(name = "category_id")
    private Category categories;
	@OneToMany(mappedBy = "books", cascade = CascadeType.ALL)
    private Set<Copy> copies;
}
