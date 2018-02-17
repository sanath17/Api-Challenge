package com.disney.studios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.disney.studios.dao.UserDogLikeDao;
import com.disney.studios.exception.DogLikeAlreadyExistException;
import com.disney.studios.model.Dog;
import com.disney.studios.model.User;
import com.disney.studios.model.Userdoglike;

/**
 * This class is service layer for UserDogLike Entity Implemenntation of
 * Userdoglike Service interface
 * 
 * @author Sanath
 *
 */
@Service
public class UserDogLikeServiceImpl implements UserDogLikeService {

	@Autowired
	private DogService dogService;

	@Autowired
	private UserService userService;
	Userdoglike udl = new Userdoglike();
	@Autowired
	private UserDogLikeDao userDogLikeDao;

	@Override
	public Userdoglike saveDogLike(String userName, String imageurl, Boolean isLike) {

		Dog dog = dogService.getDogByImageUrl(imageurl);
		User user = userService.getByUsername(userName);
		userDogLikeDao.getUserDogLike(dog, user);
		if (!userDogLikeDao.getUserDogLike(dog, user)) {
			this.udl.setDog(dog);
			this.udl.setUser(user);
			this.udl.setIsLike(isLike);
			return userDogLikeDao.Savedoglike(this.udl);
		} else {
			throw new DogLikeAlreadyExistException(userName + " Already liked the dog"); 
		}

	}

	public Userdoglike updateDogLike(String userName, String imageurl, Boolean isLike) {

		Dog dog = dogService.getDogByImageUrl(imageurl);
		User user = userService.getByUsername(userName);
		userDogLikeDao.getUserDogLike(dog, user);
		if (userDogLikeDao.getUserDogLike(dog, user) == true) {
			this.udl.setIdUserDogLike(userDogLikeDao.getlikes(dog, user).getIdUserDogLike());
			this.udl.setDog(dog);
			this.udl.setUser(user);
			if (isLike == userDogLikeDao.getlikes(dog, user).getIsLike()) {
				this.udl.setIsLike(!isLike);
				return userDogLikeDao.Savedoglike(this.udl);
			} else {
				this.udl.setIdUserDogLike(userDogLikeDao.getlikes(dog, user).getIdUserDogLike());
				this.udl.setIsLike(isLike);
				return userDogLikeDao.Savedoglike(this.udl);
			}
		} else {
			return null;
		}

	}

	@Override
	public Boolean getUserDogLike(Dog d, User user) {
		if (userDogLikeDao.getUserDogLike(d, user))
		return true;
		return false;
	}

}
