package nl.knaw.huygens.pergamon;

import java.util.Properties;

import org.glassfish.jersey.filter.LoggingFilter;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.java8.Java8Bundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import nl.knaw.huygens.Log;
import nl.knaw.huygens.pergamon.health.AboutHealthCheck;
import nl.knaw.huygens.pergamon.resources.AboutResource;

public class PergamonApplication extends Application<PergamonConfiguration> {
  public static void main(String... args) throws Exception {
    new PergamonApplication().run(args);
  }

  @Override
  public String getName() {
    return "Pergamon";
  }

  @Override
  public void initialize(Bootstrap<PergamonConfiguration> bootstrap) {
    bootstrap.addBundle(new Java8Bundle());
    bootstrap.addBundle(new AssetsBundle());
  }

  @Override
  public void run(PergamonConfiguration pergamonConfiguration, Environment environment) throws Exception {
    Properties gitProperties = new Properties();
    gitProperties.load(getClass().getClassLoader().getResourceAsStream("git.properties"));
    final String version = gitProperties.getProperty("git.commit.id");
    Log.info("Launching Pergamon version: {}", version);

    Log.trace("config.name=[{}]", pergamonConfiguration.getName());

    environment.healthChecks().register("about", new AboutHealthCheck());

    environment.jersey().register(new AboutResource());
    environment.jersey().register(new LoggingFilter());
    environment.jersey().register(new JacksonJsonProvider());
  }
}
