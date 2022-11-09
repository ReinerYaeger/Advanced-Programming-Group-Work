package model.staff;

import model.Department;
import model.Staff;
import org.hibernate.annotations.Table;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

//Lineworker class inheriting from staff class
@Entity
@Table(appliesTo = "LineWorker")
public class LineWorker extends Staff implements Serializable {
	private static final long serialVersionUID = 4801957816410214976L;
	@ManyToOne
	@JoinColumn(name = "departmentCode")
	private Department department;

	public LineWorker(){
		super();
	}

	public Department getDepartment( ) {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
}
