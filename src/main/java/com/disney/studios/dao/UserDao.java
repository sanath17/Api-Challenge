package com.disney.studios.dao;

import com.disney.studios.model.User;


/**
 * DataAccessObject for {@link UserDao}
 * 
 */
public interface UserDao {
	
	/**
	 * This method is used to save the User data 
	 * @param user
	 * @return
	 */
	public User saveUser(User user);
	/**
	 * This method is to get the User by userName
	 * @param Username
	 * @return
	 */
	public User getByUsername(String Username);
	
	/**
	 * Delete the user based on userName
	 * @param userName
	 */
	public void deleteUser(String userName);

}
