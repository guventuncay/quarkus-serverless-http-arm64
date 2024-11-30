package dev.guvenx;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.SecurityContext;

@Path("/hello")
public class GreetingResource {

    @Context
    SecurityContext context;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        if (context.getUserPrincipal() == null) {
            return "hello anonymous";
        }
        return "hello %s".formatted(context.getUserPrincipal().getName());
    }
}
