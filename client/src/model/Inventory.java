package model;

import java.io.Serializable;

public class Inventory implements Serializable {

	private static final long serialVersionUID = 4801957816410214976L;

	private int id;

	private String name;

	private int itemsInStock;

	private float unitPrice;

	private String shortDescription;

	private String longDescription;

	public Inventory() {
	}

	public Inventory(String name, int itemsInStock, float unitPrice, String shortDescription, String longDescription) {
		this.name = name;
		this.itemsInStock = itemsInStock;
		this.unitPrice = unitPrice;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getItemsInStock() {
		return itemsInStock;
	}

	public float getUnitPrice() {
		return unitPrice;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setItemsInStock(int itemsInStock) {
		this.itemsInStock = itemsInStock;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	@Override
	public String toString() {
		return "id: " + id + "\nname: " + name + "\nitemsInStock: " + itemsInStock + "\nunitPrice: " + unitPrice
				+ "\nshortDescription: " + shortDescription + "\nlongDescription: " + longDescription;
	}

}
