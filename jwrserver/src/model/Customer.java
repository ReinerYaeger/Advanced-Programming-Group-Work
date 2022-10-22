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

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "dob")
	private Date dob;

	@Column(name = "address")
	private String address;

	@Column(name = "telephone")
	private Long telephone;

	@Column(name = "email")
	private String email;

	@Column(name = "dateOfMembership")
	private Date dateOfMembership;

	@Column(name = "dateOfMembershipExpiry")
	private Date dateOfMembershipExp;

	public Customer() {

		this.dateOfMembership.now();
		this.dateOfMembershipExp.getToday().plusYears(4);
	}

	/*
	 * ID is auto assigned, which would then be their member code, and model.date of
	 * membership is 4 years after
	 *
	 * using LocalDate because that works in storing the model.date Date class giving
	 * messy values
	 */

	public Customer(String name, Date dob, String address,
					Long telephone, String email) {
		this.name = name;
		this.dob = dob;
		this.address = address;
		this.telephone = telephone;
		this.email = email;
		this.dateOfMembership = new Date();
		dateOfMembership.now();

		this.dateOfMembershipExp = new Date();
		this.dateOfMembershipExp.now().plusYears(4);
	}

	public Customer(String name, Date dob, String address,
					Long telephone, String email, Date dateOfMembership, Date dateOfMembershipExp) {
		this.name = name;
		this.dob = dob;
		this.address = address;
		this.telephone = telephone;
		this.email = email;
		this.dateOfMembership = dateOfMembership;
		this.dateOfMembershipExp = dateOfMembershipExp;
	}

	public int getId( ) {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName( ) {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob( ) {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAddress( ) {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getTelephone( ) {
		return telephone;
	}

	public void setTelephone(Long telephone) {
		this.telephone = telephone;
	}

	public String getEmail( ) {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateOfMembership( ) {
		return dateOfMembership;
	}

	public void setDateOfMembership(Date dateOfMembership) {
		this.dateOfMembership = dateOfMembership;
	}

	public Date getDateOfMembershipExp( ) {
		return dateOfMembershipExp;
	}

	public void setDateOfMembershipExp(Date dateOfMembershipExp) {
		this.dateOfMembershipExp = dateOfMembershipExp;
	}

	@Override
	public String toString() {
		return "id: " + id + "\nname: " + name + "\ndob: " + dob + "\naddress: " + address + "\ntelephone: " + telephone
				+ "\nemail: " + email + "\ndateOfMembership: " + dateOfMembership + "\ndateOfMembershipExp: "
				+ dateOfMembershipExp;
	}

}
