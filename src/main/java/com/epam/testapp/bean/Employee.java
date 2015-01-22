package com.epam.testapp.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="EMPLOYEES_SEQ", sequenceName="EMPLOYEES_SEQ", allocationSize=1)

public class Employee {
	
	private int id;
	private String firstName;
	private String lastName;
	@ManyToOne
	private Address address;
	private Set<Workplace> workplaces = new HashSet<Workplace>();
	
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMPLOYEES_SEQ")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Set<Workplace> getWorkplaces() {
		return workplaces;
	}
	public void setWorkplaces(Set<Workplace> workplaces) {
		this.workplaces = workplaces;
	}

}
