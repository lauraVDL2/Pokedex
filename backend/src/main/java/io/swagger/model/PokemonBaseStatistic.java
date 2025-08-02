package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * PokemonBaseStatistic
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-08-02T10:11:08.881295011+02:00[Europe/Paris]")


public class PokemonBaseStatistic   {
  @JsonProperty("hp")
  private Integer hp = null;

  @JsonProperty("attack")
  private Integer attack = null;

  @JsonProperty("defense")
  private Integer defense = null;

  @JsonProperty("specialAttack")
  private Integer specialAttack = null;

  @JsonProperty("specialDefense")
  private Integer specialDefense = null;

  @JsonProperty("speed")
  private Integer speed = null;

  public PokemonBaseStatistic hp(Integer hp) {
    this.hp = hp;
    return this;
  }

  /**
   * Get hp
   * @return hp
   **/
  @Schema(description = "")
  
    public Integer getHp() {
    return hp;
  }

  public void setHp(Integer hp) {
    this.hp = hp;
  }

  public PokemonBaseStatistic attack(Integer attack) {
    this.attack = attack;
    return this;
  }

  /**
   * Get attack
   * @return attack
   **/
  @Schema(description = "")
  
    public Integer getAttack() {
    return attack;
  }

  public void setAttack(Integer attack) {
    this.attack = attack;
  }

  public PokemonBaseStatistic defense(Integer defense) {
    this.defense = defense;
    return this;
  }

  /**
   * Get defense
   * @return defense
   **/
  @Schema(description = "")
  
    public Integer getDefense() {
    return defense;
  }

  public void setDefense(Integer defense) {
    this.defense = defense;
  }

  public PokemonBaseStatistic specialAttack(Integer specialAttack) {
    this.specialAttack = specialAttack;
    return this;
  }

  /**
   * Get specialAttack
   * @return specialAttack
   **/
  @Schema(description = "")
  
    public Integer getSpecialAttack() {
    return specialAttack;
  }

  public void setSpecialAttack(Integer specialAttack) {
    this.specialAttack = specialAttack;
  }

  public PokemonBaseStatistic specialDefense(Integer specialDefense) {
    this.specialDefense = specialDefense;
    return this;
  }

  /**
   * Get specialDefense
   * @return specialDefense
   **/
  @Schema(description = "")
  
    public Integer getSpecialDefense() {
    return specialDefense;
  }

  public void setSpecialDefense(Integer specialDefense) {
    this.specialDefense = specialDefense;
  }

  public PokemonBaseStatistic speed(Integer speed) {
    this.speed = speed;
    return this;
  }

  /**
   * Get speed
   * @return speed
   **/
  @Schema(description = "")
  
    public Integer getSpeed() {
    return speed;
  }

  public void setSpeed(Integer speed) {
    this.speed = speed;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PokemonBaseStatistic pokemonBaseStatistic = (PokemonBaseStatistic) o;
    return Objects.equals(this.hp, pokemonBaseStatistic.hp) &&
        Objects.equals(this.attack, pokemonBaseStatistic.attack) &&
        Objects.equals(this.defense, pokemonBaseStatistic.defense) &&
        Objects.equals(this.specialAttack, pokemonBaseStatistic.specialAttack) &&
        Objects.equals(this.specialDefense, pokemonBaseStatistic.specialDefense) &&
        Objects.equals(this.speed, pokemonBaseStatistic.speed);
  }

  @Override
  public int hashCode() {
    return Objects.hash(hp, attack, defense, specialAttack, specialDefense, speed);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PokemonBaseStatistic {\n");
    
    sb.append("    hp: ").append(toIndentedString(hp)).append("\n");
    sb.append("    attack: ").append(toIndentedString(attack)).append("\n");
    sb.append("    defense: ").append(toIndentedString(defense)).append("\n");
    sb.append("    specialAttack: ").append(toIndentedString(specialAttack)).append("\n");
    sb.append("    specialDefense: ").append(toIndentedString(specialDefense)).append("\n");
    sb.append("    speed: ").append(toIndentedString(speed)).append("\n");
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
