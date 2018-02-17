package com.disney.studios.dao;

import java.util.List;

import com.disney.studios.model.Breed;

/**
 * DataAccessObject for {@link Breed}
 * 
 */
public interface BreedDao {
	
	/**
	 * This method is used to save the breed
	 * @param breed
	 * @return
	 */
	public Breed saveBreed(Breed breed);
	
	/**
	 * This method returns the list of breed objects
	 * @return
	 */
	public List<Breed> getAllBreeds();

	/**
	 * This method returns the Breed objects based on the name of the breed
	 * @param name
	 * @return
	 */
	public Breed getBreedbyName(String name);
	
	/**
	 * This method is used to delete the breed object form database
	 * @param breedName
	 */
	public void deleteBreed(String breedName);

}
