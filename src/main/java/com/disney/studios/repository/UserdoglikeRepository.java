package com.disney.studios.repository;

import org.springframework.data.repository.CrudRepository;

import com.disney.studios.model.Breed;
import com.disney.studios.model.Dog;
import com.disney.studios.model.User;
import com.disney.studios.model.Userdoglike;

/**
 * JPA {@link UserdoglikeRepository} for {@link Userdoglike} 
 * 
 * @author Bhanu
 *
 */
public interface UserdoglikeRepository extends CrudRepository<Userdoglike, Integer> {

	/**
	 * This method is to get the dog based on the input
	 * @param dog
	 * @return
	 */
	Dog getByDog(Dog dog);

	/**
	 * This method is to get the User based on the input
	 * @param user
	 * @return
	 */
	User getByUser(User user);

	/**
	 * This method get the likes for a dog given by a user
	 * 
	 * @param d
	 * @param user
	 * @return
	 */
	Userdoglike findByDogAndUser(Dog dog, User user);


}
