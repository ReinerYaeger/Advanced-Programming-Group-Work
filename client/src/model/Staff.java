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

	private Long telephone;

	private String email;

	private String type; // Manager,Supervisor,Line-Worker

	private Department department;

	// create constructors
	public Staff() {
	}

	/*
	 * The department has to be set by retrievnig it fromt he database then adding
	 * it using set method before saving to db
	 */
	public Staff(String name, LocalDate dob, String address, Long telephone, String email, String type) {
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

	public Long getTelephone() {
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

	public void setTelephone(Long telephone) {
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

	// create tostring method
	@Override
	public String toString() {
		return "id: " + id + "\nname: " + name + "\ndob: " + dob + "\naddress: " + address + "\ntelephone: " + telephone
				+ "\nemail: " + email + "\ntype: " + type + "\ndepartment: " + department;
	}

}
