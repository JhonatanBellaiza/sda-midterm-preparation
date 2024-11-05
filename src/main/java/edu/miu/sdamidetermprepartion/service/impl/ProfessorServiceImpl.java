package edu.miu.sdamidetermprepartion.service.impl;

import edu.miu.sdamidetermprepartion.model.Professor;
import edu.miu.sdamidetermprepartion.repository.ProfessorRepository;
import edu.miu.sdamidetermprepartion.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProfessorServiceImpl implements ProfessorService {

    private final ProfessorRepository professorRepository;

    @Override
    public Optional<Professor> addNewProfessor(Professor professor) {
        return Optional.of(professorRepository.save(professor));
    }

    @Override
    public void updateProfessor(Professor professor) {
        professorRepository.save(professor);
    }

    @Override
    public Optional<List<Professor>> getAllSortedByLastName() {

        Comparator<Professor> professorComparatorLastName = Comparator.comparing(Professor::getLastName);

        List<Professor> professorList = professorRepository.findAll();

        return Optional.of(professorList.stream()
                .sorted(professorComparatorLastName)
                .collect(Collectors.toList()));
    }


}
