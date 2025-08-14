package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * PokemonSprite
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-08-14T18:27:36.393621428+02:00[Europe/Paris]")


public class PokemonSprite   {
  @JsonProperty("frontDefaultBig")
  private String frontDefaultBig = null;

  @JsonProperty("frontDefaultMedium")
  private String frontDefaultMedium = null;

  @JsonProperty("frontDefaultSmall")
  private String frontDefaultSmall = null;

  public PokemonSprite frontDefaultBig(String frontDefaultBig) {
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

  public PokemonSprite frontDefaultMedium(String frontDefaultMedium) {
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

  public PokemonSprite frontDefaultSmall(String frontDefaultSmall) {
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
    PokemonSprite pokemonSprite = (PokemonSprite) o;
    return Objects.equals(this.frontDefaultBig, pokemonSprite.frontDefaultBig) &&
        Objects.equals(this.frontDefaultMedium, pokemonSprite.frontDefaultMedium) &&
        Objects.equals(this.frontDefaultSmall, pokemonSprite.frontDefaultSmall);
  }

  @Override
  public int hashCode() {
    return Objects.hash(frontDefaultBig, frontDefaultMedium, frontDefaultSmall);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PokemonSprite {\n");
    
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
