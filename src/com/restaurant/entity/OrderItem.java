package com.restaurant.entity;

public class OrderItem {
	 private MenuItem item;
	    private int quantity;

	    public OrderItem(MenuItem item, int quantity) {
	        this.item = item;
	        this.quantity = quantity;
	    }

	    public double getTotal() {
	        return item.getPrice() * quantity;
	    }

	    public MenuItem getItem() { return item; }
	    public int getQuantity() { return quantity; }
}
