package com.disney.studios.service;

import java.util.List;

import com.disney.studios.model.Dog;

/**
 * This interface is service layer for Dog Entity
 * 
 * @author Sanath
 *
 */
public interface DogService {

	/**
	 * This method is used to save the dog object
	 * 
	 * @param dog
	 * @return
	 */
	public Dog saveDog(Dog dog);

	public Dog getByDogId(int id);

	public List<Dog> getAllDogs();

	public Dog getDogByImageUrl(String imageurl);

	/**
	 * This is used to delete the dog object form database
	 * @param imageurl
	 */
	public void deleteDog(String imageurl);

}
