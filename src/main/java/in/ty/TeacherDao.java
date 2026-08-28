package in.ty;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import in.mecw.entity.Student;
import in.mecw.entity.Teacher;

public class TeacherDao {

    private EntityManagerFactory emf;

    public TeacherDao(EntityManagerFactory emf) {
        this.emf = emf;
    }

    // Add teacher
    public String addTeacher(Teacher teacher) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(teacher);
        et.commit();

        return "Teacher inserted";
    }

    // Update teacher
    public Teacher updateTeacher(Teacher teacher) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        teacher = em.merge(teacher);
        et.commit();

        return teacher;
    }

    // Delete teacher
    public void deleteTeacher(Teacher teacher) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();

        teacher = em.merge(teacher);
        em.remove(teacher);

        et.commit();
    }

    // Find teacher by ID
    public Teacher findTeacherById(int id) {

        EntityManager em = emf.createEntityManager();

        return em.find(Teacher.class, id);
    }

    // Display all teachers
    public List<Teacher> findAllTeachers() {

        EntityManager em = emf.createEntityManager();

        TypedQuery<Teacher> result =
                em.createQuery("select t from Teacher t", Teacher.class);

        return result.getResultList();
    }

    // Find all students taught by a teacher
    public List<Student> findAllStudentsByTeacher(int teacherId) {

        EntityManager em = emf.createEntityManager();

        TypedQuery<Student> result = em.createQuery(
                "select s from Student s join s.teachers t where t.teacherId = :id",
                Student.class);

        result.setParameter("id", teacherId);

        return result.getResultList();
    }
}