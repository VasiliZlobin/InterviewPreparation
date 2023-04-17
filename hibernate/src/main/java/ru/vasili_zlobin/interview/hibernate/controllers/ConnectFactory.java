package ru.vasili_zlobin.interview.hibernate.controllers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.vasili_zlobin.interview.hibernate.model.Student;

public class ConnectFactory {
    private static final SessionFactory SESSION_FACTORY = new Configuration()
            .addAnnotatedClass(Student.class)
            .buildSessionFactory();
    public static Session getSession() {
        return SESSION_FACTORY.getCurrentSession();
    }
}
