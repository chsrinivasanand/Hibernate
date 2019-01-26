package org.practice.hibernate.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

@Entity
@Table (name = "USER_DETAILS")
public class UserDetails {

	@Id @GeneratedValue(strategy = GenerationType.AUTO) // primary Key , Generated value automatically generates the value
	private int userId;
	
	private String userName;
	
	@ElementCollection  // used to tell hibernate that below attribute should be treat it as list
	@JoinTable (name="USER_ADDRESS",//  Used to specify sub table name. if we didn't give this annotation hibernate will give automatic name
	   joinColumns=@JoinColumn(name = "USER_ID")  //used to specify join column name of sub table
	)   
 	private Set<Address> listOfAddress = new HashSet(); 
			
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
	public Set<Address> getListOfAddress() {
		return listOfAddress;
	}
	public void setListOfAddress(Set<Address> listOfAddress) {
		this.listOfAddress = listOfAddress;
	}
	
}
