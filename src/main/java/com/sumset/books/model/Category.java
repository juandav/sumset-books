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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * @author juandav
 *
 */

@Data
@Entity
@Table(name = "categories")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(min = 3, max = 50)
	private String name;
	@Size(min = 1, max = 3)
	private Integer min_age;
	@Size(min = 1, max = 3)
	private Integer max_age;
	@OneToMany(mappedBy = "categories", cascade = CascadeType.ALL)
    private Set<Book> books;
}
