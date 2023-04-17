package ru.vasili_zlobin.interview.hibernate.controllers;

import jakarta.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import ru.vasili_zlobin.interview.hibernate.model.Student;

import java.util.List;

public class StudentDao implements DatabaseDao<Student, Long> {
    private static Session getSession() {
        return ConnectFactory.getSession();
    }
    @Override
    public void saveOrUpdate(Student student) {
        Session session = getSession();
        session.beginTransaction();
        if (student.getId() == null) {
            session.persist(student);
        } else {
            session.merge(student);
        }
        session.getTransaction().commit();
    }
    @Override
    public List<Student> findAll() {
        Session session = getSession();
        session.beginTransaction();
        List<Student> result = session.createQuery("FROM Student", Student.class).getResultList();
        session.getTransaction().commit();
        return result;
    }
    @Override
    public Student findById(Long id) {
        Session session = getSession();
        session.beginTransaction();
        Student result = session.get(Student.class, id);
        session.getTransaction().commit();
        return result;
    }
    @Override
    public void deleteById(Long id) {
        Session session = getSession();
        session.beginTransaction();
        session.createQuery("DELETE FROM Student WHERE id = :id", null)
                .setParameter("id", id).executeUpdate();
        session.getTransaction().commit();
    }
    @Override
    public Integer getCountRows() {
        Session session = ConnectFactory.getSession();
        session.beginTransaction();
        String sql = "SELECT COUNT(*) FROM student";
        NativeQuery<Integer> query = session.createNativeQuery(sql, Integer.class);
        Integer result;
        try {
            result = query.getSingleResult();
        } catch (NoResultException e) {
            result = 0;
        }
        session.getTransaction().commit();
        return result;
    }
}
