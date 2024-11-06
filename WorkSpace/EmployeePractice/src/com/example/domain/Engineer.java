package com.example.domain;

import java.util.Arrays;

public class Engineer extends Employee implements RegularStaff{
	private String[] skills;
	private int skillCount;
	
	public Engineer(String name, String ssn, double salary, Branch branch) {
		super(name, ssn, salary, branch);
		this.skills = new String[5];
		this.skillCount = 0;
	}
	
	
	@Override
	public double getPay() {
		// TODO Auto-generated method stub
		return this.getSalary()+this.skillCount*3000;
	}


	public void addSkill(String skill) {
		if(skillCount<5)
			skills[skillCount++] = skill;
		else
			System.out.println("最多註冊五種技能,新增失敗!");
	}

	


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		if(skillCount>0) {
			sb.append("技能: ");
			for(int i=0; i<skillCount; i++)
				sb.append(skills[i]+" ");
			sb.append("\n");
		
	}
		return sb.toString();
	
	
	}


	@Override
	public double getBonus() {
		// TODO Auto-generated method stub
		return this.getSalary()*this.calcPerfMulti();
	}
}
