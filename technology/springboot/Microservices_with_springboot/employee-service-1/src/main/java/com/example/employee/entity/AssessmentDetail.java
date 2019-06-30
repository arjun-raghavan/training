package com.example.employee.entity;

import java.util.Date;

public class AssessmentDetail {

	private String userId;
	private String assessmentName;
	private Date assessmentDate;
	private String assessmentType;

	public AssessmentDetail() {
	}

	/**
	 * @param userId
	 * @param assessmentName
	 * @param assessmentDate
	 * @param assessmentType
	 */
	public AssessmentDetail(String userId, String assessmentName, Date assessmentDate, String assessmentType) {
		super();
		this.userId = userId;
		this.assessmentName = assessmentName;
		this.assessmentDate = assessmentDate;
		this.assessmentType = assessmentType;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAssessmentName() {
		return assessmentName;
	}

	public void setAssessmentName(String assessmentName) {
		this.assessmentName = assessmentName;
	}

	public Date getAssessmentDate() {
		return assessmentDate;
	}

	public void setAssessmentDate(Date assessmentDate) {
		this.assessmentDate = assessmentDate;
	}

	public String getAssessmentType() {
		return assessmentType;
	}

	public void setAssessmentType(String assessmentType) {
		this.assessmentType = assessmentType;
	}

	@Override
	public String toString() {
		return "AssessmentDetail [userId=" + userId + ", assessmentName=" + assessmentName
				+ ", assessmentDate=" + assessmentDate + ", assessmentType=" + assessmentType + "]";
	}

}
