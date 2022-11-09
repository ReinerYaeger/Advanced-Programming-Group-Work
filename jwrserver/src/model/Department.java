package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Department")
public class Department implements Serializable {

	private static final long serialVersionUID = 4801957816410214976L;

	// primary key
	@Id
	@Column(name = "departmentCode")
	//Creates variables 
	private String departmentCode;

	// Unique value
	@Column(name = "name")
	//Creates variables 
	private String name;

	//create constructors
	public Department() {
	}

	public Department(String departnemtCode, String name) {
		this.departmentCode = departnemtCode;
		this.name = name;
	}

	//create getters
	public String getDepartmentCode() {
		return departmentCode;
	}

	public String getName() {
		return name;
	}

	//create setters
	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public void setName(String name) {
		this.name = name;
	}

	//create tostring method
	@Override
	public String toString() {
		return "departmentCode: " + departmentCode + "\nname: " + name;
	}

}
