package com.webstack.instituterun.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student_registration")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "student_id")
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "mobile_no")
	private String mobileNo;
	@Column(name = "email")
	private String email;
	@Column(name = "total_fees")
	private Long totalFees;
	@Column(name = "discount")
	private Integer discount;
	@Column(name = "final_fees")
	private Long finalFees;
	@Column(name = "fees_paid")
	private Long feesPaid;
	@Column(name = "fees_remaining")
	private Long feesRemaining;
	@Column(name = "fees_status")
	private String feesStatus;
	@Column(name = "registration_date")
	private Date registrationDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "course_id")
	private Course course;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "batch_id")
	private Batch batch;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getTotalFees() {
		return totalFees;
	}

	public void setTotalFees(Long totalFees) {
		this.totalFees = totalFees;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public Long getFinalFees() {
		return finalFees;
	}

	public void setFinalFees(Long finalFees) {
		this.finalFees = finalFees;
	}

	public Long getFeesPaid() {
		return feesPaid;
	}

	public void setFeesPaid(Long feesPaid) {
		this.feesPaid = feesPaid;
	}

	public Long getFeesRemaining() {
		return feesRemaining;
	}

	public void setFeesRemaining(Long feesRemaining) {
		this.feesRemaining = feesRemaining;
	}

	public String getFeesStatus() {
		return feesStatus;
	}

	public void setFeesStatus(String feesStatus) {
		this.feesStatus = feesStatus;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	
}
