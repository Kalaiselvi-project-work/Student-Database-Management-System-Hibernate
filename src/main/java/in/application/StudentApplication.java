package in.application;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import in.mecw.entity.Course;
import in.mecw.entity.Department;
import in.mecw.entity.Student;
import in.ty.StudentDao;

public class StudentApplication {

    private StudentDao studentDao;

    public StudentApplication(EntityManagerFactory emf) {
        studentDao = new StudentDao(emf);
    }

    // 1. Add student to a course
    public void addStudents() {

        Course course1 = new Course();
        course1.setCourseId(1);

        Course course2 = new Course();
        course2.setCourseId(2);

        Student s1 = new Student();
        s1.setStudentId(101);
        s1.setName("Arun");
        s1.setEmail("arun@gmail.com");
        s1.setPhone(9876543210L);
        s1.setAge(21);
        s1.setCourse(course1);

        Student s2 = new Student();
        s2.setStudentId(102);
        s2.setName("Kavin");
        s2.setEmail("kavin@gmail.com");
        s2.setPhone(9876543211L);
        s2.setAge(22);
        s2.setCourse(course1);

        Student s3 = new Student();
        s3.setStudentId(103);
        s3.setName("Priya");
        s3.setEmail("priya@gmail.com");
        s3.setPhone(9876543212L);
        s3.setAge(20);
        s3.setCourse(course2);

        Student s4 = new Student();
        s4.setStudentId(104);
        s4.setName("Divya");
        s4.setEmail("divya@gmail.com");
        s4.setPhone(9876543213L);
        s4.setAge(23);
        s4.setCourse(course2);

        System.out.println(studentDao.addStudent(s1));
        System.out.println(studentDao.addStudent(s2));
        System.out.println(studentDao.addStudent(s3));
        System.out.println(studentDao.addStudent(s4));
    }

    // 2. Update student
    public void updateStudent() {

        Student student = studentDao.findStudentById(101);

        if (student != null) {

            student.setName("Arun Kumar");
            student.setEmail("arunkumar@gmail.com");
            student.setAge(22);

            Student updated =
                    studentDao.updateStudent(student);

            System.out.println("Student Updated");

            System.out.println(
                    updated.getStudentId() + " "
                    + updated.getName() + " "
                    + updated.getEmail() + " "
                    + updated.getAge());
        } else {
            System.out.println("Student not found");
        }
    }

    // 3. Delete student
    public void deleteStudent() {

        Student student =
                studentDao.findStudentById(104);

        if (student != null) {

            studentDao.deleteStudent(student);

            System.out.println("Student Deleted");

        } else {
            System.out.println("Student not found");
        }
    }

    // 4. Find student by ID
    public void findStudentById() {

        Student student =
                studentDao.findStudentById(101);

        if (student != null) {

            System.out.println("Student ID: "
                    + student.getStudentId());

            System.out.println("Name: "
                    + student.getName());

            System.out.println("Email: "
                    + student.getEmail());

            System.out.println("Phone: "
                    + student.getPhone());

            System.out.println("Age: "
                    + student.getAge());

        } else {
            System.out.println("Student not found");
        }
    }

    // 5. Display all students
    public void displayAllStudents() {

        List<Student> students =
                studentDao.findAllStudents();

        System.out.println("All Students:");

        for (Student student : students) {

            System.out.println(
                    student.getStudentId() + " "
                    + student.getName() + " "
                    + student.getEmail() + " "
                    + student.getAge());
        }
    }

    // 6. Find student's course
    public void findStudentCourse() {

        Course course =
                studentDao.findStudentCourse(101);

        if (course != null) {

            System.out.println("Course ID: "
                    + course.getCourseId());

            System.out.println("Course Name: "
                    + course.getCourseName());

            System.out.println("Duration: "
                    + course.getDuration());

        } else {
            System.out.println("Course not found");
        }
    }

    // 7. Find student's department
    public void findStudentDepartment() {

        Department dept =
                studentDao.findStudentDepartment(101);

        if (dept != null) {

            System.out.println("Department ID: "
                    + dept.getDepartmentId());

            System.out.println("Department Name: "
                    + dept.getDepartmentName());

            System.out.println("Location: "
                    + dept.getLocation());

        } else {
            System.out.println("Department not found");
        }
    }
}