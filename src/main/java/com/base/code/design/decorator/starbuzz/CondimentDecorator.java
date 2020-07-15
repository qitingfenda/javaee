package com.base.code.design.decorator.starbuzz;

public abstract class CondimentDecorator extends Beverage {
	Beverage beverage;
	public abstract String getDescription();
}
