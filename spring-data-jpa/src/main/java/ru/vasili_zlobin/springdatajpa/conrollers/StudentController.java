package ru.vasili_zlobin.springdatajpa.conrollers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.vasili_zlobin.springdatajpa.model.Student;
import ru.vasili_zlobin.springdatajpa.services.StudentService;

@RestController
@RequestMapping("/api_1.0/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService service;

    @GetMapping
    public Page<Student> getListStudents(@RequestParam(defaultValue = "1") Integer page) {
        if (page < 1) {
            page = 1;
        }
        return service.find(page);
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id) {
        return service.getStudentById(id);
    }

    @PostMapping
    public void addStudent(@RequestBody Student student) {
        service.updateStudent(student);
    }

    @PutMapping
    public void updateStudent(@RequestBody Student student) {
        service.updateStudent(student);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

}
