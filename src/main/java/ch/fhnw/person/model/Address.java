package ch.fhnw.person.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Address implements Serializable {
	
	private static final long serialVersionUID = 793895868199555877L;
	
	@Id
	@GeneratedValue
	private Integer id;
	private String address;
	private String city;
	private String country;
	
	@OneToMany(mappedBy="address",cascade=CascadeType.PERSIST)
	private List<Person> persons;
	
	public Address(){}
	
	public Address( String address, String city, String country) {
		this.address = address;
		this.city = city;
		this.country = country;
	}

	public Integer getId() {
		return this.id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	

}
