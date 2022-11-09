package model.staff;

import model.Department;
import model.Staff;
import org.hibernate.annotations.Table;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
//Supervisor class inheriting from staff class

@Entity
@Table(appliesTo = "Supervisor")
public class Supervisor extends Staff implements Serializable {
	private static final long serialVersionUID = 4801957816410214976L;
	@ManyToOne
	@JoinColumn(name = "departmentCode")
	private Department department;

	public Supervisor(){
		super();
		department = new Department();
	}

	public Department getDepartment( ) {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
}