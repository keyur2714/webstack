package com.webstack.instituterun.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "course_master")
public class Course {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String courseCode;
	private String courseName;	
	private Long fees;

	private Set<Trainer> trainers = new HashSet<Trainer>();

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "course_id")	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "course_code")	
	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	@Column(name = "course_name")	
	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	@Column(name = "fees")
	public Long getFees() {
		return fees;
	}

	public void setFees(Long fees) {
		this.fees = fees;
	}
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,
		    mappedBy = "courses")	
	public Set<Trainer> getTrainers() {
		return trainers;
	}

	public void setTrainers(Set<Trainer> trainers) {
		this.trainers = trainers;
	}

}
