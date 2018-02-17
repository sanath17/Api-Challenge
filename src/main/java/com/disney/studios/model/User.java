package com.disney.studios.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * Entity class for {@link User}.
 * @author Sanath
 */
@Entity
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * This is the user id of the user entity
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;

	/**
	 * This is the firstName of the user entity
	 */
	private String firstName;

	/**
	 * This is the lastName of the user entity
	 */
	private String lastName;

	/**
	 * This is the userName of the user entity
	 */
	private String userName;

	/**
	 * This is get he list of user dog likes
	 */
	@OneToMany(mappedBy = "user")
	private List<Userdoglike> userdoglikes;

	public User() {
	}

	/**
	 * This is to get the user id of the user entity
	 * 
	 * @return
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * This is to set the user id of the user entity
	 * 
	 * @param userId
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * This is to get the firstName of the user entity
	 * 
	 * @return
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * This is to set the firstName of the user entity
	 * 
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * This is to get the last Name
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * This is to set the last Name 
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * This is to get the user Name
	 * @return
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * This is to set the user Name 
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * This is to get the list of the user dog like
	 * 
	 * @return
	 */
	public List<Userdoglike> getUserdoglikes() {
		return this.userdoglikes;
	}

	/**
	 * This is to set the list of the user dog likes
	 * 
	 * @param userdoglikes
	 */
	public void setUserdoglikes(List<Userdoglike> userdoglikes) {
		this.userdoglikes = userdoglikes;
	}

	/**
	 * This is to add the userdoglike
	 * 
	 * @param userdoglike
	 * @return
	 */
	public Userdoglike addUserdoglike(Userdoglike userdoglike) {
		getUserdoglikes().add(userdoglike);
		userdoglike.setUser(this);

		return userdoglike;
	}

	/**
	 * This is to remove the userdoglike
	 * 
	 * @param userdoglike
	 * @return
	 */
	public Userdoglike removeUserdoglike(Userdoglike userdoglike) {
		getUserdoglikes().remove(userdoglike);
		userdoglike.setUser(null);

		return userdoglike;
	}

}