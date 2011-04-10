package com.foogaro.nojsf.business;

import com.foogaro.nojsf.business.exception.BusinessException;
import com.foogaro.nojsf.model.ABaseDTO;
import com.foogaro.nojsf.persistence.ICRUDPersistence;
import com.foogaro.nojsf.persistence.exception.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ACRUDBusiness<T extends ABaseDTO> implements ICRUDBusiness<T> {

    @Autowired
    protected ICRUDPersistence<T> crudPersistence;

    public T create(T t) throws BusinessException {
        try {
            return crudPersistence.create(t);
        } catch (PersistenceException e) {
            throw new BusinessException(e);
        }
    }

    public T read(String identifier) throws BusinessException {
        try {
            return crudPersistence.read(identifier);
        } catch (PersistenceException e) {
            throw new BusinessException(e);
        }
    }

    public T update(T t) throws BusinessException {
        try {
            return crudPersistence.update(t);
        } catch (PersistenceException e) {
            throw new BusinessException(e);
        }
    }

    public void delete(String identifier) throws BusinessException {
        try {
            crudPersistence.delete(identifier);
        } catch (PersistenceException e) {
            throw new BusinessException(e);
        }
    }
}
