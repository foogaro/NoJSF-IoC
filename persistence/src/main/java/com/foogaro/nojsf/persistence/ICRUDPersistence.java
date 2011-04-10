package com.foogaro.nojsf.persistence;

import com.foogaro.nojsf.model.ABaseDTO;
import com.foogaro.nojsf.persistence.exception.PersistenceException;

public interface ICRUDPersistence <T extends ABaseDTO> extends IBasePersistence {

    public T create(T t) throws PersistenceException;
    public T read(String identifier) throws PersistenceException;
    public T update(T t) throws PersistenceException;
    public void delete(String identifier) throws PersistenceException;

}
