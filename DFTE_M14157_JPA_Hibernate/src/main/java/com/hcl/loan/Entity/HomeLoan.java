package com.hcl.loan.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="homeloan_table2")
@PrimaryKeyJoinColumn(name="ID")
public class HomeLoan extends Loan {
//	@Id
	@Column
	private double loanAmount;

	@Column
	private double tenure;
	
	@Column
	private double interestRate;
	
	public HomeLoan() {
		
	}

	public HomeLoan(double loanAmount, double tenure, double interestRate) {
		super();
		this.loanAmount = loanAmount;
		this.tenure = tenure;
		this.interestRate = interestRate;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public double getTenure() {
		return tenure;
	}

	public void setTenure(double tenure) {
		this.tenure = tenure;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

}
