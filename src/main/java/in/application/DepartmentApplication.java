package in.application;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import in.mecw.entity.Course;
import in.mecw.entity.Department;
import in.ty.DepartmentDao;

public class DepartmentApplication {

    private DepartmentDao deptDao;

    public DepartmentApplication(EntityManagerFactory emf) {
        deptDao = new DepartmentDao(emf);
    }

    // 1. Add  departments
    public void addDepartments() {

        Department d1 = new Department();
        d1.setDepartmentId(1);
        d1.setDepartmentName("CSE");
        d1.setLocation("Salem");

        Department d2 = new Department();
        d2.setDepartmentId(2);
        d2.setDepartmentName("ECE");
        d2.setLocation("Chennai");

        Department d3 = new Department();
        d3.setDepartmentId(3);
        d3.setDepartmentName("IT");
        d3.setLocation("Coimbatore");

        Department d4 = new Department();
        d4.setDepartmentId(4);
        d4.setDepartmentName("MECH");
        d4.setLocation("Madurai");

        System.out.println(deptDao.addDepartment(d1));
        System.out.println(deptDao.addDepartment(d2));
        System.out.println(deptDao.addDepartment(d3));
        System.out.println(deptDao.addDepartment(d4));
    }

    // 2. Update department
    public void updateDepartment() {

        Department dept = deptDao.findDeptById(1);

        if (dept != null) {

            dept.setDepartmentName("Computer Science");
            dept.setLocation("Chennai");

            Department updated = deptDao.updateDept(dept);

            System.out.println("Department Updated");
            System.out.println(
                    updated.getDepartmentId() + " "
                    + updated.getDepartmentName() + " "
                    + updated.getLocation());
        } else {
            System.out.println("Department not found");
        }
    }

    // 3. Delete department
    public void deleteDepartment() {

        Department dept = deptDao.findDeptById(4);

        if (dept != null) {

            deptDao.deleteDept(dept);

            System.out.println("Department Deleted");

        } else {
            System.out.println("Department not found");
        }
    }

    // 4. Find department by ID
    public void findDepartmentById() {

        Department dept = deptDao.findDeptById(1);

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

    // 5. Display all departments
    public void displayAllDepartments() {

        List<Department> departments =
                deptDao.findAllDepartment();

        System.out.println("All Departments:");

        for (Department dept : departments) {

            System.out.println(
                    dept.getDepartmentId() + " "
                    + dept.getDepartmentName() + " "
                    + dept.getLocation());
        }
    }

    // 6. Find all courses in a department
    public void findAllCoursesInDepartment() {

        List<Course> courses =
                deptDao.findAllCourseInDept(1);

        System.out.println("Courses in Department:");

        for (Course course : courses) {

            System.out.println(
                    course.getCourseId() + " "
                    + course.getCourseName() + " "
                    + course.getDuration());
        }
    }
}