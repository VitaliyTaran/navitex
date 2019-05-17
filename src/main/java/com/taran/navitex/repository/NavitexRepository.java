package com.taran.navitex.repository;

import java.util.List;

public interface NavitexRepository<T> {
    T find(long id);

    List<T> findAll();

    void create(T t);

    void update(T t);

    void remove(T t);

    void remove(long id);
}
