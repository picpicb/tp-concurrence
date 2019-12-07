package esipe.fr.tpconcurrence.entities;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * un verrou
 */
@ApiModel(description = "un verrou")
@Validated

public class Lock   {
  @JsonProperty("owner")
  private String owner = null;

  @JsonProperty("created")
  private String created = null;

  public Lock owner(String owner) {
    this.owner = owner;
    return this;
  }

  /**
   * utilisateur propriétaire du verrou
   * @return owner
  **/
  @ApiModelProperty(value = "utilisateur propriétaire du verrou")


  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

  public Lock created(String created) {
    this.created = created;
    return this;
  }

  /**
   * date de la pose du verrou
   * @return created
  **/
  @ApiModelProperty(value = "date de la pose du verrou")

  @Valid

  public String getCreated() {
    return created;
  }

  public void setCreated(String created) {
    this.created = created;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Lock lock = (Lock) o;
    return Objects.equals(this.owner, lock.owner) &&
        Objects.equals(this.created, lock.created);
  }

  @Override
  public int hashCode() {
    return Objects.hash(owner, created);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Lock {\n");
    
    sb.append("    owner: ").append(toIndentedString(owner)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

