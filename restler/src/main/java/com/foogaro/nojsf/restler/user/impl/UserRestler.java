package com.foogaro.nojsf.restler.user.impl;

import com.foogaro.nojsf.business.exception.BusinessException;
import com.foogaro.nojsf.business.user.IUserBusiness;
import com.foogaro.nojsf.model.ResponseWrapper;
import com.foogaro.nojsf.model.UserDTO;
import com.foogaro.nojsf.restler.ACRUDRestler;
import com.foogaro.nojsf.restler.exception.RestlerException;
import com.foogaro.nojsf.restler.user.IUserRestler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.util.List;

@Provider
@Path("/users")
public class UserRestler extends ACRUDRestler<UserDTO> implements IUserRestler {

    private static final Logger logger = LoggerFactory.getLogger(UserRestler.class);
    
    @Autowired
    private IUserBusiness userBusiness;

    public Response findAll(@Context HttpServletRequest request, @Context HttpServletResponse response) throws RestlerException {
        Response res;

        List<UserDTO> userDTOList;
        try {
            userDTOList = userBusiness.findAll();
            logger.debug("userDTOList: " + userDTOList);
            ResponseWrapper responseWrapper = new ResponseWrapper();
            responseWrapper.setDataWrapper(userDTOList);
            res = Response.ok(responseWrapper).build();
        } catch (BusinessException e) {
            e.printStackTrace();
            res = Response.serverError().build();
            logger.debug("BusinessException: " + e);
        }

        return res;
    }

}
