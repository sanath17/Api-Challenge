package com.disney.studios.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.disney.studios.model.Dog;
import com.disney.studios.repository.DogRepository;

/**
 * This Class is implementation of {@link DogDao} interface
 * @author Sanath
 *
 */
@Repository
public class DogDaoImpl implements DogDao {
	@Autowired()
	private DogRepository dogRepository;

	/**
	 * This method is to get the Dog object based on the dogid
	 * @param id
	 * @return
	 */
	@Override
	public Dog getDogByID(int id) {
		Dog dog = (Dog) dogRepository.getByDogId(id);
		return dog;
	}

	/**
	 * This method is to get all the lsit of the dogs
	 * @return
	 */
	@Override
	public List<Dog> getAllDogs() {

		return (List<Dog>) dogRepository.findAll();
	}

	/**
	 * This method is to get dog object based on the image url of the dog
	 * @param imageurl
	 * @return
	 */
	@Override
	public Dog getByImageUrl(String imageurl) {
		Dog doglike = (Dog) dogRepository.getByImageUrl(imageurl);
		// doglike.setDogBreed( this.getDogByID(doglike.getDogid()).getDogBreed());
		doglike.getBreed();
		return doglike;
	}

	/**
	 * This method is used to save the dog object
	 * @param dog
	 * @return
	 */
	@Override
	public Dog saveDog(Dog dog) {
		return dogRepository.save(dog);
	}

	@Override
	public void deleteDog(String imageUrl) {
		dogRepository.delete(getByImageUrl(imageUrl));
		
	}

}
