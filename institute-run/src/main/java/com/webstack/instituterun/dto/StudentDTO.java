package com.webstack.instituterun.dto;

import java.sql.Date;

public class StudentDTO {

	private Long id;
	private String name;
	private String mobileNo;
	private String email;

	private Long totalFees;
	private Integer discount;
	private Long finalFees;
	private Long feesPaid;
	private Long feesRemaining;
	private String feesStatus;
	private Date registrationDate;

	private Long courseId;
	private String courseCode;
	private String courseName;
	private Long fees;

	private Long batchId;
	private String batchName;
	private String batchType;
	private String batchTime;
	
	private boolean selected;

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

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Long getFees() {
		return fees;
	}

	public void setFees(Long fees) {
		this.fees = fees;
	}

	public Long getBatchId() {
		return batchId;
	}

	public void setBatchId(Long batchId) {
		this.batchId = batchId;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public String getBatchType() {
		return batchType;
	}

	public void setBatchType(String batchType) {
		this.batchType = batchType;
	}

	public String getBatchTime() {
		return batchTime;
	}

	public void setBatchTime(String batchTime) {
		this.batchTime = batchTime;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	
}
