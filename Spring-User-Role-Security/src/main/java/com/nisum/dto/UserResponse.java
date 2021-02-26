package com.nisum.dto;

public class UserResponse {
	private String username;
	private String firstname;
	private String lastname;
	private String email;
	private String role;
	private String pan;
	private Boolean isActive;

	public UserResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserResponse(String username, String firstname, String lastname, String email, String role, String pan,
			Boolean isActive) {
		super();
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.role = role;
		this.pan = pan;
		this.isActive = isActive;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "UserResponse [username=" + username + ", firstname=" + firstname + ", lastname=" + lastname + ", email="
				+ email + ", role=" + role + ", pan=" + pan + ", isActive=" + isActive + "]";
	}

}
