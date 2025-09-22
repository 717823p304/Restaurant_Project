package com.restaurant.app;
import com.restaurant.entity.*;
import com.restaurant.service.Service;

import java.util.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<MenuItem> menu = Arrays.asList(
                new MenuItem("Pizza", 250),
                new MenuItem("Burger", 120),
                new MenuItem("Pasta", 180)
        );

        List<Table> tables = Arrays.asList(new Table(1), new Table(2), new Table(3));

        Service service = new Service();

        Order order = service.createOrder(tables, menu, 1);

        System.out.println("\n===== BILL =====");
        order.printBill();
	}

}
