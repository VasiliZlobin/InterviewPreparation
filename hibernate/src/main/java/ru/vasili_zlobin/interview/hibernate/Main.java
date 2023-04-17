package ru.vasili_zlobin.interview.hibernate;

import ru.vasili_zlobin.interview.hibernate.controllers.StudentDao;
import ru.vasili_zlobin.interview.hibernate.model.Student;

import java.util.List;
import java.util.Random;

public class Main {
    private static final Random random = new Random();
    private static final int MIN_ROWS = 1000;
    public static void main(String[] args) {
        StudentDao dao = new StudentDao();
        for (int i = dao.getCountRows(); i < MIN_ROWS; i++) {
            Student student = new Student();
            student.setName("Студент " + i);
            student.setMark(getRandomInt(5));
            dao.saveOrUpdate(student);
        }

        List<Student> list = dao.findAll();
        for (int i = 0; i < 10; i++) {
            Long id = list.get(getRandomInt(999)).getId();
            Student student = dao.findById(id);
            student.setMark(student.getMark() + 1);
            dao.saveOrUpdate(student);
            System.out.println(student);
        }

        for (int i = 0; i < 10; i++) {
            Long id = list.get(getRandomInt(999)).getId();
            dao.deleteById(id);
        }
    }

    private static int getRandomInt(int bound) {
        return random.nextInt(1, bound + 1);
    }
}
