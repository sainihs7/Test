package com.hibernate.main;

import com.hcl.loan.dao.LoanDao;
import com.hcl.loan.daoImp.LoanDaoImpl;

public class MainSelect {
	public static void main(String[] args) {
		LoanDao loanDaoObj = new LoanDaoImpl();
		loanDaoObj.showLoanDetails();
	}
}

