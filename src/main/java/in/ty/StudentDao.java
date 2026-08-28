package in.ty;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import in.mecw.entity.Address;
import in.mecw.entity.Course;
import in.mecw.entity.Department;
import in.mecw.entity.Student;

public class StudentDao {

    private EntityManagerFactory emf;

    public StudentDao(EntityManagerFactory emf) {
        this.emf = emf;
    }

    // Add student to a course
    public String addStudent(Student student) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(student);
        et.commit();

        return "Student inserted";
    }

    // Update student
    public Student updateStudent(Student student) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        student = em.merge(student);
        et.commit();

        return student;
    }

    // Delete student
    public void deleteStudent(Student student) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();

        student = em.merge(student);
        em.remove(student);

        et.commit();
    }

    // Find student by ID
    public Student findStudentById(int id) {

        EntityManager em = emf.createEntityManager();

        return em.find(Student.class, id);
    }

    // Display all students
    public List<Student> findAllStudents() {

        EntityManager em = emf.createEntityManager();

        TypedQuery<Student> result =
                em.createQuery("select s from Student s", Student.class);

        return result.getResultList();
    }

    // Find student's course
    public Course findStudentCourse(int studentId) {

        EntityManager em = emf.createEntityManager();

        TypedQuery<Course> result = em.createQuery(
                "select s.course from Student s where s.studentId = :id",
                Course.class);

        result.setParameter("id", studentId);

        return result.getSingleResult();
    }

    // Find student's department
    public Department findStudentDepartment(int studentId) {

        EntityManager em = emf.createEntityManager();

        TypedQuery<Department> result = em.createQuery(
                "select s.course.dept from Student s where s.studentId = :id",
                Department.class);

        result.setParameter("id", studentId);

        return result.getSingleResult();
    }

    // Find student's address
    public Address findStudentAddress(int studentId) {

        EntityManager em = emf.createEntityManager();

        TypedQuery<Address> result = em.createQuery(
                "select s.address from Student s where s.studentId = :id",
                Address.class);

        result.setParameter("id", studentId);

        return result.getSingleResult();
    }
}