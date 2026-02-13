package uce.edu.web.api.app.interfaces;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

import uce.edu.web.api.app.application.VehiculoService;
import uce.edu.web.api.app.application.representation.VehiculoRepresentation;
import java.util.List;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/vehiculos")
public class VehiculoResource {
    
    @Inject
    VehiculoService service;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<VehiculoRepresentation> getAll() {
        return service.getAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void create(VehiculoRepresentation representation) {
        service.create(representation);
    }
}
