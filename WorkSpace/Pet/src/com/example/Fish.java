package com.example;

public class Fish extends Animal implements Pet{

	public Fish() {
		super(0);
	}
	
	@Override
	public void eat() {
		System.out.println("大魚吃小魚");
	}

	@Override
	public void walk() {
		System.out.println("魚沒有腳,只會游泳");
	}
	
	public void walk() {
		System.out.println("欣賞魚在水裡游泳");
	}

	
}
