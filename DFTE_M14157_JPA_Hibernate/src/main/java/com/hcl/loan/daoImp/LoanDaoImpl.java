package com.hcl.loan.daoImp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hcl.loan.Entity.Loan;
import com.hcl.loan.dao.*;

public class LoanDaoImpl implements LoanDao{
	SessionFactory sessionFactoryObj;
	Session sessionObj;
	Transaction txnObj;
	Loan loanObj;
	
	@Override
	public void addLoanDetails() {
		sessionFactoryObj = new Configuration().configure("config/hibernate.cfg.xml").buildSessionFactory();
		sessionObj = sessionFactoryObj.openSession();
		txnObj = sessionObj.beginTransaction();

		loanObj = new Loan();
		loanObj.setLoanId(1);
		loanObj.setLoanType("Home Loan");

		sessionObj.save(loanObj);
		txnObj.commit();

		System.out.println("The record has been successfully inserted");
		sessionObj.close();
		sessionFactoryObj.close();

	}
	@Override
	public void showLoanDetails() {
		sessionFactoryObj = new Configuration().configure("config/hibernate.cfg.xml").buildSessionFactory();
		sessionObj = sessionFactoryObj.openSession();
		txnObj = sessionObj.beginTransaction();

		Query selectQuery = sessionObj.createQuery("from com.hcl.loan.Entity.Loan");
		List<Loan> listOfRecords = selectQuery.list();
		for(Loan loanObj:listOfRecords) {
			System.out.println(loanObj.getLoanId()+"\t"+loanObj.getLoanType());
		}
		txnObj.commit();
		sessionObj.close();
		sessionFactoryObj.close();

	}
	@Override
	public void editLoanDetails() {
		sessionFactoryObj = new Configuration().configure("config/hibernate.cfg.xml").buildSessionFactory();
		sessionObj = sessionFactoryObj.openSession();
		txnObj = sessionObj.beginTransaction();
		
//Type1	Query selectQuery = sessionObj.createQuery("update com.hcl.loan.Entity.Loan set loanType='Home Loan11' where loanId =2");
//		selectQuery.setParameter(1, "Personal Loan 1");
//		selectQuery.setParameter(2, 1);
		
		Query selectQuery = sessionObj.createQuery("update com.hcl.loan.Entity.Loan set loanType=:loanType where loanId =:loanId");
		selectQuery.setParameter("loanType", "Personal Loan 2");
		selectQuery.setParameter("loanId", 2);
		
//Type3	Query selectQuery = sessionObj.createQuery("update Loan set loanType=? where loanId =?");
//		selectQuery.setParameter(0, "Personal Loan 1");
//		selectQuery.setParameter(1, 2);
		
		selectQuery.executeUpdate();
		
		txnObj.commit();
		System.out.println("Record has been updated");
		sessionObj.close();
		sessionFactoryObj.close();
	}
		@Override
		public void removeLoanDetails() {
		sessionFactoryObj = new Configuration().configure("config/hibernate.cfg.xml").buildSessionFactory();
		sessionObj = sessionFactoryObj.openSession();
		txnObj = sessionObj.beginTransaction(); 

		Query selectQuery = sessionObj.createQuery("delete com.hcl.loan.Entity.Loan where loanId =2");
		selectQuery.executeUpdate();
		
		txnObj.commit();
		System.out.println("Record has been deleted");
		sessionObj.close();
		sessionFactoryObj.close();
		
		}
}
