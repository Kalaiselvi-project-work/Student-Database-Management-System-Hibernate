package in.application;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import in.mecw.entity.Student;
import in.mecw.entity.Teacher;
import in.ty.StudentTeacherDao;

public class StudentTeacherApplication {

    private StudentTeacherDao studentTeacherDao;

    public StudentTeacherApplication(EntityManagerFactory emf) {
        studentTeacherDao = new StudentTeacherDao(emf);
    }

    // 1. Assign one teacher to one student
    public void assignTeacherToStudent() {

        studentTeacherDao.assignTeacherToStudent(101, 201);

        System.out.println("Teacher assigned to student");
    }

    // 2. Assign multiple teachers to one student
    public void assignMultipleTeachersToStudent() {

        studentTeacherDao.assignTeacherToStudent(101, 201);
        studentTeacherDao.assignTeacherToStudent(101, 202);
        studentTeacherDao.assignTeacherToStudent(101, 203);

        System.out.println("Multiple teachers assigned to student");
    }

    // 3. Assign multiple students to one teacher
    public void assignMultipleStudentsToTeacher() {

        studentTeacherDao.assignTeacherToStudent(101, 201);
        studentTeacherDao.assignTeacherToStudent(102, 201);
        studentTeacherDao.assignTeacherToStudent(103, 201);

        System.out.println("Multiple students assigned to teacher");
    }

    // 4. Remove teacher from student
    public void removeTeacherFromStudent() {

        studentTeacherDao.removeTeacherFromStudent(101, 201);

        System.out.println("Teacher removed from student");
    }

    // 5. Find all teachers of a student
    public void findAllTeachersByStudent() {

        List<Teacher> teachers =
                studentTeacherDao.findAllTeachersOfStudent(101);

        System.out.println("Teachers of Student:");

        for (Teacher teacher : teachers) {

            System.out.println(
                    teacher.getTeacherId() + " "
                    + teacher.getName());
        }
    }

    // 6. Find all students of a teacher
    public void findAllStudentsByTeacher() {

        List<Student> students =
                studentTeacherDao.findAllStudentsOfTeacher(201);

        System.out.println("Students of Teacher:");

        for (Student student : students) {

            System.out.println(
                    student.getStudentId() + " "
                    + student.getName());
        }
    }
}