package com.example.domain;

import java.util.ArrayList;

public class Manager extends Employee implements RegularStaff{
	private String deptName;
	protected ArrayList employees;
	private double baseBonus = 100000;
	
	public Manager(String name, String ssn, double salary, Branch branch, String deptName) {
		super(name, ssn, salary,branch);
		this.deptName = deptName;	
		employees = new ArrayList();
	}

	
	@Override
	public double getPay() {
		double pay = this.getSalary()+ this.employees.size()*2000;
		return pay;
	}


	public String getDeptName() {
		return deptName;
	}

	public boolean addEmployee(Employee emp) {
		if(employees.contains(emp))
			return false;
		else {
			employees.add(emp);
			return true;
		}
	}
	
	public boolean removeEmployee(Employee emp) {
		if(!employees.contains(emp)) 
			return false;
			employees.remove(emp);
			return true;
		}
		
	

	
	public String getStaffDetails() {
		StringBuilder sb = new StringBuilder();
		if(!employees.isEmpty()) {
			sb.append(String.format("%s管理員工:", this.getName()));
			for(Object obj: employees) {
				if(obj instanceof Employee) {
					Employee e = (Employee)obj;
					sb.append(String.format(" %s(%d)", e.getName(),e.getEmpId()));

				}
			}
			sb.append("\n");			
		}
		return sb.toString();
	}
	
	
	@Override
	public String toString() {
		return super.toString()+
				"管理部門: "+this.deptName +"\n"+
				this.getStaffDetails();
	}


	@Override
	public double getBonus() {
		// TODO Auto-generated method stub
		return this.baseBonus*this.calcPerfMulti();
	}

	
	
	}


