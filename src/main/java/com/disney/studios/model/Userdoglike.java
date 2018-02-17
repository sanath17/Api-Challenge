package com.disney.studios.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entity class for {@link Userdoglike}.
 * @author Sanath
 */
@Entity
@NamedQuery(name = "UserDogLike.findAll", query = "SELECT u FROM Userdoglike u")
public class Userdoglike implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idUserDogLike;

	// bi-directional many-to-one association to Dog
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "dogId")
	private Dog dog;

	// bi-directional many-to-one association to User
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;
	
	@Column(name="isLike")
	@Type(type="boolean")
	private Boolean isLike;

	public Boolean getIsLike() {
		return isLike;
	}

	public void setIsLike(Boolean isLike) {
		this.isLike = isLike;
	}

	public Userdoglike() {
	}

	

	/**
	 * This method is to get the userdoglike entity
	 * @return
	 */
	public int getIdUserDogLike() {
		return idUserDogLike;
	}

	/**
	 * This method is to set id for userdoglike entity
	 * @param idUserDogLike
	 */
	public void setIdUserDogLike(int idUserDogLike) {
		this.idUserDogLike = idUserDogLike;
	}

	/**
	 * This method is used to get the dog object
	 * @return
	 */
	public Dog getDog() {
		return this.dog;
	}

	/**
	 * This method is used to set the Dog object
	 * @param dog
	 */
	public void setDog(Dog dog) {
		this.dog = dog;
	}

	/**
	 * This is to get the user object
	 * @return
	 */
	public User getUser() {
		return this.user;
	}

	/**
	 * This method is used to set the User object
	 * @param user
	 */
	public void setUser(User user) {
		this.user = user;
	}

}