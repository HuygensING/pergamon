package nl.knaw.huygens.pergamon.resources;

import static io.dropwizard.testing.junit.ResourceTestRule.builder;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Properties;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import io.dropwizard.testing.junit.ResourceTestRule;

import nl.knaw.huygens.pergamon.api.About;

@RunWith(MockitoJUnitRunner.class)
public class AboutResourceTest {
  private static final Properties GIT = mock(Properties.class);

  @ClassRule
  public static final ResourceTestRule resources = builder().addResource(new AboutResource(GIT)).build();

  @Test
  public void getsReturnGitProperties() throws Exception {
    final String dummyCommitId = "0xdeadbeef";
    when(GIT.getProperty("git.commit.id")).thenReturn(dummyCommitId);

    final About response = resources.client().target("/about")//
                                       .request()//
                                       .get(About.class);

    assertThat(response.getCommitId()).isEqualTo(dummyCommitId);
  }

}
