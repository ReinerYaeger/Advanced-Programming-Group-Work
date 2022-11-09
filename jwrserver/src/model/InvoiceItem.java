package model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "InvoiceItem")
public class InvoiceItem implements Serializable {

	private static final long serialVersionUID = 4801957816410214976L;

	@Id
	@OneToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "productCode")
	//Creates variables 
	private Inventory productCode;

	@Id
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "invoiceNum")
	//Creates variables 
	private Invoice invoiceNum;

	@Column(name = "quantityOfItem")
	//Creates variables 
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
