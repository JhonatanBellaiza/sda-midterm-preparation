package edu.miu.sdamidetermprepartion.repository;

import edu.miu.sdamidetermprepartion.model.Course;
import edu.miu.sdamidetermprepartion.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findAllByDepartment(Department department);
}
