package com.epam.library.service;

/**
 *
 */
public interface IService<T> {
    void showAll();
    void insert(T t);
    void delete(int id);
    void delete(T t);
    void showById(int id);
}
