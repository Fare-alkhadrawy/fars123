package nl.hu.bep.aquariumbeheersysteem.security;


import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import nl.hu.bep.aquariumbeheersysteem.model.Eigenaar;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.security.Key;
import java.util.AbstractMap.SimpleEntry;
import java.util.Calendar;

@Path("/authentication")
public class AuthenticationResource {
    public final static Key key = MacProvider.generateKey();

    private String getToken(String voornaam , String role)throws JwtException{
        Calendar expiration = Calendar.getInstance();
        expiration.add(Calendar.MINUTE, 30);

        return Jwts.builder().setSubject(voornaam).setExpiration(expiration.getTime()).claim("role",role).signWith(SignatureAlgorithm.HS512, key).compact();
    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response authenticateUserBijPsw(@FormParam("user") String voornaam, @FormParam("pass") String password){
        try {
            String role = Eigenaar.validateLogin(voornaam, password);
            if(role==null)throw new IllegalArgumentException("no user found");
            String token = getToken(voornaam, role);

            SimpleEntry<String, String> JWT = new SimpleEntry<>("myJWT", token);
            return Response.ok(JWT).build();
        }catch (JwtException | IllegalArgumentException e){
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }
}
