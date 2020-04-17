package com.techelevator.dog;

public class Dog {

	private boolean isSleeping = false;
	
	public Dog() {
		
	}

	public boolean isSleeping() {
		return isSleeping;
	}
	
	public String makeSound() {
		if (isSleeping == true) {
			return "Zzzzz...";
		}return "Woof!";
	}
	
	public void sleep() {
		this.isSleeping = true;
	}
	
	public void wakeUp() {
		this.isSleeping = false;
	}
	
}
