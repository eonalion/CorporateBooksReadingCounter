package com.epam.library.service;

import com.epam.library.exception.ServiceException;

import java.util.List;

/**
 *
 */
public interface IService<T> {
    List<T> showAll() throws ServiceException;
    void insert(T t);
    void delete(int id);
    void delete(T t);
    void showById(int id);
}
