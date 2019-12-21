package com.webstack.instituterun.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "trainer_master")
public class Trainer implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String trainerName;
	private String trainerMobileNo;

	private String trainerEmail;
	private String trainerType;

	private String compensationType;

	private Integer percentage;

	private Integer fixedPay;

	private Set<Course> courses = new HashSet<Course>(0);

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "trainer_id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "trainer_name")
	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	@Column(name = "trainer_mobile_no")
	public String getTrainerMobileNo() {
		return trainerMobileNo;
	}

	public void setTrainerMobileNo(String trainerMobileNo) {
		this.trainerMobileNo = trainerMobileNo;
	}

	@Column(name = "trainer_email")
	public String getTrainerEmail() {
		return trainerEmail;
	}

	public void setTrainerEmail(String trainerEmail) {
		this.trainerEmail = trainerEmail;
	}

	@Column(name = "trainer_type")
	public String getTrainerType() {
		return trainerType;
	}

	public void setTrainerType(String trainerType) {
		this.trainerType = trainerType;
	}

	@Column(name = "compansantion_type")
	public String getCompensationType() {
		return compensationType;
	}

	public void setCompensationType(String compensationType) {
		this.compensationType = compensationType;
	}

	@Column(name = "percentage")
	public Integer getPercentage() {
		return percentage;
	}

	public void setPercentage(Integer percentage) {
		this.percentage = percentage;
	}

	@Column(name = "fixed_pay")
	public Integer getFixedPay() {
		return fixedPay;
	}

	public void setFixedPay(Integer fixedPay) {
		this.fixedPay = fixedPay;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "trainer_course", joinColumns = {
			@JoinColumn(name = "trainer_id") }, inverseJoinColumns = { @JoinColumn(name = "course_id") })
	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

}
