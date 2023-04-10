package ru.vasili_zlobin.interview.lesson2;

public interface List<T> {
    void add(T value);
    T get(int index);
    int find(T value);
    void delete(int index);
    int count();
}
