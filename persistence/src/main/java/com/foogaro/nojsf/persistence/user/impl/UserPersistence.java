package com.foogaro.nojsf.persistence.user.impl;

import com.foogaro.nojsf.model.UserDTO;
import com.foogaro.nojsf.persistence.ACRUDPersistence;
import com.foogaro.nojsf.persistence.exception.PersistenceException;
import com.foogaro.nojsf.persistence.user.IUserPersistence;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserPersistence extends ACRUDPersistence<UserDTO> implements IUserPersistence {

    @Override
    public List<UserDTO> findAll() throws PersistenceException {
        List<UserDTO> userDTOList = new ArrayList<UserDTO>();
        UserDTO userDTO;

        userDTO = new UserDTO();userDTO.setFirstName("1-Luigi");userDTO.setLastName("Fugaro");userDTOList.add(userDTO);
        userDTO = new UserDTO();userDTO.setFirstName("2-Gigi");userDTO.setLastName("Foogaro");userDTOList.add(userDTO);
        userDTO = new UserDTO();userDTO.setFirstName("3-Gigio");userDTO.setLastName("Figaro");userDTOList.add(userDTO);
        userDTO = new UserDTO();userDTO.setFirstName("4-G");userDTO.setLastName("F");userDTOList.add(userDTO);

        return userDTOList;
    }
}
