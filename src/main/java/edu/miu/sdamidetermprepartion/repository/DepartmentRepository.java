package edu.miu.sdamidetermprepartion.repository;

import edu.miu.sdamidetermprepartion.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Optional<Department> findDepartmentsByDepartmentName(String name);
}
