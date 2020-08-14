package com.base.code.design.command.dinerLambda;

public class Waitress {
	Order order;
	public Waitress() {}
	public void takeOrder(Order order) {
		this.order = order; 
		order.orderUp();
	}
}