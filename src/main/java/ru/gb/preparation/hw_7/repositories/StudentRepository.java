package ru.gb.preparation.hw_7.repositories;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import ru.gb.preparation.hw_7.entities.Student;

@Repository
public interface StudentRepository extends ListCrudRepository<Student, Long> {
}
