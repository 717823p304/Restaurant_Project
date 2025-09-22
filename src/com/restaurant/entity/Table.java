package com.restaurant.entity;

public class Table {
	private int tableId;
    private boolean occupied;

    public Table(int tableId) {
        this.tableId = tableId;
        this.occupied = false;
    }

    public int getTableId() { return tableId; }
    public boolean isOccupied() { return occupied; }
    public void occupy() { this.occupied = true; }
    public void free() { this.occupied = false; }
}
