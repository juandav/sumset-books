/**
 * 
 */
package com.sumset.books.model;

import javax.persistence.Column;
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
@Table(name = "copy")
public class Copy {
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String id;
	@Column(unique = true, nullable = false)
	private String code;
	private String book_id;
}
