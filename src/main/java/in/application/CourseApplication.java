package in.application;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import in.mecw.entity.Course;
import in.mecw.entity.Department;
import in.mecw.entity.Student;
import in.ty.CourseDao;

public class CourseApplication {

    private CourseDao courseDao;

    public CourseApplication(EntityManagerFactory emf) {
        courseDao = new CourseDao(emf);
    }

    // 1. Add multiple courses to a department
    public void addCourses() {

        Department dept = new Department();
        dept.setDepartmentId(1);

        Course c1 = new Course();
        c1.setCourseId(1);
        c1.setCourseName("DataScience");
        c1.setDuration(4);
        c1.setDept(dept);

        Course c2 = new Course();
        c2.setCourseId(2);
        c2.setCourseName("AIML");
        c2.setDuration(4);
        c2.setDept(dept);

        Course c3 = new Course();
        c3.setCourseId(3);
        c3.setCourseName("CloudComputing");
        c3.setDuration(4);
        c3.setDept(dept);

        Course c4 = new Course();
        c4.setCourseId(4);
        c4.setCourseName("CyberSecurity");
        c4.setDuration(4);
        c4.setDept(dept);

        System.out.println(courseDao.addCourse(c1));
        System.out.println(courseDao.addCourse(c2));
        System.out.println(courseDao.addCourse(c3));
        System.out.println(courseDao.addCourse(c4));
    }

    // 2. Update course
    public void updateCourse() {

        Course course = courseDao.findCourseById(1);

        if (course != null) {

            course.setCourseName("Advanced DataScience");
            course.setDuration(5);

            Course updated = courseDao.updateCourse(course);

            System.out.println("Course Updated");

            System.out.println(
                    updated.getCourseId() + " "
                    + updated.getCourseName() + " "
                    + updated.getDuration());
        } else {
            System.out.println("Course not found");
        }
    }

    // 3. Delete course
    public void deleteCourse() {

        Course course = courseDao.findCourseById(4);

        if (course != null) {

            courseDao.deleteCourse(course);

            System.out.println("Course Deleted");

        } else {
            System.out.println("Course not found");
        }
    }

    // 4. Find course by ID
    public void findCourseById() {

        Course course = courseDao.findCourseById(1);

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

    // 5. Display all courses
    public void displayAllCourses() {

        List<Course> courses =
                courseDao.findAllCourse();

        System.out.println("All Courses:");

        for (Course course : courses) {

            System.out.println(
                    course.getCourseId() + " "
                    + course.getCourseName() + " "
                    + course.getDuration());
        }
    }

    // 6. Find course's department
    public void findCourseDepartment() {

        Department dept =
                courseDao.findCourseDepartment(1);

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

    // 7. Find all students in a course
    public void findAllStudentsInCourse() {

        List<Student> students =
                courseDao.findAllStudentsInCourse(1);

        System.out.println("Students in Course:");

        for (Student student : students) {

            System.out.println(
                    student.getStudentId() + " "
                    + student.getName());
        }
    }
}