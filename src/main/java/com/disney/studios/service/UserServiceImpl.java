package com.disney.studios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.disney.studios.dao.UserDao;
import com.disney.studios.exception.UserNotFoundException;
import com.disney.studios.model.User;

/**
 * This class is service layer for User Entity Implemenntation of UserService
 * interface
 *
 * @author Sanath
 *
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	/**
	 * This method is to get the User by userName
	 * 
	 * @param Username
	 * @return
	 */
	@Override
	public User getByUsername(String userName) {

		User existing = (User) userDao.getByUsername(userName);
		if (existing == null) {
			throw new UserNotFoundException("User with " + userName + "not found");
		}
		return existing;
	}

	/**
	 * This method is used to save the User data
	 * 
	 * @param user
	 * @return
	 */
	@Override
	public User saveUser(User user) {
		if (user == null) {
			return null;
		}
		return userDao.saveUser(user);
	}

	/**
	 * Delete the user based on userName
	 * 
	 * @param userName
	 */
	@Override
	public void deleteUser(String userName) {
		User existing = (User) userDao.getByUsername(userName);
		if (existing == null) {
			throw new UserNotFoundException("User with " + userName + "not found");
		}
		userDao.deleteUser(userName);
	}
}
