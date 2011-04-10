package com.foogaro.nojsf.persistence.user;

import com.foogaro.nojsf.model.UserDTO;
import com.foogaro.nojsf.persistence.ICRUDPersistence;
import com.foogaro.nojsf.persistence.exception.PersistenceException;

import java.util.List;

public interface IUserPersistence extends ICRUDPersistence<UserDTO> {

    public List<UserDTO> findAll() throws PersistenceException;

}
