package in.application;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import in.mecw.entity.Student;
import in.mecw.entity.Teacher;
import in.ty.TeacherDao;

public class TeacherApplication {

    private TeacherDao teacherDao;

    public TeacherApplication(EntityManagerFactory emf) {
        teacherDao = new TeacherDao(emf);
    }

    // 1. Add multiple teachers
    public void addTeachers() {

        Teacher t1 = new Teacher();
        t1.setTeacherId(201);
        t1.setName("Ravi Sir");
        t1.setEmail("ravi@gmail.com");
        t1.setSpecialization("Java");

        Teacher t2 = new Teacher();
        t2.setTeacherId(202);
        t2.setName("Priya Mam");
        t2.setEmail("priya@gmail.com");
        t2.setSpecialization("Database");

        Teacher t3 = new Teacher();
        t3.setTeacherId(203);
        t3.setName("Kumar Sir");
        t3.setEmail("kumar@gmail.com");
        t3.setSpecialization("Python");

        Teacher t4 = new Teacher();
        t4.setTeacherId(204);
        t4.setName("Divya Mam");
        t4.setEmail("divya@gmail.com");
        t4.setSpecialization("Cloud Computing");

        System.out.println(teacherDao.addTeacher(t1));
        System.out.println(teacherDao.addTeacher(t2));
        System.out.println(teacherDao.addTeacher(t3));
        System.out.println(teacherDao.addTeacher(t4));
    }

    // 2. Update teacher
    public void updateTeacher() {

        Teacher teacher =
                teacherDao.findTeacherById(201);

        if (teacher != null) {

            teacher.setName("Ravi Kumar");
            teacher.setEmail("ravikumar@gmail.com");
            teacher.setSpecialization("Advanced Java");

            Teacher updated =
                    teacherDao.updateTeacher(teacher);

            System.out.println("Teacher Updated");

            System.out.println(
                    updated.getTeacherId() + " "
                    + updated.getName() + " "
                    + updated.getEmail() + " "
                    + updated.getSpecialization());

        } else {
            System.out.println("Teacher not found");
        }
    }

    // 3. Delete teacher
    public void deleteTeacher() {

        Teacher teacher =
                teacherDao.findTeacherById(204);

        if (teacher != null) {

            teacherDao.deleteTeacher(teacher);

            System.out.println("Teacher Deleted");

        } else {
            System.out.println("Teacher not found");
        }
    }

    // 4. Find teacher by ID
    public void findTeacherById() {

        Teacher teacher =
                teacherDao.findTeacherById(201);

        if (teacher != null) {

            System.out.println("Teacher ID: "
                    + teacher.getTeacherId());

            System.out.println("Name: "
                    + teacher.getName());

            System.out.println("Email: "
                    + teacher.getEmail());

            System.out.println("Specialization: "
                    + teacher.getSpecialization());

        } else {
            System.out.println("Teacher not found");
        }
    }

    // 5. Display all teachers
    public void displayAllTeachers() {

        List<Teacher> teachers =
                teacherDao.findAllTeachers();

        System.out.println("All Teachers:");

        for (Teacher teacher : teachers) {

            System.out.println(
                    teacher.getTeacherId() + " "
                    + teacher.getName() + " "
                    + teacher.getEmail() + " "
                    + teacher.getSpecialization());
        }
    }

    // 6. Find all students taught by a teacher
    public void findAllStudentsByTeacher() {

        List<Student> students =
                teacherDao.findAllStudentsByTeacher(201);

        System.out.println("Students taught by teacher:");

        for (Student student : students) {

            System.out.println(
                    student.getStudentId() + " "
                    + student.getName());
        }
    }
}