/**
 * 
 */
package com.sumset.books.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sumset.books.model.Account;

/**
 * @author juadnav
 *
 */
public interface AccountRepository extends JpaRepository<Account, String> {

}
