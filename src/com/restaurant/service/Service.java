package com.restaurant.service;
import com.restaurant.entity.*;
import java.util.List;
import java.util.Scanner;

public class Service {
	private Scanner sc = new Scanner(System.in);

    public Order createOrder(List<Table> tables, List<MenuItem> menu, int orderId) {
        // Step 1: Choose type
        System.out.print("Enter order type (1 for Dine-In, 2 for Take-Away): ");
        int typeChoice = sc.nextInt();
        sc.nextLine();
        String orderType = (typeChoice == 1) ? "Dine-In" : "Take-Away";

        Table selectedTable = null;
        if (orderType.equals("Dine-In")) {
            System.out.println("Available Tables:");
            for (Table t : tables) {
                if (!t.isOccupied()) {
                    System.out.println("Table " + t.getTableId());
                }
            }
            System.out.print("Choose table: ");
            int tableChoice = sc.nextInt();
            sc.nextLine();
            selectedTable = tables.get(tableChoice - 1);
            selectedTable.occupy();
        }

        // Step 2: Create Order
        Order order = new Order(orderId, orderType, selectedTable);

        // Step 3: Take items
        boolean ordering = true;
        while (ordering) {
            System.out.println("\nMenu:");
            for (int i = 0; i < menu.size(); i++) {
                MenuItem item = menu.get(i);
                System.out.println((i + 1) + ". " + item.getName() + " - ₹" + item.getPrice());
            }
            System.out.print("Choose item (0 to finish): ");
            int choice = sc.nextInt();
            if (choice == 0) {
                ordering = false;
            } else {
                MenuItem chosen = menu.get(choice - 1);
                System.out.print("Quantity: ");
                int qty = sc.nextInt();
                order.addItem(new OrderItem(chosen, qty));
            }
        }
        return order;
}
}
