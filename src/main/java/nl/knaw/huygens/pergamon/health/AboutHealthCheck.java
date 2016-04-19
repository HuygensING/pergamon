package nl.knaw.huygens.pergamon.health;

import com.codahale.metrics.health.HealthCheck;

public class AboutHealthCheck extends HealthCheck {
  @Override
  protected Result check() throws Exception {
    return Result.healthy();
  }
}
