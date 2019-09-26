package com.cruds.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "state")
public class State implements java.io.Serializable{

	private Integer id;
	private Country country;
	private String name;
	private Set<City> cities = new HashSet<City>(0);
	
	
	
	public State(String name) {
		this.name = name;
	}


	public State(String name, Set<City> cities) {
		this.name = name;
		this.cities = cities;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "countryId", nullable = false, length = 250)
	public Country getCountry() {
		return country;
	}


	public void setCountry(Country country) {
		this.country = country;
	}

	@Column(name = "name", nullable = false, length = 250)
	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "state")
	public Set<City> getCities() {
		return cities;
	}


	public void setCities(Set<City> cities) {
		this.cities = cities;
	}


	public State(){
		
	}
}
