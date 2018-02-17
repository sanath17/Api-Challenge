package com.disney.studios.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

/**
 * Entity class for {@link Dog}.
 * @author Sanath
 */
@Entity
@NamedQuery(name = "Dog.findAll", query = "SELECT d FROM Dog d")
public class Dog implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * This is the unique identifier for dog entity
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int dogId;

	/**
	 * This is the name of the dog
	 */
	private String dogName;

	/**
	 * This is the url for the dog picture
	 */
	private String imageUrl;

	/**
	 * This is declaration of breed of each dog
	 */
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name = "breedId")
	private Breed breed;

	/**
	 * This is declaration of likes of each dog
	 */
	@JsonIgnore
	@OneToMany(mappedBy = "dog")
	private List<Userdoglike> userdoglikes;

	/**
	 * This is the count of number of likes for a dog but not store into db
	 */
	@Transient
	private int count;

	/**
	 * This is to represent the breed of dog but not store into db
	 */
	@Transient
	private String dogBreed;

	/**
	 * This returns the dog breed
	 * 
	 * @return
	 */
	public String getDogBreed() {
		return dogBreed;
	}

	/**
	 * This is used to set the dog breed
	 * 
	 * @param dogBreed
	 */
	public void setDogBreed(String dogBreed) {
		this.dogBreed = dogBreed;
	}

	/**
	 * This returns the number of dogs in breed
	 * 
	 * @return
	 */
	public int getCount() {
		return count;
	}

	/**
	 * This is to set the count of the dog
	 * 
	 * @param count
	 */
	public void setCount(int count) {
		this.count = count;
	}

	public Dog() {
	}

	/**
	 * This is to get the dog id of the dog
	 * 
	 * @return
	 */
	public int getDogId() {
		return dogId;
	}

	/**
	 * This is to set the dog id
	 * 
	 * @param dogId
	 */
	public void setDogId(int dogId) {
		this.dogId = dogId;
	}

	/**
	 * This is to get the name of the dog
	 * 
	 * @return
	 */
	public String getDogName() {
		return dogName;
	}

	/**
	 * This is to set the name of the dog
	 * 
	 * @param dogName
	 */
	public void setDogName(String dogName) {
		this.dogName = dogName;
	}

	/**
	 * This is to get the url of the dog image
	 * 
	 * @return
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * This is to set the url for the image of a dog
	 * 
	 * @param imageUrl
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	/**
	 * This is get the breed object
	 * 
	 * @return
	 */
	public Breed getBreed() {
		return this.breed;
	}

	/**
	 * This is to set the breed object
	 * 
	 * @param breed
	 */
	public void setBreed(Breed breed) {
		this.breed = breed;
	}

	/**
	 * This is to get the list of the dog likes
	 * 
	 * @return
	 */
	public List<Userdoglike> getUserdoglikes() {
		return this.userdoglikes;
	}

	/**
	 * This is to set the list of the dog likes
	 * 
	 * @param userdoglikes
	 */
	public void setUserdoglikes(List<Userdoglike> userdoglikes) {
		this.userdoglikes = userdoglikes;
	}

	/**
	 * This to add the userdoglike object
	 * 
	 * @param userdoglike
	 * @return
	 */
	public Userdoglike addUserdoglike(Userdoglike userdoglike) {
		getUserdoglikes().add(userdoglike);
		userdoglike.setDog(this);

		return userdoglike;
	}

	/**
	 * This is to remove the userdoglike object
	 * 
	 * @param userdoglike
	 * @return
	 */
	public Userdoglike removeUserdoglike(Userdoglike userdoglike) {
		getUserdoglikes().remove(userdoglike);
		userdoglike.setDog(null);

		return userdoglike;
	}

	// @Override
	// public String toString() {
	// return "Dog [dogid=" + dogid + ", dogname=" + dogname + ", imageurl=" +
	// imageurl + ", breed=" + breed
	// + ", userdoglikes=" + userdoglikes + "]";
	// }

}