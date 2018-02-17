package com.disney.studios.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;

/**
 * Entity class for {@link Breed}.
 * @author Sanath
 */
@Entity
@NamedQuery(name = "Breed.findAll", query = "SELECT b FROM Breed b")
public class Breed implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * @param breedId
	 *            This is the identifier of breed table
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int breedId;

	/**
	 * This is the name of the breed Make sure the breed_name is string no
	 * alphanumerics
	 */
	@Column(name = "breed_name")
	private String breedName;

	/**
	 * This is list of dogs of a breed Each breed can have many dogs
	 */
	@OneToMany(mappedBy = "breed", fetch = FetchType.LAZY, targetEntity = Dog.class,cascade= CascadeType.ALL)
	private List<Dog> dogs;

	public Breed() {
	}

	/**
	 * This method returns the id of a particular breed
	 * 
	 * @return
	 */
	public int getBreedId() {
		return breedId;
	}

	/**
	 * This method is to set Id for the breed table The id should be integer
	 * 
	 * @param breedId
	 */
	public void setBreedId(int breedId) {
		this.breedId = breedId;
	}

	/**
	 * This method returns the name of the breed
	 * 
	 * @return
	 */
	public String getBreedName() {
		return this.breedName;
	}

	/**
	 * This method is set the name of the breed Name of the breed is a string
	 * 
	 * @param breedName
	 */
	public void setBreedName(String breedName) {
		this.breedName = breedName;
	}

	/**
	 * This method is to get the list of the dogs
	 * 
	 * @return
	 */
	public List<Dog> getDogs() {
		return this.dogs;
	}

	/**
	 * This method is to set the list of dog objects
	 * 
	 * @param dogs
	 */
	public void setDogs(List<Dog> dogs) {
		this.dogs = dogs;
	}

	/**
	 * This method is to add the Dog object Returns the dog object once added
	 * 
	 * @param dog
	 * @return
	 */
	public Dog addDog(Dog dog) {
		getDogs().add(dog);
		dog.setBreed(this);

		return dog;
	}

	/**
	 * This method is to remove the dog Returns the dog object once removed
	 * 
	 * @param dog
	 * @return
	 */
	public Dog removeDog(Dog dog) {
		getDogs().remove(dog);
		dog.setBreed(null);

		return dog;
	}

}
