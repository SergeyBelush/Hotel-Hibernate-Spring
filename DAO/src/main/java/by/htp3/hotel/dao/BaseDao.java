package by.htp3.hotel.dao;


import java.io.Serializable;

public interface BaseDao<T> {

    void saveOrUpdate(T t) throws Exception;
    T get(Serializable id) throws Exception;
    void delete(T t) throws Exception;

}
