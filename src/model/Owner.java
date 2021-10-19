/**
 * @author Delanie Johnson - dmjohnson33
 * CIS175 - Fall 2021
 * Oct 15, 2021
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author delan
 *
 */
@Entity
@Table(name="owner")
public class Owner {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="NAME")
	private String name;
	@Column(name="ADDRESS")
	private String address;
	@Column(name="PHONENUMBER")
	private int phoneNumber;
	
	/**
	 * @param nameToLookUp
	 */
	public Owner(String nameToLookUp) {
		name = nameToLookUp;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Override
	public String toString() {
		return "Owner [id=" + id + ", name=" + name + ", address=" + address + ", phoneNumber=" + phoneNumber + "]";
	}

}
