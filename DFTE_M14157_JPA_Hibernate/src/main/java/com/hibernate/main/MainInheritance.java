package com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hcl.loan.Entity.HomeLoan;
import com.hcl.loan.Entity.Loan;

public class MainInheritance {
	public static void main(String[] args) {
		SessionFactory sessionFactoryObj = new Configuration().configure("config/hibernate.cfg.xml").buildSessionFactory();
		Session sessionObj = sessionFactoryObj.openSession();
		Transaction	txnObj = sessionObj.beginTransaction();

//		Loan loanObj = new Loan();
////	loanObj.setLoanId(1);
//		loanObj.setLoanType("Home Loan");
//		
		HomeLoan homeLoanObj = new HomeLoan();
		homeLoanObj.setLoanAmount(10000.00);
		homeLoanObj.setTenure(12);			//months
		homeLoanObj.setInterestRate(18.0);
		

	//	sessionObj.save(loanObj);
		sessionObj.save(homeLoanObj);
		txnObj.commit();

		System.out.println("The record has been successfully inserted");
		sessionObj.close();
		sessionFactoryObj.close();

	}
}
