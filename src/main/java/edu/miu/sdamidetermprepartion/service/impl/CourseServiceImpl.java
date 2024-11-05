package edu.miu.sdamidetermprepartion.service.impl;

import edu.miu.sdamidetermprepartion.model.Course;
import edu.miu.sdamidetermprepartion.repository.CourseRepository;
import edu.miu.sdamidetermprepartion.service.CourseService;
import edu.miu.sdamidetermprepartion.service.DepartmentService;
import edu.miu.sdamidetermprepartion.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final DepartmentService departmentService;

    @Override
    public Optional<Course> addNewCourse(Course course) {
        return Optional.of(courseRepository.save(course));
    }

    @Override
    public void updateCourse(Course course) {
        courseRepository.save(course);
    }

    @Override
    public Optional<List<Course>> getAllInComputerScienceOrderByName() {
        // Define the comparator for sorting courses by name
        Comparator<Course> courseComparatorByName = Comparator.comparing(Course::getCourseTitle);

        List<Course> courseList = departmentService.findDepartmentByName("Computer Science")
                .map(courseRepository::findAllByDepartment).get();

        // Retrieve the department and then find all courses in that department
        return Optional.of(courseList.stream()
                .sorted(courseComparatorByName)
                .collect(Collectors.toList()))  ;// Ensure we don't return an empty Optional
    }
}
