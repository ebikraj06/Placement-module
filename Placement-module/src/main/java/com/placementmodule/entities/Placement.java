package com.placementmodule.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "placement")
public class Placement {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
		     
	@Column(name = "companyName", nullable = false)
	private String companyName;
		     
	@Column(name = "companyEmail", nullable = false,unique = true)
	private String companyEmail;
		    
	@Column(name = "position", nullable = false)
	private String position;
	
	@Column(name = "datevenue",nullable =false)
	private String dateAndVenue;
		    
	@Column(name = "percentage", nullable = false)
	private String percentage; 
	  
	public Placement() { 
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyEmail() {
		return companyEmail;
	}

	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDateAndVenue() {
		return dateAndVenue;
	}

	public void setDateAndVenue(String dateAndVenue) {
		this.dateAndVenue = dateAndVenue;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companyEmail == null) ? 0 : companyEmail.hashCode());
		result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
		result = prime * result + ((dateAndVenue == null) ? 0 : dateAndVenue.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((percentage == null) ? 0 : percentage.hashCode());
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Placement other = (Placement) obj;
		if (companyEmail == null) {
			if (other.companyEmail != null)
				return false;
		} else if (!companyEmail.equals(other.companyEmail))
			return false;
		if (companyName == null) {
			if (other.companyName != null)
				return false;
		} else if (!companyName.equals(other.companyName))
			return false;
		if (dateAndVenue == null) {
			if (other.dateAndVenue != null)
				return false;
		} else if (!dateAndVenue.equals(other.dateAndVenue))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (percentage == null) {
			if (other.percentage != null)
				return false;
		} else if (!percentage.equals(other.percentage))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Placement [id=" + id + ", companyName=" + companyName + ", companyEmail=" + companyEmail + ", position="
				+ position + ", dateAndVenue=" + dateAndVenue + ", percentage=" + percentage + "]";
	}

	
}

