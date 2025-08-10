package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * PokemonAbility
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-08-10T20:32:41.534145034+02:00[Europe/Paris]")


public class PokemonAbility   {
  @JsonProperty("first")
  private String first = null;

  @JsonProperty("second")
  private String second = null;

  @JsonProperty("hidden")
  private String hidden = null;

  public PokemonAbility first(String first) {
    this.first = first;
    return this;
  }

  /**
   * Get first
   * @return first
   **/
  @Schema(description = "")
  
    public String getFirst() {
    return first;
  }

  public void setFirst(String first) {
    this.first = first;
  }

  public PokemonAbility second(String second) {
    this.second = second;
    return this;
  }

  /**
   * Get second
   * @return second
   **/
  @Schema(description = "")
  
    public String getSecond() {
    return second;
  }

  public void setSecond(String second) {
    this.second = second;
  }

  public PokemonAbility hidden(String hidden) {
    this.hidden = hidden;
    return this;
  }

  /**
   * Get hidden
   * @return hidden
   **/
  @Schema(description = "")
  
    public String getHidden() {
    return hidden;
  }

  public void setHidden(String hidden) {
    this.hidden = hidden;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PokemonAbility pokemonAbility = (PokemonAbility) o;
    return Objects.equals(this.first, pokemonAbility.first) &&
        Objects.equals(this.second, pokemonAbility.second) &&
        Objects.equals(this.hidden, pokemonAbility.hidden);
  }

  @Override
  public int hashCode() {
    return Objects.hash(first, second, hidden);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PokemonAbility {\n");
    
    sb.append("    first: ").append(toIndentedString(first)).append("\n");
    sb.append("    second: ").append(toIndentedString(second)).append("\n");
    sb.append("    hidden: ").append(toIndentedString(hidden)).append("\n");
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
