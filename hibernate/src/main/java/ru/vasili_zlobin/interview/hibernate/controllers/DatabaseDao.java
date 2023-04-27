package ru.vasili_zlobin.interview.hibernate.controllers;

import java.util.List;

public interface DatabaseDao<T, I> {
    void saveOrUpdate(T entity);
    List<T> findAll();
    T findById(I id);
    void deleteById(I id);
    Integer getCountRows();
}
