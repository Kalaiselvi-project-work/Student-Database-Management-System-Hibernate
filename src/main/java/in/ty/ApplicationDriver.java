package in.ty;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import in.application.DepartmentApplication;
import in.application.StudentApplication;
import in.application.StudentTeacherApplication;
import in.application.TeacherApplication;
import in.application.AddressApplication;
import in.application.CourseApplication;

public class ApplicationDriver {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("dev");

        DepartmentApplication deptApp =
                new DepartmentApplication(emf);

        CourseApplication courseApp =
                new CourseApplication(emf);
        
        StudentApplication studentApp =
                new StudentApplication(emf);
        
        AddressApplication addressApp =
                new AddressApplication(emf);
        

        TeacherApplication teacherApp =
                new TeacherApplication(emf);
        
        StudentTeacherApplication studentTeacherApp =
                new StudentTeacherApplication(emf);


       //  Department operation execution
        
        
//         deptApp.addDepartments();
//         deptApp.updateDepartment();
//         deptApp.findDepartmentById();
//         deptApp.displayAllDepartments();
//         deptApp.findAllCoursesInDepartment();
         
         

        // course operation execution
        
        
//          courseApp.addCourses();
//         courseApp.displayAllCourses();
//         courseApp.findCourseById();
//         courseApp.updateCourse();
//         courseApp.findCourseDepartment();
//         courseApp.findAllStudentsInCourse();
           
           //Student operation execution
        
        
//             studentApp.addStudents();
//             studentApp.displayAllStudents();
//             studentApp.findStudentById();
//             studentApp.findStudentCourse();
//             studentApp.findStudentDepartment();
//             studentApp.updateStudent();
             
         
             // Execute Address operation
        
        
//             addressApp.addAddresses();
//             addressApp.updateAddress();
//             addressApp.deleteAddress();
//             addressApp.findAddressByStudent();
            
             
        
        // Execute Teacher operation
        
//             teacherApp.addTeachers();
//             teacherApp.displayAllTeachers();
//             teacherApp.findTeacherById();
//             teacherApp.updateTeacher();
//             teacherApp.deleteTeacher();
//             teacherApp.findAllStudentsByTeacher();
//             teacherApp.addTeachers();

             // Execute Student to Teacher operation
        
        
//            studentTeacherApp.assignTeacherToStudent();
//             studentTeacherApp.assignMultipleTeachersToStudent();
//             studentTeacherApp.assignMultipleStudentsToTeacher();
//             studentTeacherApp.removeTeacherFromStudent();
//             studentTeacherApp.findAllTeachersByStudent();
//             studentTeacherApp.findAllStudentsByTeacher();
//             
             
             
        emf.close();
    }
}