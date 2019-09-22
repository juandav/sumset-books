/**
 * Module dependencies
 */
package com.sumset.books.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sumset.books.model.Role;
import com.sumset.books.model.RoleName;

/**
 * @author juandav
 *
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(RoleName roleName);
}