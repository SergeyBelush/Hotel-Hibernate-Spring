package by.htp3.hotel.service;

import java.io.Serializable;

public interface BaseService<T> {

    void saveOrUpdate(T t) throws Exception;
    T get(Class clazz, Serializable id) throws Exception;
    void delete(T t) throws Exception;
    
}
