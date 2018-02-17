package com.disney.studios.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.disney.studios.model.Dog;
import com.disney.studios.model.User;
import com.disney.studios.model.Userdoglike;
import com.disney.studios.repository.UserdoglikeRepository;

/**
 * This Class is implementation of {@link UUserDogLikeDao} interface
 *@author Sanath
 *
 */
@Repository
public class UserDogLikeDaoImpl implements UserDogLikeDao {

	@Autowired()
	private UserdoglikeRepository userDogLikeRepository;

	/**
	 * This method is to save the userdoglike entity object in to db
	 */
	@Override
	public Userdoglike Savedoglike(Userdoglike u) {
		return userDogLikeRepository.save(u);
	}

	/**
	 * This method is to get the list of the userdoglike for each dog
	 * 
	 * @return
	 */
	@Override
	public List<Userdoglike> listlikes() {
		return (List<Userdoglike>) userDogLikeRepository.findAll();
	}

	/**
	 * This method check whether the dog is like or not and returns the boolean
	 * value based on that
	 * 
	 * @param d
	 * @param user
	 * @return
	 */
	@Override
	public Boolean getUserDogLike(Dog dog, User user) {
		Userdoglike userDogLike = userDogLikeRepository.findByDogAndUser(dog, user);
		if (null != userDogLike) {
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}

	}

	/**
	 * This method get the likes for a dog given by a user
	 * 
	 * @param d
	 * @param user
	 * @return
	 */
	@Override
	public Userdoglike getlikes(Dog dog, User user) {

		return (Userdoglike) userDogLikeRepository.findByDogAndUser(dog, user);
	}

}
