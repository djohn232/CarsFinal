package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author krebs jjkrebs1
 * CIS 175 - Fall 2021
 * Oct 17, 2021
 */
@Entity
@Table(name="garageDetails")
public class garageDetails {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="GARAGENAME")
	private String garageName;
	@ManyToOne(cascade=CascadeType.PERSIST)
	@Column(name="OWNER")
	private Owner owner;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<Car> listOfCars;
	
	public garageDetails() {
		super();
	}
	
	public garageDetails(int id, String garageName, Owner owner, List<Car> listOfCars) {
		this.id = id;
		this.garageName = garageName;
		this.owner = owner;
		this.listOfCars = listOfCars;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the garageName
	 */
	public String getGarageName() {
		return garageName;
	}

	/**
	 * @param garageName the garageName to set
	 */
	public void setGarageName(String garageName) {
		this.garageName = garageName;
	}

	/**
	 * @return the owner
	 */
	public Owner getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	/**
	 * @return the listOfCars
	 */
	public List<Car> getListOfCars() {
		return listOfCars;
	}

	/**
	 * @param listOfCars the listOfCars to set
	 */
	public void setListOfCars(List<Car> listOfCars) {
		this.listOfCars = listOfCars;
	}

	@Override
	public String toString() {
		return "garageDetails [id=" + id + ", garageName=" + garageName + ", owner=" + owner + ", listOfCars="
				+ listOfCars + "]";
	}
}
