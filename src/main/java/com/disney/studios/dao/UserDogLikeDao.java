package com.disney.studios.dao;

import java.util.List;

import com.disney.studios.model.Dog;
import com.disney.studios.model.User;
import com.disney.studios.model.Userdoglike;

/**
 * DataAccessObject for {@link UserDogLikeDao}
 * @author Sanath
 */
public interface UserDogLikeDao {
	/**
	 * This method is to save the userdoglike entity object in to db
	 */
	public Userdoglike Savedoglike(Userdoglike u);

	/**
	 * This method is to get the list of the userdoglike for each dog
	 * 
	 * @return
	 */
	public List<Userdoglike> listlikes();

	/**
	 * This method check whether the dog is like or not and returns the boolean value based on that
	 * @param d
	 * @param user
	 * @return
	 */
	public Boolean getUserDogLike(Dog d, User user);

	/**
	 * This method get the likes for a dog given by a user
	 * 
	 * @param d
	 * @param user
	 * @return
	 */
	public Userdoglike getlikes(Dog d, User user);

}
