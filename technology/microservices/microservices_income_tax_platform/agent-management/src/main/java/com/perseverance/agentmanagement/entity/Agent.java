/**
 * 
 */
package com.perseverance.agentmanagement.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author AR350758
 * Agent.java Aug 2, 2019 5:07:12 PM
 */
@Entity
public class Agent {

	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	private boolean isActive;
	private int status;
	private Date registrationDate;
	private Date deactivationDate;
	private Date dateOfBirth;
	
	public Agent() {}
	
	/**
	 * @param name
	 * @param isActive
	 * @param status
	 * @param registrationDate
	 * @param deactivationDate
	 * @param dateOfBirth
	 */
	public Agent(String name, boolean isActive, int status, Date registrationDate, Date deactivationDate,
			Date dateOfBirth) {
		super();
		this.name = name;
		this.isActive = isActive;
		this.status = status;
		this.registrationDate = registrationDate;
		this.deactivationDate = deactivationDate;
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the isActive
	 */
	public boolean isActive() {
		return isActive;
	}

	/**
	 * @param isActive the isActive to set
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the registrationDate
	 */
	public Date getRegistrationDate() {
		return registrationDate;
	}

	/**
	 * @param registrationDate the registrationDate to set
	 */
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	/**
	 * @return the deactivationDate
	 */
	public Date getDeactivationDate() {
		return deactivationDate;
	}

	/**
	 * @param deactivationDate the deactivationDate to set
	 */
	public void setDeactivationDate(Date deactivationDate) {
		this.deactivationDate = deactivationDate;
	}

	/**
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "Agent [id=" + id + ", name=" + name + ", isActive=" + isActive + ", status=" + status
				+ ", registrationDate=" + registrationDate + ", deactivationDate=" + deactivationDate + ", dateOfBirth="
				+ dateOfBirth + "]";
	}
	
	
	
	
}
