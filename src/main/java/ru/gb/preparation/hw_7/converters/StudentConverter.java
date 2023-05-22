package ru.gb.preparation.hw_7.converters;

import org.springframework.stereotype.Component;
import ru.gb.preparation.hw_7.dtos.StudentDto;
import ru.gb.preparation.hw_7.entities.Student;


@Component
public class StudentConverter {
    public Student toEntity(StudentDto dto) {
        return new Student(
                dto.id(),
                dto.name(),
                dto.age()
        );
    }

    public StudentDto toDto(Student student) {
        return new StudentDto(
                student.getId(),
                student.getName(),
                student.getAge()
        );
    }
}
