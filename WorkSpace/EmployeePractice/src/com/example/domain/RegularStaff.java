package com.example.domain;

import java.util.Random;

public interface RegularStaff {
   public static final String[] gifts = {"汽車", "機票", "電視", "住宿券", "湯券", "1000圓", "銘謝" }; 
	
   public static String getLuckyDraw() {
	   int idx = new Random().nextInt(gifts.length);
	   return gifts[idx];
   }
   
   public default double calcPerfMulti() {
return (int)(Math.random()*5+1)*0.5;
	   }
   
public abstract double getBonus();
}
