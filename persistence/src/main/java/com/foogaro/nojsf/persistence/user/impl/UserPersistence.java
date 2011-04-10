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

        userDTO = new UserDTO();userDTO.setFirstName("1-Luigi");userDTO.setFirstName("Fugaro");userDTO.setIdentifier("LUFOO");userDTOList.add(userDTO);
        userDTO = new UserDTO();userDTO.setFirstName("2-Gigi");userDTO.setFirstName("Foogaro");userDTO.setIdentifier("GIFOO");userDTOList.add(userDTO);
        userDTO = new UserDTO();userDTO.setFirstName("3-Gigio");userDTO.setFirstName("Figaro");userDTO.setIdentifier("GIFI");userDTOList.add(userDTO);
        userDTO = new UserDTO();userDTO.setFirstName("4-G");userDTO.setFirstName("F");userDTO.setIdentifier("GF");userDTOList.add(userDTO);

        return userDTOList;
    }
}
