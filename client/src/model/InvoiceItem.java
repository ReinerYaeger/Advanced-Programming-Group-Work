package model;

import java.io.Serializable;

public class InvoiceItem implements Serializable {

	private static final long serialVersionUID = 4801957816410214976L;
	//Creates variables 

	private Inventory productCode;

	private Invoice invoiceNum;

	private int quantity;

	//create constructors
	public InvoiceItem() {
	}

	public InvoiceItem(Inventory productCode, int quantity) {
		this.productCode = productCode;
		this.quantity = quantity;
	}

	//create getters
	public Inventory getProductCode() {
		return productCode;
	}

	public Invoice getInvoiceNum() {
		return invoiceNum;
	}

	public int getQuantity() {
		return quantity;
	}

	//create setters
	public void setProductCode(Inventory productCode) {
		this.productCode = productCode;
	}

	public void setInvoiceNum(Invoice invoiceNum) {
		this.invoiceNum = invoiceNum;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	//create tostring method
	@Override
	public String toString() {
		return "productCode: " + productCode + "\nquantity: " + quantity;
	}

}
