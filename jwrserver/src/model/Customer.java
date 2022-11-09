package model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer implements Serializable {

	private static final long serialVersionUID = 4801957816410214976L;

	//Creates variables 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customerID")
	private String id;

	@Column(name = "name")
	private String name;

	@Column(name = "dob")
	private LocalDate dob;

	@Column(name = "address")
	private String address;

	@Column(name = "telephone")
	private String telephone;

	@Column(name = "email")
	private String email;

	@Column(name = "dateOfMembership")
	private LocalDate dateOfMembership;

	@Column(name = "dateOfMembershipExpiry")
	private LocalDate dateOfMembershipExp;

	//create constructors
	public Customer() {
		this.id = (Math.random() * 99999999) + "";
		this.name = "name";
		this.dob = LocalDate.now();
		this.address = "address";
		this.telephone = "telephone";
		this.email = "email";
		this.dateOfMembership = LocalDate.now();
		this.dateOfMembershipExp = dateOfMembership.plusYears(4);
	}

	/*
	 * ID is auto assigned, which would then be their member code, and date of
	 * membership is 4 years after
	 *
	 * using LocalDate because that works in storing the date Date class giving
	 * messy values
	 */

	public Customer(String id ,String name, LocalDate dob, String address, String telephone, String email) {
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.address = address;
		this.telephone = telephone;
		this.email = email;
		this.dateOfMembership = LocalDate.now();
		this.dateOfMembershipExp = dateOfMembership.plusYears(4);
	}

	//create getters
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public String getAddress() {
		return address;
	}

	public String getTelephone() {
		return telephone;
	}

	public String getEmail() {
		return email;
	}

	public LocalDate getDateOfMembership() {
		return dateOfMembership;
	}

	public LocalDate getDateOfMembershipExp() {
		return dateOfMembershipExp;
	}

	//create setters
	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDateOfMembership(LocalDate dateOfMembership) {
		this.dateOfMembership = dateOfMembership;
	}

	public void setDateOfMembershipExp(LocalDate dateOfMembershipExp) {
		this.dateOfMembershipExp = dateOfMembershipExp;
	}

	//create tostring method
	@Override
	public String toString() {
		return "id: " + id + "\nname: " + name + "\ndob: " + dob + "\naddress: " + address + "\ntelephone: " + telephone
				+ "\nemail: " + email + "\ndateOfMembership: " + dateOfMembership + "\ndateOfMembershipExp: "
				+ dateOfMembershipExp;
	}

}
