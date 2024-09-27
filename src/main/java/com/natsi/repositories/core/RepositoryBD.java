package com.natsi.repositories.core;

import java.util.List;

public interface RepositoryBD<T> {
    void insert(T object);
    boolean update(T object);
    boolean delete(int id);
    List<T> selectAll();
    T selectById(int id);
}
