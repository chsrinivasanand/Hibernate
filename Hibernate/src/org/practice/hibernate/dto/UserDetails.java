package org.practice.hibernate.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

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
	@GenericGenerator(name="sequence_gen",strategy="sequence")  //sequence-gen is hibernate provided generator type
	@CollectionId    //This Feature provided by hibernate not jpa // it will tells that this collection should have identifier below are the properties
    (columns = { @Column(name ="ADDRSS_ID") },/*to tell what columns should be part of primary key */
    generator = "sequence_gen",  // hot to generate primary key
    type = @Type(type="long")) // type of the primary key
 	private Collection<Address> listOfAddress = new ArrayList<Address>();   // kept arraylist because it supoorts indexes
			
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
	public Collection<Address> getListOfAddress() {
		return listOfAddress;
	}
	public void setListOfAddress(Collection<Address> listOfAddress) {
		this.listOfAddress = listOfAddress;
	}
	
}
