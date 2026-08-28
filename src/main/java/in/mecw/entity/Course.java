package in.mecw.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Entity
public class Course {
	@Id
	private int courseId;
	private String courseName;
	private int duration;
	
	@ManyToOne
	private Department dept;
	
	@OneToMany(mappedBy="course")  //using mapped_By attribute for refering the foreign key inside the Student 
	private List<Student> students;
	
	public List<Student> getStudent() {
		return students;
	}
	public void setStudent(List<Student> student) {
		this.students = student;
	}
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public Course()
	{
		
	}
	public Course(int courseId, String courseName, int duration) {
		
		this.courseId = courseId;
		this.courseName = courseName;
		this.duration = duration;
		
	}
	
	
        
}
