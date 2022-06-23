package com.hibernate.main;
import com.hcl.loan.dao.LoanDao;
import com.hcl.loan.daoImp.LoanDaoImpl;

public class MainDelete {

	public static void main(String[] args) {
		
		LoanDaoImpl loanDaoObj = new LoanDaoImpl();
		loanDaoObj.removeLoanDetails();
		
	}

}
