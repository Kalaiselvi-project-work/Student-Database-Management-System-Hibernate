package in.ty;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import in.mecw.entity.Course;
import in.mecw.entity.Department;
import in.mecw.entity.Student;

public class CourseDao {
	
	private EntityManagerFactory emf;
	
	public CourseDao(EntityManagerFactory emf)
	{
		this.emf=emf;
		
	}
	
	  // Add course
    public String addCourse(Course course) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(course);
        et.commit();

        return "Course inserted";
    }
	//update course
	
	public Course updateCourse(Course course)
	{
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		course=em.merge(course);
		et.commit();
		return course;
	}
	
	//delete course
	public void deleteCourse(Course course)
	{ 
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.merge(course);
		em.remove(course);
		et.commit();
	}
	
	//Find Course by id
	
	public Course findCourseById(int id)
	{
		EntityManager em=emf.createEntityManager();
		return em.find(Course.class, id);
	}
	//display all courses
	
	public List<Course>findAllCourse()
	{
	
	EntityManager em=emf.createEntityManager();
	TypedQuery<Course> result=em.createQuery("select c from Course c",Course.class);
	return  result.getResultList();
	}
	
	//Find Course's Department 
	public Department findCourseDepartment(int courseId)
	{
	    EntityManager em = emf.createEntityManager();

	    TypedQuery<Department> result = em.createQuery("select c.dept from Course c where c.courseId=:id", Department.class );
        result.setParameter("id", courseId);
        return result.getSingleResult();
	}
	//Find Students in Course
	public List<Student> findAllStudentsInCourse(int courseId)
	{
	    EntityManager em = emf.createEntityManager();

	    TypedQuery<Student> result = em.createQuery("select s from Student s where s.course.courseId=:id", Student.class);
	    result.setParameter("id", courseId);
        return result.getResultList();
	}
}

