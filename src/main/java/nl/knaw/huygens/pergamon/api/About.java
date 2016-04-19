package nl.knaw.huygens.pergamon.api;

import java.util.Properties;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class About {
  private final String commitId;
  private final String commitTime;
  private final String branch;

  @JsonCreator
  private About(@JsonProperty("commitId") String commitId, @JsonProperty("commitTime") String commitTime,
                @JsonProperty("branch") String branch) {
    this.commitId = commitId;
    this.commitTime = commitTime;
    this.branch = branch;
  }

  public static About fromGitProperties(Properties gitProperties) {
    return new About(gitProperties.getProperty("git.commit.id"), gitProperties
        .getProperty("git.commit.time"), gitProperties.getProperty("git.branch"));
  }

  @JsonProperty
  public String getCommitId() {
    return commitId;
  }

  @JsonProperty
  public String getCommitTime() {
    return commitTime;
  }

  @JsonProperty
  public String getBranch() {
    return branch;
  }
}
