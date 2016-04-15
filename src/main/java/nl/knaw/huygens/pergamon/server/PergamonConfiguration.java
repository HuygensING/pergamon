package nl.knaw.huygens.pergamon.server;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

public class PergamonConfiguration extends Configuration {
  @NotEmpty
  private String name;

  @JsonProperty
  public String getName() {
    return name;
  }

  @JsonProperty
  public void setName(String name) {
    this.name = name;
  }
}
