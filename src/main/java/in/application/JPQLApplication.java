package in.application;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import in.mecw.entity.Course;
import in.mecw.entity.Student;
import in.mecw.entity.Teacher;

public class JPQLApplication {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("dev");

        EntityManager em = emf.createEntityManager();

        // 1. Find all students in BCA
        TypedQuery<Student> q1 = em.createQuery(
                "select s from Student s " +
                "where s.course.courseName = :courseName",
                Student.class);

        q1.setParameter("courseName", "BCA");

        List<Student> studentsBCA = q1.getResultList();

        System.out.println("1. Students in BCA:");

        for (Student s : studentsBCA) {
            System.out.println(s.getStudentId() + " " + s.getName());
        }


        // 2. Find all courses in Computer Science department
        TypedQuery<Course> q2 = em.createQuery(
                "select c from Course c " +
                "where c.dept.departmentName = :deptName",
                Course.class);

        q2.setParameter("deptName", "Computer Science");

        List<Course> csCourses = q2.getResultList();

        System.out.println("\n2. Courses in Computer Science:");

        for (Course c : csCourses) {
            System.out.println(c.getCourseId() + " " + c.getCourseName());
        }


        // 3. Find all teachers of Arun
        TypedQuery<Teacher> q3 = em.createQuery(
                "select t from Student s join s.teachers t " +
                "where s.name = :studentName",
                Teacher.class);

        q3.setParameter("studentName", "Arun");

        List<Teacher> arunTeachers = q3.getResultList();

        System.out.println("\n3. Teachers of Arun:");

        for (Teacher t : arunTeachers) {
            System.out.println(t.getTeacherId() + " " + t.getName());
        }


        // 4. Find all students taught by Ravi Sir
        TypedQuery<Student> q4 = em.createQuery(
                "select s from Student s join s.teachers t " +
                "where t.name = :teacherName",
                Student.class);

        q4.setParameter("teacherName", "Ravi Sir");

        List<Student> raviStudents = q4.getResultList();

        System.out.println("\n4. Students taught by Ravi Sir:");

        for (Student s : raviStudents) {
            System.out.println(s.getStudentId() + " " + s.getName());
        }


        // 5. Find students from a particular city
        TypedQuery<Student> q5 = em.createQuery(
                "select s from Student s " +
                "where s.address.city = :city",
                Student.class);

        q5.setParameter("city", "Salem");

        List<Student> cityStudents = q5.getResultList();

        System.out.println("\n5. Students from Salem:");

        for (Student s : cityStudents) {
            System.out.println(s.getStudentId() + " " + s.getName());
        }


        // 6. Count students in each course
        TypedQuery<Object[]> q6 = em.createQuery(
                "select s.course.courseName, count(s) " +
                "from Student s " +
                "group by s.course.courseName",
                Object[].class);

        List<Object[]> courseCount = q6.getResultList();

        System.out.println("\n6. Student count in each course:");

        for (Object[] row : courseCount) {
            System.out.println(row[0] + " : " + row[1]);
        }


        // 7. Count students taught by each teacher
        TypedQuery<Object[]> q7 = em.createQuery(
                "select t.name, count(s) " +
                "from Student s join s.teachers t " +
                "group by t.name",
                Object[].class);

        List<Object[]> teacherCount = q7.getResultList();

        System.out.println("\n7. Student count taught by each teacher:");

        for (Object[] row : teacherCount) {
            System.out.println(row[0] + " : " + row[1]);
        }


        // 8. Find students whose age is above 20
        TypedQuery<Student> q8 = em.createQuery(
                "select s from Student s " +
                "where s.age > :age",
                Student.class);

        q8.setParameter("age", 20);

        List<Student> above20 = q8.getResultList();

        System.out.println("\n8. Students whose age is above 20:");

        for (Student s : above20) {
            System.out.println(s.getStudentId() + " " + s.getName());
        }


        em.close();
        emf.close();
    }
}
