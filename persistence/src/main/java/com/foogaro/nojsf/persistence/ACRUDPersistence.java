package com.foogaro.nojsf.persistence;

import com.foogaro.nojsf.model.ABaseDTO;
import com.foogaro.nojsf.persistence.exception.PersistenceException;

public abstract class ACRUDPersistence <T extends ABaseDTO> implements ICRUDPersistence<T> {

    public T create(T t) throws PersistenceException {
        return null;
    }

    public T read(String identifier) throws PersistenceException {
        return null;
    }

    public T update(T t) throws PersistenceException {
        return null;
    }

    public void delete(String identifier) throws PersistenceException {
    }
}
