package nl.knaw.huygens.pergamon.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/about")
public class AboutResource {
  @GET
  public Response get() {
    return Response.ok("about-info").build();
  }
}
