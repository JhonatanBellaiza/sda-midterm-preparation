package edu.miu.sdamidetermprepartion.service.impl;

import edu.miu.sdamidetermprepartion.model.Department;
import edu.miu.sdamidetermprepartion.repository.DepartmentRepository;
import edu.miu.sdamidetermprepartion.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    @Override
    public Optional<Department> addNewDepartment(Department department) {
        return Optional.of(departmentRepository.save(department));
    }

    @Override
    public void updateDepartment(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public Optional<Department> findDepartmentByName(String name) {
        // You can log or handle the case when the department is not found, if necessary
        return departmentRepository.findDepartmentsByDepartmentName(name);
    }

    @Override
    public Optional<List<Department>> getAllSortedByName() {
        Comparator<Department> departmentComparatorName = Comparator.comparing(Department::getDepartmentName);
        List<Department> departmentList = departmentRepository.findAll();
        return Optional.of(departmentList.stream()
                .sorted(departmentComparatorName)
                .collect(Collectors.toList()));
    }
}
