package ch.fhnw.person.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
public class Person implements Serializable {
	
	static final long serialVersionUID = -2807400624553322628L;
	
	@Id
	@GeneratedValue
	private Integer id;
	private String firstname;
	private String lastname;
	private Integer age;
	@Temporal( TemporalType.DATE ) // Time / Date / Timestamp
	private Date birthday;
	
	@ManyToOne(cascade = CascadeType.ALL) 
	private Address address;
	
	public Person(){}
	
	public Person(String firstname, String lastname, Integer age) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.address = new Address();
	}
	
	public Person(String firstname, String lastname, Integer age, Address address) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.address = address;
	}
	
	public String getFullName() {
		return this.firstname +" " +this.lastname;
	}

	public Integer getId() {
		return this.id;
	}
	
	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	public Address getAddress() {
		return this.address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstname + ", lastName="
				+ lastname + ", age=" + age + "]";
	}
	

}
