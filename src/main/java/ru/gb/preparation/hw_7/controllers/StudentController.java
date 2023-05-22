package ru.gb.preparation.hw_7.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.preparation.hw_7.dtos.StudentDto;
import ru.gb.preparation.hw_7.services.iStudentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class StudentController {

    private final iStudentService studentService;

    @GetMapping
    public List<StudentDto> getStudentList(){
        return studentService.getStudents();
    }

    @PostMapping
    public void saveOrUpdate(@RequestBody StudentDto dto){
        studentService.saveOrUpdate(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        studentService.delete(id);
    }
}
