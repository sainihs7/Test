package com.hibernate.main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hcl.loan.Entity.Bank;
import com.hcl.loan.Entity.Customer;
import com.hcl.loan.Entity.HomeLoan;

public class MainMapping {
	public static void main(String[] args) {
		SessionFactory sessionFactoryObj = new Configuration().configure("config/hibernate.cfg.xml")
				.buildSessionFactory();
		Session sessionObj = sessionFactoryObj.openSession();
		Transaction txnObj = sessionObj.beginTransaction();

		Customer custObj1 = new Customer(101, "James");
		Customer custObj2 = new Customer(102, "Mack");
		Customer custObj3 = new Customer(103, "John");

		List<Customer> customerList = new ArrayList<>();
		customerList.add(custObj1);
		customerList.add(custObj2);
		customerList.add(custObj3);

		Bank bankObj = new Bank();
		bankObj.setBankCode(1);
		bankObj.setBankName("Axis");
		bankObj.setCustomers(customerList);

		sessionObj.save(custObj1);
		sessionObj.save(custObj2);
		sessionObj.save(custObj3);
		sessionObj.save(bankObj);

		txnObj.commit();
		System.out.println("Success");

		sessionObj.close();
		sessionFactoryObj.close();

	}
}
