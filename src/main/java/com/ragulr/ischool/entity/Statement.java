package com.ragulr.ischool.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Statement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int statementId;

	private String statementMonth;

	private String issuedBy;

	private Date dateOfIssue;

	private int securityFee;

	private int admissionFee;

	private int totalFee;

	private boolean isPaid;

	@OneToOne()
	@JoinColumn(unique = false)
	private Student paymentRecipient;

	public int getStatementId() {
		return statementId;
	}

	public void setStatementId(int statementId) {
		this.statementId = statementId;
	}

	public String getStatementMonth() {
		return statementMonth;
	}

	public void setStatementMonth(String statementMonth) {
		this.statementMonth = statementMonth;
	}

	public String getIssuedBy() {
		return issuedBy;
	}

	public void setIssuedBy(String issuedBy) {
		this.issuedBy = issuedBy;
	}

	public Date getDateOfIssue() {
		return dateOfIssue;
	}

	public void setDateOfIssue(Date dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

	public int getSecurityFee() {
		return securityFee;
	}

	public void setSecurityFee(int securityFee) {
		this.securityFee = securityFee;
	}

	public int getAdmissionFee() {
		return admissionFee;
	}

	public void setAdmissionFee(int admissionFee) {
		this.admissionFee = admissionFee;
	}

	public int getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(int totalFee) {
		this.totalFee = totalFee;
	}

	public boolean isPaid() {
		return isPaid;
	}

	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}

	public Student getPaymentRecipient() {
		return paymentRecipient;
	}

	public void setPaymentRecipient(Student paymentRecipient) {
		this.paymentRecipient = paymentRecipient;
	}

	@Override
	public String toString() {
		return "Statement [statementId=" + statementId + ", statementMonth=" + statementMonth + ", issuedBy=" + issuedBy
				+ ", dateOfIssue=" + dateOfIssue + ", securityFee=" + securityFee + ", admissionFee=" + admissionFee
				+ ", totalFee=" + totalFee + ", isPaid=" + isPaid + ", paymentRecipient=" + paymentRecipient + "]";
	}

}
