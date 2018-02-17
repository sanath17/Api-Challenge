package com.disney.studios.service;

import com.disney.studios.model.User;

/**
 * This interface is service layer for breed Entity
 * 
 * @author Sanath
 *
 */
public interface UserService {
	/**
	 * This method is used to save the User data 
	 * @param user
	 * @return
	 */
	public User saveUser(User user);
	
	/**
	 * Get the user by userName
	 * @param username
	 * @return
	 */
	public User getByUsername(String username);
	
	/**
	 * Delete the user based on userName
	 * @param userName
	 */
	public void deleteUser(String userName);

}
