package ru.vasili_zlobin.springdatajpa.services;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vasili_zlobin.springdatajpa.model.Student;

@Service
@RequiredArgsConstructor
public class StudentService {
    private static final long MIN = 100L;
    private static final int PAGE_SIZE = 10;

    private final StudentRepository repository;

    @EventListener(ApplicationReadyEvent.class)
    public void fillDatabase() {
        Long count = MIN - repository.count();
        for (int i = 1; i <= count; i++) {
            Student student = new Student();
            student.setName("Студент " + i);
            student.setMark(4);
            repository.save(student);
        }
    }

    @Transactional(readOnly = true)
    public Page<Student> find(Integer page) {
        Specification<Student> specification = Specification.where(null);
        return repository.findAll(specification, PageRequest.of(page - 1, PAGE_SIZE));
    }

    @Transactional(readOnly = true)
    public Student getStudentById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Transactional
    public void updateStudent(Student student) {
        repository.save(student);
    }

    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
