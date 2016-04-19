package nl.knaw.huygens.pergamon.resources;

import java.util.Properties;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Metered;

import nl.knaw.huygens.pergamon.api.About;

@Path("/about")
public class AboutResource {
  private final Properties gitProperties;

  public AboutResource(Properties gitProperties) {
    this.gitProperties = gitProperties;
  }

  @GET
  @Metered
  @Produces(MediaType.APPLICATION_JSON)
  public About get() {
    return About.fromGitProperties(gitProperties);
  }

}
