package org.practice.hibernate.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="USER_DETAILS")  // use this class as entity and name as table name
public class UserDetails {

	@Id  // primary Key
	@Column (name = "USER_ID") // column name in the table. we can keep this annotation at getmethod level so that value will be picked from getmethod 
	private int userId;
	
	@Column(name= "USER_NAME")
	private String userName;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
