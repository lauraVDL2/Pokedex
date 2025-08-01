package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Sprite
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-08-01T21:13:43.527214351+02:00[Europe/Paris]")


public class Sprite   {
  @JsonProperty("frontDefaultBig")
  private String frontDefaultBig = null;

  @JsonProperty("frontDefaultMedium")
  private String frontDefaultMedium = null;

  @JsonProperty("frontDefaultSmall")
  private String frontDefaultSmall = null;

  public Sprite frontDefaultBig(String frontDefaultBig) {
    this.frontDefaultBig = frontDefaultBig;
    return this;
  }

  /**
   * Get frontDefaultBig
   * @return frontDefaultBig
   **/
  @Schema(description = "")
  
    public String getFrontDefaultBig() {
    return frontDefaultBig;
  }

  public void setFrontDefaultBig(String frontDefaultBig) {
    this.frontDefaultBig = frontDefaultBig;
  }

  public Sprite frontDefaultMedium(String frontDefaultMedium) {
    this.frontDefaultMedium = frontDefaultMedium;
    return this;
  }

  /**
   * Get frontDefaultMedium
   * @return frontDefaultMedium
   **/
  @Schema(description = "")
  
    public String getFrontDefaultMedium() {
    return frontDefaultMedium;
  }

  public void setFrontDefaultMedium(String frontDefaultMedium) {
    this.frontDefaultMedium = frontDefaultMedium;
  }

  public Sprite frontDefaultSmall(String frontDefaultSmall) {
    this.frontDefaultSmall = frontDefaultSmall;
    return this;
  }

  /**
   * Get frontDefaultSmall
   * @return frontDefaultSmall
   **/
  @Schema(description = "")
  
    public String getFrontDefaultSmall() {
    return frontDefaultSmall;
  }

  public void setFrontDefaultSmall(String frontDefaultSmall) {
    this.frontDefaultSmall = frontDefaultSmall;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Sprite sprite = (Sprite) o;
    return Objects.equals(this.frontDefaultBig, sprite.frontDefaultBig) &&
        Objects.equals(this.frontDefaultMedium, sprite.frontDefaultMedium) &&
        Objects.equals(this.frontDefaultSmall, sprite.frontDefaultSmall);
  }

  @Override
  public int hashCode() {
    return Objects.hash(frontDefaultBig, frontDefaultMedium, frontDefaultSmall);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Sprite {\n");
    
    sb.append("    frontDefaultBig: ").append(toIndentedString(frontDefaultBig)).append("\n");
    sb.append("    frontDefaultMedium: ").append(toIndentedString(frontDefaultMedium)).append("\n");
    sb.append("    frontDefaultSmall: ").append(toIndentedString(frontDefaultSmall)).append("\n");
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
