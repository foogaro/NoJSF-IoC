package com.foogaro.nojsf.restler;

import com.foogaro.nojsf.business.ICRUDBusiness;
import com.foogaro.nojsf.business.exception.BusinessException;
import com.foogaro.nojsf.model.ABaseDTO;
import com.foogaro.nojsf.restler.exception.RestlerException;
import org.jboss.resteasy.annotations.Form;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;

public abstract class ACRUDRestler<T extends ABaseDTO> implements ICRUDRestler<T> {

    @Autowired
    protected ICRUDBusiness<T> crudBusiness;

    @POST
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response create(@Context HttpServletRequest request, @Context HttpServletResponse response, @Form T dto) throws RestlerException {
        Response res;

        try {
            T t = crudBusiness.create(dto);
            res = Response.created(getURI(request, t.getIdentifier())).build();
        } catch (BusinessException e) {
            res = Response.serverError().build();
        }

        return res;
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response read(@Context HttpServletRequest request, @Context HttpServletResponse response, @PathParam("id") String id) throws RestlerException {
        Response res;

        try {
            T t = crudBusiness.read(id);
            res = Response.ok(t).build();
        } catch (BusinessException e) {
            res = Response.serverError().build();
        }

        return res;
    }

    @PUT
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response update(@Context HttpServletRequest request, @Context HttpServletResponse response, @PathParam("id") String id, @Form T dto) throws RestlerException {
        Response res;

        try {
            T t = crudBusiness.update(dto);
            res = Response.ok(t).build();
        } catch (BusinessException e) {
            res = Response.serverError().build();
        }

        return res;
    }

    @DELETE
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response delete(@Context HttpServletRequest request, @Context HttpServletResponse response, @PathParam("id") String id) throws RestlerException {
        Response res;

        try {
            crudBusiness.delete(id);
            res = Response.ok().build();
        } catch (BusinessException e) {
            res = Response.serverError().build();
        }

        return res;
    }

    protected URI getURI(HttpServletRequest request, String id) throws RestlerException {
        URI uri;
        try {
            String scheme = request.getScheme();             // http
            String serverName = request.getServerName();     // hostname.com
            int serverPort = request.getServerPort();        // 80
            String contextPath = request.getContextPath();   // /mywebapp
            String servletPath = request.getServletPath();   // /servlet/MyServlet
            uri = new URI(scheme + "://" + serverName + ":" + serverPort + contextPath + servletPath + "/" + id);
        } catch (URISyntaxException e) {
            throw new RestlerException(e);
        }
        return uri;
    }

}
