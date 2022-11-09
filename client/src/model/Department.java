package model;

import java.io.Serializable;

public class Department implements Serializable {

	enum DepartmentType {
		INVENTORY,MANAGEMENT, ACCOUNTING;
	}

	private static final long serialVersionUID = 4801957816410214976L;
	//Creates variables 

	// primary key

	private String departmentCode;

	// Unique value

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
