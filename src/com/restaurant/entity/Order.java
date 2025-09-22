package com.restaurant.entity;
import java.util.ArrayList;
import java.util.List;
public class Order {
	 private int orderId;
	    private String orderType; // "Dine-In" or "Take-Away"
	    private Table table;
	    private List<OrderItem> items;

	    public Order(int orderId, String orderType, Table table) {
	        this.orderId = orderId;
	        this.orderType = orderType;
	        this.table = table;
	        this.items = new ArrayList<>();
	    }

	    public void addItem(OrderItem item) { items.add(item); }

	    public double calculateTotal() {
	        return items.stream().mapToDouble(OrderItem::getTotal).sum();
	    }

	    public void printBill() {
	        System.out.println("Order #" + orderId + " (" + orderType + ")");
	        if (orderType.equals("Dine-In") && table != null) {
	            System.out.println("Table: " + table.getTableId());
	        }
	        System.out.println("Items:");
	        for (OrderItem item : items) {
	            System.out.println("- " + item.getItem().getName() + " x" + item.getQuantity() +
	                               " = ₹" + item.getTotal());
	        }
	        System.out.println("Total: ₹" + calculateTotal());
	    }
}
