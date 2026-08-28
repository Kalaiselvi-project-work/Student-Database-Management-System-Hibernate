package in.ty;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import in.mecw.entity.Student;
import in.mecw.entity.Teacher;

public class StudentTeacherDao {

    private EntityManagerFactory emf;

    public StudentTeacherDao(EntityManagerFactory emf) {
        this.emf = emf;
    }

    // Assign one teacher to one student
    public void assignTeacherToStudent(int studentId, int teacherId) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();

        Student student = em.find(Student.class, studentId);
        Teacher teacher = em.find(Teacher.class, teacherId);

        if (student.getTeachers() == null) {
            student.setTeachers(new ArrayList<Teacher>());
        }

        student.getTeachers().add(teacher);

        et.commit();
    }

    // Assign multiple teachers to one student
    public void assignMultipleTeachersToStudent(
            int studentId, List<Integer> teacherIds) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();

        Student student = em.find(Student.class, studentId);

        if (student.getTeachers() == null) {
            student.setTeachers(new ArrayList<Teacher>());
        }

        for (int id : teacherIds) {
            Teacher teacher = em.find(Teacher.class, id);
            student.getTeachers().add(teacher);
        }

        et.commit();
    }

    // Assign multiple students to one teacher
    public void assignMultipleStudentsToTeacher(
            int teacherId, List<Integer> studentIds) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();

        Teacher teacher = em.find(Teacher.class, teacherId);

        for (int id : studentIds) {

            Student student = em.find(Student.class, id);

            if (student.getTeachers() == null) {
                student.setTeachers(new ArrayList<Teacher>());
            }

            student.getTeachers().add(teacher);
        }

        et.commit();
    }

    // Remove teacher from student
    public void removeTeacherFromStudent(
            int studentId, int teacherId) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();

        Student student = em.find(Student.class, studentId);
        Teacher teacher = em.find(Teacher.class, teacherId);

        student.getTeachers().remove(teacher);

        et.commit();
    }

    // Find all teachers of a student
    public List<Teacher> findAllTeachersOfStudent(int studentId) {

        EntityManager em = emf.createEntityManager();

        TypedQuery<Teacher> result = em.createQuery(
                "select t from Student s join s.teachers t " +
                "where s.studentId = :id",
                Teacher.class);

        result.setParameter("id", studentId);

        return result.getResultList();
    }

    // Find all students of a teacher
    public List<Student> findAllStudentsOfTeacher(int teacherId) {

        EntityManager em = emf.createEntityManager();

        TypedQuery<Student> result = em.createQuery(
                "select s from Student s join s.teachers t " +
                "where t.teacherId = :id",
                Student.class);

        result.setParameter("id", teacherId);

        return result.getResultList();
    }
}