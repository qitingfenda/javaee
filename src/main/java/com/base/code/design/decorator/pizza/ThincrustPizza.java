package com.base.code.design.decorator.pizza;

public class ThincrustPizza extends Pizza {
  
	public ThincrustPizza() {
		description = "Thin crust pizza, with tomato sauce";
	}
  
	public double cost() {
		return 7.99;
	}
}

