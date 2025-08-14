package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.model.PokemonType;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Move
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-08-14T20:34:58.722562253+02:00[Europe/Paris]")


public class Move   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("type")
  private PokemonType type = null;

  @JsonProperty("power")
  private Integer power = null;

  @JsonProperty("accuracy")
  private Integer accuracy = null;

  @JsonProperty("pp")
  private Integer pp = null;

  /**
   * Gets or Sets category
   */
  public enum CategoryEnum {
    NON_DAMAGING("NON_DAMAGING"),
    
    SPECIAL("SPECIAL"),
    
    PHYSICAL("PHYSICAL");

    private String value;

    CategoryEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static CategoryEnum fromValue(String text) {
      for (CategoryEnum b : CategoryEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("category")
  private CategoryEnum category = null;

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

  public Move description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
   **/
  @Schema(description = "")
  
    public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
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

  public Move power(Integer power) {
    this.power = power;
    return this;
  }

  /**
   * Get power
   * @return power
   **/
  @Schema(description = "")
  
    public Integer getPower() {
    return power;
  }

  public void setPower(Integer power) {
    this.power = power;
  }

  public Move accuracy(Integer accuracy) {
    this.accuracy = accuracy;
    return this;
  }

  /**
   * Get accuracy
   * @return accuracy
   **/
  @Schema(description = "")
  
    public Integer getAccuracy() {
    return accuracy;
  }

  public void setAccuracy(Integer accuracy) {
    this.accuracy = accuracy;
  }

  public Move pp(Integer pp) {
    this.pp = pp;
    return this;
  }

  /**
   * Get pp
   * @return pp
   **/
  @Schema(description = "")
  
    public Integer getPp() {
    return pp;
  }

  public void setPp(Integer pp) {
    this.pp = pp;
  }

  public Move category(CategoryEnum category) {
    this.category = category;
    return this;
  }

  /**
   * Get category
   * @return category
   **/
  @Schema(description = "")
  
    public CategoryEnum getCategory() {
    return category;
  }

  public void setCategory(CategoryEnum category) {
    this.category = category;
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
        Objects.equals(this.description, move.description) &&
        Objects.equals(this.type, move.type) &&
        Objects.equals(this.power, move.power) &&
        Objects.equals(this.accuracy, move.accuracy) &&
        Objects.equals(this.pp, move.pp) &&
        Objects.equals(this.category, move.category);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, type, power, accuracy, pp, category);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Move {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    power: ").append(toIndentedString(power)).append("\n");
    sb.append("    accuracy: ").append(toIndentedString(accuracy)).append("\n");
    sb.append("    pp: ").append(toIndentedString(pp)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
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
