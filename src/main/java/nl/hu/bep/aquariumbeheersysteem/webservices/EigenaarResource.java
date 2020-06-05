package nl.hu.bep.aquariumbeheersysteem.webservices;

import nl.hu.bep.aquariumbeheersysteem.model.Aquarium;
import nl.hu.bep.aquariumbeheersysteem.model.Bewoner;
import nl.hu.bep.aquariumbeheersysteem.model.Eigenaar;

import javax.annotation.security.RolesAllowed;
import javax.json.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.StringReader;
import java.util.AbstractMap;
import java.util.List;


@Path("/eigenaar")
public class EigenaarResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Eigenaar> getAlle(){
        return Eigenaar.getEigenaars();
    }

    @DELETE
    @RolesAllowed("admin")
    @Path("{eigenaarnaam}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteEigenaar(@PathParam("eigenaarnaam") String name){
        if(Eigenaar.removeAquarium(name))return Response.ok().build();
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
