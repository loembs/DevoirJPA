package com.natsi.repositories.core;

import java.util.List;

public interface RepositoryD<T>{
    void insert(T data );
    List<T> selectAll();
}
