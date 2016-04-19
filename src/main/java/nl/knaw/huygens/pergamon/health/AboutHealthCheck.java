package nl.knaw.huygens.pergamon.health;

import com.codahale.metrics.health.HealthCheck;

import nl.knaw.huygens.pergamon.resources.AboutResource;

public class AboutHealthCheck extends HealthCheck {
  @Override
  protected Result check() throws Exception {
    new AboutResource().get();
    return Result.healthy();
  }
}
