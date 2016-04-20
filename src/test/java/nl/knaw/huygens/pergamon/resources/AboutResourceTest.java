package nl.knaw.huygens.pergamon.resources;

import static io.dropwizard.testing.ResourceHelpers.resourceFilePath;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Properties;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.MediaType;

import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import io.dropwizard.testing.junit.DropwizardAppRule;

import nl.knaw.huygens.pergamon.PergamonApplication;
import nl.knaw.huygens.pergamon.PergamonConfiguration;
import nl.knaw.huygens.pergamon.api.About;

public class AboutResourceTest {
  @ClassRule
  public static final DropwizardAppRule<PergamonConfiguration> RULE //
      = new DropwizardAppRule<>(PergamonApplication.class, resourceFilePath("test-config.yaml"));

  private static final String DUMMY_COMMIT_ID = "a82fc896adc0a49b41dcf85d646825edb8273498";
  private static final Properties GIT_PROPERTIES = mock(Properties.class);

  private Client client;

  @Before
  public void setup() {
    client = ClientBuilder.newClient();
  }

  @After
  public void tearDown() {
    client.close();
  }

  @Test
  public void getsReturnGitProperties() throws Exception {
    when(GIT_PROPERTIES.getProperty(anyString())).thenReturn(DUMMY_COMMIT_ID);

    final About response = request("/about").get(About.class);

    assertThat(response.getBranch()).isEqualTo("master");
  }

  private Builder request(String endpoint) {
    String uri = String.format("http://localhost:%d%s", RULE.getLocalPort(), endpoint);
    return client.target(uri).request().accept(MediaType.APPLICATION_JSON_TYPE);
  }

}
