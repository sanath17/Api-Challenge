package com.disney.studios.dao;

import java.util.List;

import com.disney.studios.model.Dog;

/**
 * DataAccessObject for {@link DogDao}
 * 
 */
public interface DogDao {
	
	/**
	 * This method is used to save the dog object
	 * @param dog
	 * @return
	 */
	public Dog saveDog(Dog dog);

	/**
	 * This method is to get the Dog object based on the dogid
	 * @param id
	 * @return
	 */
	public Dog getDogByID(int id);

	/**
	 * This method is to get all the lsit of the dogs
	 * @return
	 */
	public List<Dog> getAllDogs();

	/**
	 * This method is to get dog object based on the image url of the dog
	 * @param imageurl
	 * @return
	 */
	public Dog getByImageUrl(String imageurl);
	
	/**
	 * This is used to delete the dog object form database
	 * @param imageurl
	 */
	public void deleteDog(String imageurl);

}
