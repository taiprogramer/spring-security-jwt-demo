package xyz.taiprogramer.springsecuritydemo.services;

import java.util.List;

public interface CRUDService<T> {
        List<T> listAll();

        T getById(Long id);

        T saveOrUpdate(T obj);

        void deleteById(Long id);
}
