package nl.hu.bep.aquariumbeheersysteem.security;

import nl.hu.bep.aquariumbeheersysteem.model.Eigenaar;

import javax.ws.rs.core.SecurityContext;
import java.security.Principal;

public class MySecurityContex implements SecurityContext {
    private Eigenaar username;
    private String scheme;

    public MySecurityContex(Eigenaar user, String scheme){
        this.username = user;
        this.scheme = scheme;
    }
    @Override
    public Principal getUserPrincipal ( ) {
        return this.username;
    }

    @Override
    public boolean isUserInRole (String role) {
        if(username.getRole() != null){
            return role.equals(username.getRole());
        }
        return false;
    }

    @Override
    public boolean isSecure ( ) {
        return "https".equals(this.scheme);
    }

    @Override
    public String getAuthenticationScheme ( ) {
        return SecurityContext.BASIC_AUTH;
    }
}
