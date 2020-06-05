package nl.hu.bep.aquariumbeheersysteem.webservices;

import nl.hu.bep.aquariumbeheersysteem.model.Aquarium;
import nl.hu.bep.aquariumbeheersysteem.model.Bewoner;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.io.StringReader;
import java.util.AbstractMap;
import java.util.List;

@Path("/bewoner")
public class BewonerResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Bewoner> getAlle(){
        return Aquarium.getBewoners();
    }

    @POST
    @Path("put")
    @Produces(MediaType.APPLICATION_JSON)
    public Response creatBewoner(@FormParam("soort") String soort, @FormParam("fars") String fars, @FormParam("aantal") String aantal){

        Bewoner bewoner = Aquarium.creatBewoner(soort, fars, Integer.parseInt(aantal));
        if (bewoner == null)
            return Response.status(Response.Status.CONFLICT).entity(
                    new AbstractMap.SimpleEntry<String, String>("resultaat", "bewoner bestaat all")
            ).build();
        return Response.ok(bewoner).build();
    }
//        JsonObjectBuilder jsonObjectBuilder= Json.createObjectBuilder();
//
//        Bewoner bewoner = Bewoner.getNewBewoner();
//        try {
//            StringReader stringReader =new StringReader(myJson);
//            JsonReader jsonReader =Json.createReader(stringReader);
//            JsonObject jsonObject = jsonReader.readObject();
//
//            String soort = jsonObject.getString("soort");
//            String kluer = jsonObject.getString("kleur");
//            int aantal = Integer.parseInt(jsonObject.getString("aantal"));
//
//            bewoner.creatBewoner(soort,kluer,aantal);
//
//            jsonObjectBuilder.add("bricht", "bewoner toegevoegd");
//    } catch (Exception e) {
//            jsonObjectBuilder.add("bricht","erorr"+ e.getMessage() );
//        }
//        return jsonObjectBuilder.build().toString();
//    }


}
