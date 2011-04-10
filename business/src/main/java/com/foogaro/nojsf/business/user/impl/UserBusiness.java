package com.foogaro.nojsf.business.user.impl;

import com.foogaro.nojsf.business.ACRUDBusiness;
import com.foogaro.nojsf.business.exception.BusinessException;
import com.foogaro.nojsf.business.user.IUserBusiness;
import com.foogaro.nojsf.model.UserDTO;
import com.foogaro.nojsf.persistence.exception.PersistenceException;
import com.foogaro.nojsf.persistence.user.IUserPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBusiness extends ACRUDBusiness<UserDTO> implements IUserBusiness {

    @Autowired
    private IUserPersistence userPersistence;

    @Override
    public List<UserDTO> findAll() throws BusinessException {
        try {
            return userPersistence.findAll();
        } catch (PersistenceException e) {
            throw new BusinessException(e);
        }
    }
}
