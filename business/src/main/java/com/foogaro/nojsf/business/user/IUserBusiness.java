package com.foogaro.nojsf.business.user;

import com.foogaro.nojsf.business.ICRUDBusiness;
import com.foogaro.nojsf.business.exception.BusinessException;
import com.foogaro.nojsf.model.UserDTO;

import java.util.List;

public interface IUserBusiness extends ICRUDBusiness<UserDTO> {

    public List<UserDTO> findAll() throws BusinessException;

}
