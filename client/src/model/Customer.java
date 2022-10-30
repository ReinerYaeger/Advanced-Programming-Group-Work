package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Customer implements Serializable {

	private static final long serialVersionUID = 4801957816410214976L;

	private int id;

	private String name;

	private LocalDate dob;

	private String address;

	private String telephone;

	private String email;

	private LocalDate dateOfMembership;

	private LocalDate dateOfMembershipExp;

	public Customer() {
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

	public Customer(String name, LocalDate dob, String address, String telephone, String email) {
		this.name = name;
		this.dob = dob;
		this.address = address;
		this.telephone = telephone;
		this.email = email;
		this.dateOfMembership = LocalDate.now();
		this.dateOfMembershipExp = dateOfMembership.plusYears(4);
	}

	public int getId() {
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

	public void setId(int id) {
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

	@Override
	public String toString() {
		return "id: " + id + "\nname: " + name + "\ndob: " + dob + "\naddress: " + address + "\ntelephone: " + telephone
				+ "\nemail: " + email + "\ndateOfMembership: " + dateOfMembership + "\ndateOfMembershipExp: "
				+ dateOfMembershipExp;
	}

}
