package com.disney.studios.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.disney.studios.model.Breed;
import com.disney.studios.repository.BreedRepository;

/**
 * This Class is implementation of {@link BreedDao} interface
 * @author Sanath
 *
 */
@Repository
public class BreedDaoImpl implements BreedDao {
	
	/**
	 * This is autowiring the breed repository and using in the class
	 */
	@Autowired()
	private BreedRepository breedRepository;

	/**
	 * This method returns the list of breed objects
	 * @return
	 */
	@Override
	public List<Breed> getAllBreeds() {
		return (List<Breed>) breedRepository.findAll();
	}

	/**
	 * This method returns the Breed objects based on the name of the breed
	 * @param name
	 * @return
	 */
	@Override
	public Breed getBreedbyName(String name) {

		return breedRepository.getByBreedName(name);
	}

	/**
	 * This method returns the Breed objects based on the name of the breed
	 * @param name
	 * @return
	 */
	@Override
	public Breed saveBreed(Breed breed) {
		
		return breedRepository.save(breed);
	}

	/**
	 * This method is used to delete the breed object form database
	 * @param breedName
	 */
	@Override
	public void deleteBreed(String breedName) {
		breedRepository.delete(getBreedbyName(breedName));
		
	}

}
