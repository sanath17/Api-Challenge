package com.disney.studios.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.disney.studios.model.User;
import com.disney.studios.repository.UserRepository;

/**
 * This Class is implementation of {@link UserDao} interface
 * @@author Sanath
 *
 */
@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private UserRepository userRepository;

	/**
	 * This method is to get the User by userName
	 * @param Username
	 * @return
	 */
	@Override
	public User getByUsername(String userName) {

		return (User) userRepository.getByUserName(userName);

	}

	@Override
	public User saveUser(User user) {
		
		return (User)userRepository.save(user);
	}

	@Override
	public void deleteUser(String userName) {
		userRepository.delete(getByUsername(userName));
	}

}
