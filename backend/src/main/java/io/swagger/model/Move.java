package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.PokemonType;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Move
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-08-02T10:11:08.881295011+02:00[Europe/Paris]")


public class Move   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("type")
  private PokemonType type = null;

  @JsonProperty("wayToLearn")
  private String wayToLearn = null;

  public Move name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   **/
  @Schema(description = "")
  
    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Move type(PokemonType type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
   **/
  @Schema(description = "")
  
    @Valid
    public PokemonType getType() {
    return type;
  }

  public void setType(PokemonType type) {
    this.type = type;
  }

  public Move wayToLearn(String wayToLearn) {
    this.wayToLearn = wayToLearn;
    return this;
  }

  /**
   * Get wayToLearn
   * @return wayToLearn
   **/
  @Schema(description = "")
  
    public String getWayToLearn() {
    return wayToLearn;
  }

  public void setWayToLearn(String wayToLearn) {
    this.wayToLearn = wayToLearn;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Move move = (Move) o;
    return Objects.equals(this.name, move.name) &&
        Objects.equals(this.type, move.type) &&
        Objects.equals(this.wayToLearn, move.wayToLearn);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, type, wayToLearn);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Move {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    wayToLearn: ").append(toIndentedString(wayToLearn)).append("\n");
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
