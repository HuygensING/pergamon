package nl.knaw.huygens.pergamon.server;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

import nl.knaw.huygens.Log;

public class Pergamon extends Application<PergamonConfiguration> {
  public static void main(String... args) throws Exception {
    new Pergamon().run(args);
  }

  @Override
  public void run(PergamonConfiguration pergamonConfiguration, Environment environment) throws Exception {
    Log.debug("Pergamon started");
  }
}
