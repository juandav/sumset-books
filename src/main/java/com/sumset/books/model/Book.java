/**
 * 
 */
package com.sumset.books.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * @author juadnav
 *
 */
@Data
@Entity
@Table(name = "book")
public class Book {
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String id;
	private String ISBN;
	private String title;
	private String description;
	private String photo;
	private String category_id;
	private String zone_id;
}
