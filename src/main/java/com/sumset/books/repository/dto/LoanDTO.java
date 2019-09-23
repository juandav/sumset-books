/**
 * Module dependencies
 */
package com.sumset.books.repository.dto;

import java.util.Date;

import com.sumset.books.model.Copy;
import com.sumset.books.model.User;

import lombok.Data;

/**
 * @author juandav
 *
 */
@Data
public class LoanDTO {
	private Date date_of_entry;
	private Date date_of_out;
	private User users;
	private Copy copies;
}
