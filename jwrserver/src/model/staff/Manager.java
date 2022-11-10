package model.staff;

import model.Department;
import model.Staff;
import org.hibernate.annotations.Table;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
//Manager class inheriting from staff class

@Entity
@Table(appliesTo = "Manager")
public class Manager extends Staff implements Serializable {
	private static final long serialVersionUID = 4801957816410214976L;
	@ManyToOne
	@JoinColumn(name = "departmentCode")
	private Department department;

	public Manager(){
		super();
	}

	public Manager (Staff staff){
		super(staff);
	}

	public Department getDepartment( ) {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
}
