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


@Path("/aquarium")
public class AquariumResource {





    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllAquarium ( ) {
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();

        for (Aquarium aquarium : Eigenaar.getMyEigenaar().getAquariums()) {
            JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
            jsonObjectBuilder.add("naam ", aquarium.getNaam());
            jsonObjectBuilder.add("breedte ", aquarium.getBreedte());
            jsonObjectBuilder.add("hoogte ", aquarium.getHoogte());
            jsonObjectBuilder.add("lengte ", aquarium.getLengte());
            jsonObjectBuilder.add("bodem ", aquarium.getBodemsoort());
            jsonObjectBuilder.add("water ", aquarium.getWatersoot());

            arrayBuilder.add(jsonObjectBuilder);
        }
        return arrayBuilder.build().toString();
    }

    @POST
    @Path("/put")
    @Produces(MediaType.APPLICATION_JSON)
    public Response creatAquarium(@FormParam("naam") String name, @FormParam("lengte") String lengte, @FormParam("breedte") String breedte,
                                 @FormParam("hoogte") String hoogte, @FormParam("bodemsoort") String bodemsoort, @FormParam("watersoort") String watersoort){

        Aquarium aquarium = Eigenaar.creatAquaium(name, Double.parseDouble(lengte), Double.parseDouble(breedte), Double.parseDouble(hoogte), bodemsoort, watersoort);
        if (aquarium == null)
            return Response.status(Response.Status.CONFLICT).entity(
                    new AbstractMap.SimpleEntry<String, String>("resultaat", "bewoner bestaat all")
            ).build();
        return Response.ok(aquarium).build();
    }


    @DELETE
    @Path("{aquariumName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteAquarium(@PathParam("aquariumName") String name){
    if(Eigenaar.removeAquarium(name))return Response.ok().build();
    return Response.status(Response.Status.NOT_FOUND).build();
    }
}
