package edu.miu.sdamidetermprepartion;

import edu.miu.sdamidetermprepartion.model.Course;
import edu.miu.sdamidetermprepartion.model.Department;
import edu.miu.sdamidetermprepartion.model.Professor;
import edu.miu.sdamidetermprepartion.service.CourseService;
import edu.miu.sdamidetermprepartion.service.DepartmentService;
import edu.miu.sdamidetermprepartion.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class SdaMidetermPrepartionApplication {

    private final ProfessorService professorService;
    private final DepartmentService departmentService;
    private final CourseService courseService;

    public static void main(String[] args) {
        SpringApplication.run(SdaMidetermPrepartionApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {

            // Create and Save Departments
            Department dp1 = new Department("Computer Science");
            Department dp2 = new Department("Mathematics");
            Department dp3 = new Department("Physics");

            departmentService.addNewDepartment(dp1);
            departmentService.addNewDepartment(dp2);
            departmentService.addNewDepartment(dp3);

            // Create Professors (assign departments after saving departments)
            Professor p1 = new Professor("Alice", "Smith");
            Professor p2 = new Professor("John", "Doe");
            Professor p3 = new Professor("Emma", "Johnson");
            Professor p4 = new Professor("Daniel", "Lee");

            p1.setDepartment(dp1);
            p2.setDepartment(dp2);
            p3.setDepartment(dp3);
            p4.setDepartment(dp1);

            // Save Professors
            professorService.addNewProfessor(p1);
            professorService.addNewProfessor(p2);
            professorService.addNewProfessor(p3);
            professorService.addNewProfessor(p4);

            // Create Courses and assign them to departments
            Course c1 = new Course("Data Structures");
            Course c2 = new Course("Algorithms");
            Course c3 = new Course("Operative Systems");
            Course c4 = new Course("Calculus");
            Course c5 = new Course("Linear Algebra");
            Course c6 = new Course("Mechanics");
            Course c7 = new Course("Quantum Physics");

            // Set department for each course to synchronize bidirectional relationship
            c1.setDepartment(dp1);
            c2.setDepartment(dp1);
            c3.setDepartment(dp1);
            c4.setDepartment(dp2);
            c5.setDepartment(dp2);
            c6.setDepartment(dp3);
            c7.setDepartment(dp3);

            // Save Courses
            courseService.addNewCourse(c1);
            courseService.addNewCourse(c2);
            courseService.addNewCourse(c3);
            courseService.addNewCourse(c4);
            courseService.addNewCourse(c5);
            courseService.addNewCourse(c6);
            courseService.addNewCourse(c7);

            // Update department with courses
            dp1.setCourses(List.of(c1, c2, c3));
            dp2.setCourses(List.of(c4, c5));
            dp3.setCourses(List.of(c6, c7));

            departmentService.updateDepartment(dp1);
            departmentService.updateDepartment(dp2);
            departmentService.updateDepartment(dp3);

            // Set up course-professor relationships and save
            c1.setProfessors(List.of(p1, p4));
            c2.setProfessors(List.of(p1));
            c3.setProfessors(List.of(p4));
            c4.setProfessors(List.of(p2));
            c5.setProfessors(List.of(p2));
            c6.setProfessors(List.of(p3));
            c7.setProfessors(List.of(p3));

            courseService.updateCourse(c1);
            courseService.updateCourse(c2);
            courseService.updateCourse(c3);
            courseService.updateCourse(c4);
            courseService.updateCourse(c5);
            courseService.updateCourse(c6);
            courseService.updateCourse(c7);


            professorService.getAllSortedByLastName().get().forEach(System.out::println);

            courseService.getAllInComputerScienceOrderByName().get().forEach(System.out::println);
            departmentService.getAllSortedByName().get().forEach(System.out::println);
        };
    }

}
