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
@Table(name = "country")
public class Country implements java.io.Serializable{

	private Integer id;
	private String name;
	private Set<State> states = new HashSet<State>(0);
	public Country() {
		
	}
	public Country(String name) {
		this.name = name;
	}
	public Country(String name, Set<State> states) {
		this.name = name;
		this.states = states;
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
	
	@Column(name = "name", nullable = false, length = 250)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
	public Set<State> getStates() {
		return states;
	}
	public void setStates(Set<State> states) {
		this.states = states;
	}
	
	
	
	
	
}
