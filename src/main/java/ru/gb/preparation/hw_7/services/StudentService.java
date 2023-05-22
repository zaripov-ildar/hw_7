package ru.gb.preparation.hw_7.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.preparation.hw_7.converters.StudentConverter;
import ru.gb.preparation.hw_7.dtos.StudentDto;
import ru.gb.preparation.hw_7.entities.Student;
import ru.gb.preparation.hw_7.repositories.StudentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService implements iStudentService {
    private final StudentConverter converter;
    private final StudentRepository repository;

    public List<StudentDto> getStudents() {
        return repository.findAll()
                .stream()
                .map(converter::toDto)
                .toList();
    }

    @Transactional
    public void saveOrUpdate(StudentDto dto) {
        Student student;
        if (dto.id() != null) {
            student = repository.findById(dto.id()).orElse(new Student());
        } else {
            student = new Student();
        }
        student.setAge(dto.age());
        student.setName(dto.name());
        repository.save(converter.toEntity(dto));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
