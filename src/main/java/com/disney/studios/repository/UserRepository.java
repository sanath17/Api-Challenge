package com.disney.studios.repository;

import org.springframework.data.repository.CrudRepository;

import com.disney.studios.model.Breed;
import com.disney.studios.model.User;

/**
 * JPA {@link UserRepository} for {@link User} 
 * 
 * @author Sanath
 *
 */
public interface UserRepository extends CrudRepository<User, Integer> {
	/**
	 * This method is to get User object based on UserName
	 * 
	 * @param userName
	 * @return
	 */
	User getByUserName(String userName);

}
