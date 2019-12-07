package esipe.fr.tpconcurrence.entities;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;


@ApiModel(description = "résumé d'un document")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-06T14:36:05.755Z")

public class DocumentSummary   {
  @JsonProperty("documentId")
  private String documentId = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("updated")
  private String updated = null;

  @JsonProperty("title")
  private String title = null;

  public DocumentSummary documentId(String documentId) {
    this.documentId = documentId;
    return this;
  }

  /**
   * identifiant du document
   * @return documentId
  **/
  @ApiModelProperty(value = "identifiant du document")


  public String getDocumentId() {
    return documentId;
  }

  public void setDocumentId(String documentId) {
    this.documentId = documentId;
  }

  public DocumentSummary created(String created) {
    this.created = created;
    return this;
  }

  /**
   * la date de création
   * @return created
  **/
  @ApiModelProperty(value = "la date de création")

  @Valid

  public String getCreated() {
    return created;
  }

  public void setCreated(String created) {
    this.created = created;
  }

  public DocumentSummary updated(String updated) {
    this.updated = updated;
    return this;
  }

  /**
   * date de la mise à jour
   * @return updated
  **/
  @ApiModelProperty(value = "date de la mise à jour")

  @Valid

  public String getUpdated() {
    return updated;
  }

  public void setUpdated(String updated) {
    this.updated = updated;
  }

  public DocumentSummary title(String title) {
    this.title = title;
    return this;
  }

  /**
   * titre du document
   * @return title
  **/
  @ApiModelProperty(value = "titre du document")


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DocumentSummary documentSummary = (DocumentSummary) o;
    return Objects.equals(this.documentId, documentSummary.documentId) &&
        Objects.equals(this.created, documentSummary.created) &&
        Objects.equals(this.updated, documentSummary.updated) &&
        Objects.equals(this.title, documentSummary.title);
  }

  @Override
  public int hashCode() {
    return Objects.hash(documentId, created, updated, title);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DocumentSummary {\n");
    
    sb.append("    documentId: ").append(toIndentedString(documentId)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
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

