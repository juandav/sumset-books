/**
 * 
 */
package com.sumset.books.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author juandav
 *
 */
@Data
@Entity
@Table(name = "loans")
public class Loan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date date_of_entry;
	private Date date_of_out;
	@ManyToOne
    @JoinColumn(name = "user_id")
    private User users;
	@ManyToOne
    @JoinColumn(name = "copy_id")
    private Copy copies;
}
