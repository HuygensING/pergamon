package nl.knaw.huygens.pergamon.resources;

import java.util.Properties;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import io.dropwizard.testing.junit.ResourceTestRule;

import nl.knaw.huygens.pergamon.api.About;

@RunWith(MockitoJUnitRunner.class)
public class AboutResourceTest {
  private static final Properties GIT = new Properties() {
    {
      setProperty("git.commit.id", "someId");
      setProperty("git.commit.time", "someTime");
      setProperty("git.branch", "someBranch");
    }
  };

  @ClassRule
  public static final ResourceTestRule resources //
      = ResourceTestRule.builder().addResource(new AboutResource(GIT)).build();

  @Test
  public void getsReturnGitProperties() throws Exception {
    final About response = resources.client().target("/about")//
                                       .request()//
                                       .get(About.class);

//    assertThat(response.getCommitId()).isEqualTo("someId");
  }

}
