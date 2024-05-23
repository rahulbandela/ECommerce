package com.tap.model;

public class cart extends Menu
{
	
	private int quantity;

	public cart() {
		super();
	}

	public cart(int quantity) {
		super();
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
