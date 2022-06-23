package com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import  com.hcl.loan.Entity.*;
import org.hibernate.SessionFactory;

public class MainInsert {
	public static void main(String[] args) {
		SessionFactory sessionFactoryObj = new Configuration().configure("config/hibernate.cfg.xml").buildSessionFactory();
		Session sessionObj = sessionFactoryObj.openSession();
		Transaction txnObj = sessionObj.beginTransaction();
		
		Loan loanObj= new Loan();
		loanObj.setLoanId(2);
		loanObj.setLoanType("Personal Loan");


		sessionObj.save(loanObj);
		
		txnObj.commit();
		System.out.println("Record successfully inserted");
		sessionObj.close();
		sessionFactoryObj.close();
		
	}
}
