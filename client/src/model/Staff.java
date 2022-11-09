package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Staff implements Serializable {

	private static final long serialVersionUID = 4801957816410214976L;
	// Creates variables

	private String id;

	private String name;

	private LocalDate dob;

	private String address;

	private String telephone;

	private String email;

	private String type; // Manager,Supervisor,Line-Worker
	protected String password;

	private Department department;

	// create constructors
	public Staff() {
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

	public Staff(String name, String password, LocalDate dob, String address, String telephone, String email, String type, Department department) {
		this.name = name;
		this.password = password;
		this.dob = dob;
		this.address = address;
		this.telephone = telephone;
		this.email = email;
		this.type = type;
		this.department = department;
	}

	public Staff(String name, String password, LocalDate dateOfBirth, String address, String telephone, String email , Department department, String type) {
		this.name = name;
		this.password = password;
		this.dob = dateOfBirth;
		this.address = address;
		this.telephone = telephone;
		this.email = email;
		this.department = department;
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

	public Department getDepartment() {
		return department;
	}

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

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getPassword( ) {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// create tostring method
	@Override
	public String toString() {
		return "id: " + id + "\nname: " + name + "\ndob: " + dob + "\naddress: " + address + "\ntelephone: " + telephone
				+ "\nemail: " + email + "\ntype: " + type + "\ndepartment: " + department;
	}

}
