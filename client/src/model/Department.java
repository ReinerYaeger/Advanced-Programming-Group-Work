package model;

import java.io.Serializable;

public class Department implements Serializable {

	private static final long serialVersionUID = 4801957816410214976L;

	// primary key

	private String departmentCode;

	// Unique value

	private String name;

	public Department() {
	}

	public Department(String departnemtCode, String name) {
		this.departmentCode = departnemtCode;
		this.name = name;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public String getName() {
		return name;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "departmentCode: " + departmentCode + "\nname: " + name;
	}

}
