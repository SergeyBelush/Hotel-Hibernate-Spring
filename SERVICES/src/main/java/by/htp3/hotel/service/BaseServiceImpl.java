package by.htp3.hotel.service;

import by.htp3.hotel.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@Service
@Transactional
public class BaseServiceImpl<T> implements BaseService<T> {

    @Autowired
    private BaseDao<T> baseDao;

    public BaseServiceImpl() {
    }

    @Override
    public void saveOrUpdate(T o) throws Exception {
    }

    @Override
    public T get(Class clazz, Serializable id) throws Exception {
        return null;
    }

    @Override
    public void delete(T o) throws Exception {
    }

    public BaseDao<T> getBaseDao() {

        return baseDao;
    }

    public void setBaseDao(BaseDao<T> baseDao) {
        this.baseDao = baseDao;
    }
}
