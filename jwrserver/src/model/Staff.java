package model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Staff")
public class Staff implements Serializable {

	private static final long serialVersionUID = 4801957816410214976L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "staffID")
	//Creates variable 
	private int id;

	@Column(name = "name")
	//Creates variable
	private String name;

	@Column(name = "dob")
	//Creates variable
	private LocalDate dob;

	@Column(name = "address")
	//Creates variable
	private String address;

	@Column(name = "telephone")
	
	//Creates variables 
	private Long telephone;

	@Column(name = "email")
	//Creates variables 
	private String email;

	@Column(name = "type")
	//Creates variables 
	private String type; // Manager,Supervisor,Line-Worker

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "department")
	private Department department;

	//create constructors
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

	//create getters
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

	//create setters
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

	//create tostring method
	@Override
	public String toString() {
		return "id: " + id + "\nname: " + name + "\ndob: " + dob + "\naddress: " + address + "\ntelephone: " + telephone
				+ "\nemail: " + email + "\ntype: " + type + "\ndepartment: " + department;
	}

}
