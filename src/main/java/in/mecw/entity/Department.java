package in.mecw.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="department")  //we can change the table name by using this annotation
public class Department {
    @Id
    @Column(name="department_id")  //this annotation is used to change the column name in our db
	private int departmentId;
    @Column(name="department_name",unique=true,nullable=false)
	private String departmentName;
	private String location;
	
	@OneToMany (mappedBy = "dept", cascade = CascadeType.ALL) //mapped by attribute using foreign key //mentioning the relationship by using this based on our requirements
	private List<Course> courses; //this field is responsible for establish the course
	
	
	public List<Course> getCourse() {
		return courses;
	}
	public void setCourse(List<Course> course) {
		this.courses = course;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {  
		this.departmentName = departmentName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
}

