package com.lamichhane.portfolio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="stats")
public class Stats {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stats_id_seq")
	@SequenceGenerator(name = "stats_id_seq", 
	                   sequenceName = "stats_seq",
	                   allocationSize = 1) 
	@Column(name="id")
	private int id;
	
	
	@Column(name="heading")
	private String heading;
	
	@Column(name="description")
	private String description;

	

	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}
	
	
	
	
	
	
}
