package com.justin.mvcdemo.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="donations")
public class Donation {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=3, max=255, message="donation name needs to be more than 2 characters")
	@NotEmpty(message="donation name required")
	private String donationName;
	
	@Size(min=2, max=50)
	@NotEmpty(message="donor name required")
	private String donor;
	
	@Min(0)
	@NotNull
	private Integer quantity;
	
	@Column(updatable=false)
	private Date createdAt;
	
	@Column(updatable=false)
	private Date updatedAt;
	
	public Donation() {
		
	}
	
	public Donation(String donationName, String donor, Integer quantity) {
		this.donationName = donationName;
		this.donor = donor;
		this.quantity = quantity;
	}

	public Donation(Long id, String donationName, String donor, Integer quantity) {
		this.id = id;
		this.donationName = donationName;
		this.donor = donor;
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDonationName() {
		return donationName;
	}

	public void setDonationName(String donationName) {
		this.donationName = donationName;
	}

	public String getDonor() {
		return donor;
	}

	public void setDonor(String donor) {
		this.donor = donor;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
}
