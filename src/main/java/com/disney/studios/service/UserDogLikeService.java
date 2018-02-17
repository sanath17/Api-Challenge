package com.disney.studios.service;

import com.disney.studios.model.Dog;
import com.disney.studios.model.User;
import com.disney.studios.model.Userdoglike;

/**
 * This interface is service layer for Userdoglike Entity
 * 
 * @author Sanath
 *
 */
public interface UserDogLikeService {

	public Userdoglike saveDogLike(String username, String imageurl,Boolean isLike);
	
	public Userdoglike updateDogLike(String username, String imageurl,Boolean isLike);
	
	public Boolean getUserDogLike(Dog d, User user);
}
