package com.example.taska.service;

public interface CRUDService<T> {
    void save(T entity);
    void deleteById(int id);

}
