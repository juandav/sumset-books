/**
 * 
 */
package com.sumset.books.repository.dto;

import lombok.Data;

/**
 * @author juandav
 *
 */
@Data
public class BookDTO {
	private String title;
	private String description;
	private String photo;
	private String code;
	private String zone;
	private String category;
	private String min_age;
	private String max_age;
}
