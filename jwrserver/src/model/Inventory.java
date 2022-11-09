package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Inventory")
public class Inventory implements Serializable {

	private static final long serialVersionUID = 4801957816410214976L;

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "uuid2")
	@Column(name = "productCode")
	// Creates variable
	private String id;

	@Column(name = "name")
	// Creates variable
	private String name;

	@Column(name = "itemsInStock")
	// Creates variable
	private int itemsInStock;

	@Column(name = "unitPrice")
	// Creates variable
	private float unitPrice;

	@Column(name = "shortDescription")
	// Creates variable
	private String shortDescription;

	@Column(name = "longDescription")
	// Creates variable
	private String longDescription;

	// create constructors
	public Inventory() {
	}

	public Inventory(String name, int itemsInStock, float unitPrice, String shortDescription, String longDescription) {
		this.name = name;
		this.itemsInStock = itemsInStock;
		this.unitPrice = unitPrice;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
	}

	// create getters
	public String getId() {
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

	// create setters
	public void setId(String id) {
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

	// create tostring method
	@Override
	public String toString() {
		return "id: " + id + "\nname: " + name + "\nitemsInStock: " + itemsInStock + "\nunitPrice: " + unitPrice
				+ "\nshortDescription: " + shortDescription + "\nlongDescription: " + longDescription;
	}

}
