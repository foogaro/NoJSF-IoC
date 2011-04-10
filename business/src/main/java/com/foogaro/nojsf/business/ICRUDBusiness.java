package com.foogaro.nojsf.business;

import com.foogaro.nojsf.business.exception.BusinessException;
import com.foogaro.nojsf.model.ABaseDTO;

public interface ICRUDBusiness<T extends ABaseDTO> extends IBaseBusiness {

    public T create(T t) throws BusinessException;
    public T read(String identifier) throws BusinessException;
    public T update(T t) throws BusinessException;
    public void delete(String identifier) throws BusinessException;

}
