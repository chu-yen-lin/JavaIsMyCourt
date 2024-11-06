package com.example.domain;

public class Director extends Manager {
	private double budget;
	private double baseBonus = 500000;

	public Director(String name, String ssn, double salary, Branch branch, String deptName, double budget) {
		super(name, ssn, salary,branch, deptName);
		this.budget = budget;
	}
	

	@Override
	public double getPay() {
		// TODO Auto-generated method stub
		return this.getSalary()+employees.size()*10000;
	}


	public double getBudget() {
		return budget;
	}


	@Override
	public double getBonus() {
		// TODO Auto-generated method stub
		return this.baseBonus*this.calcPerfMulti();
	}


	@Override
	public String toString() {
		return super.toString()+
		"管理預算: "+this.getBranch().getCurrency() +formatter.format(budget)+"\n";
	}
	
}
