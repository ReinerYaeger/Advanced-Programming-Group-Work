package model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Staff")
public class Staff implements Serializable {

	private static final long serialVersionUID = 4801957816410214976L;

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "uuid2")
	@Column(name = "staffID")
	// Creates variable
	protected String id;

	@Column(name = "name")
	// Creates variable
	protected String name;

	@Column(name = "dob")
	// Creates variable
	protected LocalDate dob;

	@Column(name = "address")
	// Creates variable
	protected String address;

	@Column(name = "telephone")

	// Creates variables
	protected String telephone;

	@Column(name = "email")
	// Creates variables
	protected String email;

	@Column(name = "type")
	// Creates variables
	protected String type; // Manager,Supervisor,Line-Worker

/*	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "department")
	protected Department department;*/

	// create constructors
	public Staff() {
		this.name = "name";
		this.dob = LocalDate.now();
		this.address = "address";
		this.telephone = " ";
		this.email = "email";
		this.type = "type";
	}

	//create a copy constructor
	public Staff(Staff staff){
		this.name = staff.name;
		this.dob = staff.dob;
		this.address = staff.address;
		this.telephone = staff.telephone;
		this.email = staff.email;
		this.type = staff.type;
	}

	/*
	 * The department has to be set by retrievnig it fromt he database then adding
	 * it using set method before saving to db
	 */
	public Staff(String name, LocalDate dob, String address, String telephone, String email, String type) {
		this.name = name;
		this.dob = dob;
		this.address = address;
		this.telephone = telephone;
		this.email = email;
		this.type = type;
	}

	// create getters
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

	public String getType() {
		return type;
	}

	/*public Department getDepartment() {
		return department;
	}*/

	// create setters
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

	public void setType(String type) {
		this.type = type;
	}

/*	public void setDepartment(Department department) {
		this.department = department;
	}*/

	// create tostring method
	@Override
	public String toString() {
		return "id: " + id + "\nname: " + name + "\ndob: " + dob + "\naddress: " + address + "\ntelephone: " + telephone
				+ "\nemail: " + email + "\ntype: " + type;
	}

}
