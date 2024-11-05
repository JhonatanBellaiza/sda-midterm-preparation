package edu.miu.sdamidetermprepartion.service;

import edu.miu.sdamidetermprepartion.model.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {

    Optional<Department> addNewDepartment(Department department);
    void updateDepartment(Department department);
    Optional<Department> findDepartmentByName(String name);
    Optional<List<Department>> getAllSortedByName();

}
