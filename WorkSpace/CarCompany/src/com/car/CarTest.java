package com.car;

import java.util.*;

public class CarTest {
	static Set brands = new TreeSet();
	static List garage = new LinkedList();
	public static void main(String[] args) {
		System.out.println("收購車輛...");
		Scanner sc = new Scanner(System.in);
		while(garage.size()<8) {
			System.out.print("收購品牌:");
			String car = sc.nextLine();
			garage.add(car);
			boolean newBrand = brands.add(car);
			if(newBrand)
				System.out.println("新增品牌:"+car);
//			else
//				System.out.println("現有品牌:"+car);
		}
		printData();	
		
		System.out.print("輸入欲購買品牌:");
		String carWanted = sc.nextLine();
		while (!carWanted.equalsIgnoreCase("Quit") || garage.isEmpty()) {
			if(brands.contains(carWanted)) {
				int idx = garage.indexOf(carWanted);
				System.out.println("請至"+idx+"號車庫賞車");
				garage.remove(idx);
				if(!garage.contains(carWanted))
					brands.remove(carWanted);
				System.out.println(carWanted+"已銷售");
			} else {
				System.out.println("未銷售"+carWanted);
			}
			System.out.print("輸入欲購買品牌:");
			carWanted = sc.nextLine();
		}
		printData();
	}
	
	private static void printData() {
		System.out.println("銷售品牌:"+brands);
		System.out.println("現有車輛:"+garage);
	}

}
