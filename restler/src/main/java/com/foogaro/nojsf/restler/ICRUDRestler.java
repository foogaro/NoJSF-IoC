package com.foogaro.nojsf.restler;

import com.foogaro.nojsf.model.ABaseDTO;
import com.foogaro.nojsf.restler.exception.RestlerException;
import org.jboss.resteasy.annotations.Form;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

public interface ICRUDRestler<T extends ABaseDTO> extends IBaseRestler {

    public Response create(@Context HttpServletRequest request, @Context HttpServletResponse response, @Form T t) throws RestlerException;
    public Response read(@Context HttpServletRequest request, @Context HttpServletResponse response, @PathParam("id") String id) throws RestlerException;
    public Response update(@Context HttpServletRequest request, @Context HttpServletResponse response, @PathParam("id") String id, @Form T dto) throws RestlerException;
    public Response delete(@Context HttpServletRequest request, @Context HttpServletResponse response, @PathParam("id") String id) throws RestlerException;

}
