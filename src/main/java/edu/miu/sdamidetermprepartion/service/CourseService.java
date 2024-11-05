package edu.miu.sdamidetermprepartion.service;

import edu.miu.sdamidetermprepartion.model.Course;
import edu.miu.sdamidetermprepartion.model.Department;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    Optional<Course> addNewCourse(Course course);
    void updateCourse(Course course);

    Optional<List<Course>> getAllInComputerScienceOrderByName();

}
