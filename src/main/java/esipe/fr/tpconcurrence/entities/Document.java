package esipe.fr.tpconcurrence.entities;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;


@ApiModel(description = "a document")
@Validated

public class Document extends DocumentSummary  {
  @JsonProperty("creator")
  private String creator = null;

  @JsonProperty("editor")
  private String editor = null;

  @JsonProperty("body")
  private String body = null;

  public Document creator(String creator) {
    this.creator = creator;
    return this;
  }

  /**
   * le nom du créateur du document
   * @return creator
  **/
  @ApiModelProperty(value = "le nom du créateur du document")


  public String getCreator() {
    return creator;
  }

  public void setCreator(String creator) {
    this.creator = creator;
  }

  public Document editor(String editor) {
    this.editor = editor;
    return this;
  }

  /**
   * le nom du dernier utilisateur qui l'a mis à jour
   * @return editor
  **/
  @ApiModelProperty(value = "le nom du dernier utilisateur qui l'a mis à jour")


  public String getEditor() {
    return editor;
  }

  public void setEditor(String editor) {
    this.editor = editor;
  }

  public Document body(String body) {
    this.body = body;
    return this;
  }

  /**
   * le texte du document
   * @return body
  **/
  @ApiModelProperty(value = "le texte du document")


  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Document document = (Document) o;
    return Objects.equals(this.creator, document.creator) &&
        Objects.equals(this.editor, document.editor) &&
        Objects.equals(this.body, document.body) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(creator, editor, body, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Document {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    creator: ").append(toIndentedString(creator)).append("\n");
    sb.append("    editor: ").append(toIndentedString(editor)).append("\n");
    sb.append("    body: ").append(toIndentedString(body)).append("\n");
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

