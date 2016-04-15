package nl.knaw.huygens.pergamon.server;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import nl.knaw.huygens.Log;

public class Pergamon extends Application<PergamonConfiguration> {
  public static void main(String... args) throws Exception {
    new Pergamon().run(args);
  }

  @Override
  public String getName() {
    return "Pergamon";
  }

  @Override
  public void initialize(Bootstrap<PergamonConfiguration> bootstrap) {
  }

  @Override
  public void run(PergamonConfiguration pergamonConfiguration, Environment environment) throws Exception {
    Log.warn("Pergamon started: config.name=[{}]", pergamonConfiguration.getName());
  }
}
