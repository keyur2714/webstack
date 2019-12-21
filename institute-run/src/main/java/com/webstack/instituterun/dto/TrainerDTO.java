package com.webstack.instituterun.dto;

public class TrainerDTO {

	private Long trainerId;
	private String trainerName;
	private String trainerMobileNo;
	private String trainerEmail;
	private String trainerType;
	private String compensationType;
	private Integer percentage;
	private Integer fixedPay;

	public Long getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(Long trainerId) {
		this.trainerId = trainerId;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public String getTrainerMobileNo() {
		return trainerMobileNo;
	}

	public void setTrainerMobileNo(String trainerMobileNo) {
		this.trainerMobileNo = trainerMobileNo;
	}

	public String getTrainerEmail() {
		return trainerEmail;
	}

	public void setTrainerEmail(String trainerEmail) {
		this.trainerEmail = trainerEmail;
	}

	public String getTrainerType() {
		return trainerType;
	}

	public void setTrainerType(String trainerType) {
		this.trainerType = trainerType;
	}

	public String getCompensationType() {
		return compensationType;
	}

	public void setCompensationType(String compensationType) {
		this.compensationType = compensationType;
	}

	public Integer getPercentage() {
		return percentage;
	}

	public void setPercentage(Integer percentage) {
		this.percentage = percentage;
	}

	public Integer getFixedPay() {
		return fixedPay;
	}

	public void setFixedPay(Integer fixedPay) {
		this.fixedPay = fixedPay;
	}

}
