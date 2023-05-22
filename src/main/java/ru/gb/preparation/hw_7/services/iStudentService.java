package ru.gb.preparation.hw_7.services;

import ru.gb.preparation.hw_7.dtos.StudentDto;

import java.util.List;

public interface iStudentService {

    List<StudentDto> getStudents();
    void saveOrUpdate(StudentDto dto);

    void delete(Long id);


}
