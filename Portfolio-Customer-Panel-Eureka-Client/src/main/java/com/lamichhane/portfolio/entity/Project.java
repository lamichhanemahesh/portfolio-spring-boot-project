package com.lamichhane.portfolio.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="project")
public class Project {
	
//	https://www.techgeeknext.com/spring-boot/spring-boot-upload-image
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_id_seq")
	@SequenceGenerator(name = "project_id_seq", 
	                   sequenceName = "project_seq",
	                   allocationSize = 1) 
	@Column(name="project_id")
	private int project_id;
	
	@OneToMany(mappedBy="project",cascade = {CascadeType.PERSIST,CascadeType.MERGE,
			CascadeType.DETACH,CascadeType.REFRESH})
    private List<ProjectImages> projectimages;
	
	

	@Column(name = "title")
	private String  title;
	
	
	
	@Column(name="description")
	private String description;
	
	
	
	



	public int getProject_id() {
		return project_id;
	}


	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}


	public List<ProjectImages> getProjectimages() {
		return projectimages;
	}


	public void setProjectimages(List<ProjectImages> projectimages) {
		this.projectimages = projectimages;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getId() {
		return project_id;
	}
	
	public void add(ProjectImages imagesUrl) {
		if(projectimages == null) {
			projectimages = new ArrayList<>();
		}
		projectimages.add(imagesUrl);
		imagesUrl.setProject(this);
	}


	
	
	
	
	


	
	
	
	
	
}