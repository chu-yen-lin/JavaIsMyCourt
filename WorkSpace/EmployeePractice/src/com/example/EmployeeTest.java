package com.example;

import java.text.NumberFormat;

import com.example.domain.*;

public class EmployeeTest {
	public static void main(String[] args)  {
		 
		Employee[] emps = new Employee[5];
		emps[0] = new Admin("Sean", "A123456789", 50000, Branch.London);
		emps[1] = new Admin("Amy", "B210987654", 80000, Branch.Taipei);
		emps[2] = new Engineer("David", "C109876543", 100000, Branch.Tokyo);
		emps[3] = new Manager("Louis", "D124680135", 120000,Branch.Taipei, "Pony");
		emps[4]= new Director("Nicole", "R202468135", 140000,Branch.Paris, "Rentacar", 1000000);

		for(int i=0; i<emps.length; i++)
			System.out.println(emps[i]);
			
		
		System.out.println("\nDavid 學會了Java和Android, 加薪5000元");
		if(emps[2] instanceof Engineer) {
			Engineer eng = (Engineer )emps[2];
			eng.addSkill("Java");
			eng.addSkill("Android");
		}
		emps[2].raiseSalary(5000);
		
		System.out.println("部門分配.....");
		if(emps[3] instanceof Manager) {
			Manager m1 = (Manager)emps[3];
			m1.addEmployee(emps[0]);
			m1.addEmployee(emps[1]);
			m1.addEmployee(emps[2]);
		}
		
		((Manager)emps[4]).addEmployee(emps[3]);
		
		System.out.println("\n設定本月工時:Sean(120hrs), Amy(180hrs)... ");
		((Admin)emps[0]).setHours(120);
		((Admin)emps[1]).setHours(180);
		
		for(int i=0; i<emps.length; i++) {
			System.out.println(emps[i]);
			System.out.println("本月薪資領: "+emps[i].getBranch().getCurrency()+emps[i].getPay()+"元");
			if(emps[i] instanceof RegularStaff) {
				System.out.printf("%s年終獎金%s%.0f元%n",emps[i].getName(),emps[i].getBranch().getCurrency(),((RegularStaff)emps[i]).getBonus());
				System.out.printf("尾牙抽到:%s%n", RegularStaff.getLuckyDraw());
			}
		}
	}
}
