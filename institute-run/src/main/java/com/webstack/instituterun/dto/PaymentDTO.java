package com.webstack.instituterun.dto;

import java.sql.Date;

public class PaymentDTO {

	private Long id;
	private String paymentType;
	private String paymentRefNo;
	private Date paymentDate;
	private Long paymentReceived;
	private Long studentId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getPaymentRefNo() {
		return paymentRefNo;
	}

	public void setPaymentRefNo(String paymentRefNo) {
		this.paymentRefNo = paymentRefNo;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Long getPaymentReceived() {
		return paymentReceived;
	}

	public void setPaymentReceived(Long paymentReceived) {
		this.paymentReceived = paymentReceived;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

}
