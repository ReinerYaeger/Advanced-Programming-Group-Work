package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Invoice")
public class Invoice implements Serializable {

	private static final long serialVersionUID = 4801957816410214976L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "invoiceNum")
	private int invoiceNum;

	@Column(name = "billingDate")
	private LocalDate billingDate;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "cashier")
	private Staff cashier;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "customer", nullable = true)
	private Customer customer;

	/*
	 * When Retrieving a invoice it will automatically get a list of invoicenum with
	 * the same invoicenumber
	 */
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "invoiceNum", cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH })
	private List<InvoiceItem> items;

	public Invoice() {
	}

	/*
	 * The Cashier and customer will be set using the database when a cashier log in
	 * it will keep their data then when a invoice is made passed ot the server
	 * which will add the cashier to the invoice and when a customer code is added
	 * it will be sent to the server which will look it up and add the customer to
	 * it else if its a random customer with no code it will be empty and no
	 * discount
	 */
	public Invoice(Staff staff) {
		this.billingDate = LocalDate.now();
		this.cashier = staff;
	}

	public int getInvoiceNum() {
		return invoiceNum;
	}

	public LocalDate getBillingDate() {
		return billingDate;
	}

	public Staff getCashier() {
		return cashier;
	}

	public Customer getCustomer() {
		return customer;
	}

	public List<InvoiceItem> getItems() {
		return items;
	}

	public void setInvoiceNum(int invoiceNum) {
		this.invoiceNum = invoiceNum;
	}

	public void setBillingDate(LocalDate billingDate) {
		this.billingDate = billingDate;
	}

	public void setCashier(Staff cashier) {
		this.cashier = cashier;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setItems(List<InvoiceItem> items) {
		this.items = items;
	}

	/*
	 * Method to add invoiceitems to this invoice it will set the invoice of the
	 * item to this so when saved to database it will show
	 */
	public void addItem(InvoiceItem item) {

		if (items == null)
			items = new ArrayList<>();

		items.add(item);

		item.setInvoiceNum(this);
	}

	@Override
	public String toString() {
		return "invoiceNum: " + invoiceNum + "\nbillingDate: " + billingDate + "\ncashier: " + cashier + "\ncustomer: "
				+ customer + "\nitems: " + items;
	}

}
