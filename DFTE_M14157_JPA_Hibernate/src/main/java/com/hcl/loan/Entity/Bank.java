package com.hcl.loan.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="bank_table2")
public class Bank {
	@Id
//	@GeneratedValue(strategy=GenerationType.TABLE)
	private int bankCode;
	private String bankName;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Customer> customers;
	public Bank() {
		
	}
	public Bank(int bankCode, String bankName, List<Customer> customers) {
		super();
		this.bankCode = bankCode;
		this.bankName = bankName;
		this.customers = customers;
	}
	public int getBankCode() {
		return bankCode;
	}
	public void setBankCode(int bankCode) {
		this.bankCode = bankCode;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public List<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

}
