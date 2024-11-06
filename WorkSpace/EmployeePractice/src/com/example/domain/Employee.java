package com.example.domain;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;

public abstract class Employee {
	public static int nextId = 101;
	private int empId;
	private String name = "John";
	private String ssn = "A123456789";
	private double salary = 26400;
	private Branch branch;
	protected NumberFormat formatter = NumberFormat.getInstance();
	
	public Employee(String name, String ssn, double salary, Branch branch) {
		this.empId = nextId++;
		if(name!=null && name.length()!=0)
			this.name = name;
		if(ssn!=null && ssn.length()!=0)
			this.ssn = ssn;
		if(salary>26400)
			this.salary = salary;
		this.branch= branch;
	}
public abstract double getPay();
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime*result+ empId;
		result = prime*result+ ((ssn==null) ? 0 : ssn.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		
	}
		if (!(obj instanceof Employee)) {
			return false;}
		Employee other = (Employee) obj;
		if(empId !=other.empId) {
			return false;
		}
		if(ssn==null) {
			if(other.ssn !=null) {
				return false;
			}
		}else if (!ssn.equals(other.ssn)) {
			return false;
		}
		return true;
		}

	public int getEmpId() {
		return empId;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		if(name!=null && name.length()!=0)
			this.name = name;
		else
			System.out.println("參數為空值改名失敗!");
	}

	public String getSsn() {
		return ssn;
	}

	public double getSalary() {
		return salary;
	}


	public Branch getBranch() {
		return branch;
	}
	public void raiseSalary(double increase) {
		if(increase>0)
			this.salary += increase;
		else
			System.out.println("參數錯誤加薪失敗!");
	}
	
	@Override
	public String toString() {
		return "======員工資料======\n" + 
				"編號: "+this.empId +"\n"+
				"姓名: "+this.name +"\n"+
				"SSN: "+this.ssn+"\n"+ 
				"薪水: "+this.branch.getCurrency()+ formatter.format(this.salary)+ "\n";
	}


	
	
}
