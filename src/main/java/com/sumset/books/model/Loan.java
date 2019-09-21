/**
 * 
 */
package com.sumset.books.model;

import java.util.Date;

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
@Table(name = "loan")
public class Loan {
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String id;
	private Date date_of_entry;
	private Date date_of_out;
	private String user_id;
	private String copy_id;
}
