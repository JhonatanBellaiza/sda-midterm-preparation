package edu.miu.sdamidetermprepartion.repository;

import edu.miu.sdamidetermprepartion.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
