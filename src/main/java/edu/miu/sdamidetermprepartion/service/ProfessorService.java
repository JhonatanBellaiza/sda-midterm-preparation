package edu.miu.sdamidetermprepartion.service;

import edu.miu.sdamidetermprepartion.model.Professor;

import java.util.List;
import java.util.Optional;

public interface ProfessorService {

    Optional<Professor> addNewProfessor(Professor professor);
    void updateProfessor(Professor professor);

    Optional<List<Professor>> getAllSortedByLastName();
}
