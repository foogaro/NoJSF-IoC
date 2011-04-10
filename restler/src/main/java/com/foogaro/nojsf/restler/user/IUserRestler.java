package com.foogaro.nojsf.restler.user;

import com.foogaro.nojsf.model.UserDTO;
import com.foogaro.nojsf.restler.ICRUDRestler;
import com.foogaro.nojsf.restler.exception.RestlerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public interface IUserRestler extends ICRUDRestler<UserDTO> {

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response findAll(@Context HttpServletRequest request, @Context HttpServletResponse response) throws RestlerException;

}
