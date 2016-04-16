package nl.knaw.huygens.pergamon.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/about")
public class AboutResource {
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response get() {
    return Response.ok().entity(new AboutInfo("about")).build();
  }

  private class AboutInfo {
    private final String msg;

    AboutInfo(String msg) {
      this.msg = msg;
    }

    public String getMsg() {
      return msg;
    }
  }
}
