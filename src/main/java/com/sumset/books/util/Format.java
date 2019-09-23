/**
 * 
 */
package com.sumset.books.util;

import java.util.Date;

/**
 * @author juandav
 *
 */
public class Format {
	public static int betweenDatesByDays(Date majorDate, Date minorDate) {
		long betweenMonth = majorDate.getTime() - minorDate.getTime();
		long days = betweenMonth / (1000 * 60 * 60 * 24);
		return (int) days;
	}
}
