package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.PokemonAbility;
import io.swagger.model.PokemonBaseStatistic;
import io.swagger.model.PokemonEvolutionStageEntry;
import io.swagger.model.PokemonSprite;
import io.swagger.model.PokemonType;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Pokemon
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-08-03T20:49:59.201271836+02:00[Europe/Paris]")


public class Pokemon   {
  @JsonProperty("entryNumber")
  private Integer entryNumber = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("height")
  private String height = null;

  @JsonProperty("weight")
  private String weight = null;

  @JsonProperty("sprites")
  @Valid
  private List<PokemonSprite> sprites = null;

  @JsonProperty("types")
  @Valid
  private List<PokemonType> types = null;

  @JsonProperty("ability")
  private PokemonAbility ability = null;

  @JsonProperty("baseStatistics")
  private PokemonBaseStatistic baseStatistics = null;

  @JsonProperty("evolutionStageEntry")
  private PokemonEvolutionStageEntry evolutionStageEntry = null;

  @JsonProperty("wayToEvolvedStage")
  private String wayToEvolvedStage = null;

  @JsonProperty("moves")
  @Valid
  private List<String> moves = null;

  public Pokemon entryNumber(Integer entryNumber) {
    this.entryNumber = entryNumber;
    return this;
  }

  /**
   * Get entryNumber
   * @return entryNumber
   **/
  @Schema(description = "")
  
    public Integer getEntryNumber() {
    return entryNumber;
  }

  public void setEntryNumber(Integer entryNumber) {
    this.entryNumber = entryNumber;
  }

  public Pokemon name(String name) {
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

  public Pokemon description(String description) {
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

  public Pokemon height(String height) {
    this.height = height;
    return this;
  }

  /**
   * Get height
   * @return height
   **/
  @Schema(description = "")
  
    public String getHeight() {
    return height;
  }

  public void setHeight(String height) {
    this.height = height;
  }

  public Pokemon weight(String weight) {
    this.weight = weight;
    return this;
  }

  /**
   * Get weight
   * @return weight
   **/
  @Schema(description = "")
  
    public String getWeight() {
    return weight;
  }

  public void setWeight(String weight) {
    this.weight = weight;
  }

  public Pokemon sprites(List<PokemonSprite> sprites) {
    this.sprites = sprites;
    return this;
  }

  public Pokemon addSpritesItem(PokemonSprite spritesItem) {
    if (this.sprites == null) {
      this.sprites = new ArrayList<PokemonSprite>();
    }
    this.sprites.add(spritesItem);
    return this;
  }

  /**
   * Get sprites
   * @return sprites
   **/
  @Schema(description = "")
      @Valid
    public List<PokemonSprite> getSprites() {
    return sprites;
  }

  public void setSprites(List<PokemonSprite> sprites) {
    this.sprites = sprites;
  }

  public Pokemon types(List<PokemonType> types) {
    this.types = types;
    return this;
  }

  public Pokemon addTypesItem(PokemonType typesItem) {
    if (this.types == null) {
      this.types = new ArrayList<PokemonType>();
    }
    this.types.add(typesItem);
    return this;
  }

  /**
   * Get types
   * @return types
   **/
  @Schema(description = "")
      @Valid
    public List<PokemonType> getTypes() {
    return types;
  }

  public void setTypes(List<PokemonType> types) {
    this.types = types;
  }

  public Pokemon ability(PokemonAbility ability) {
    this.ability = ability;
    return this;
  }

  /**
   * Get ability
   * @return ability
   **/
  @Schema(description = "")
  
    @Valid
    public PokemonAbility getAbility() {
    return ability;
  }

  public void setAbility(PokemonAbility ability) {
    this.ability = ability;
  }

  public Pokemon baseStatistics(PokemonBaseStatistic baseStatistics) {
    this.baseStatistics = baseStatistics;
    return this;
  }

  /**
   * Get baseStatistics
   * @return baseStatistics
   **/
  @Schema(description = "")
  
    @Valid
    public PokemonBaseStatistic getBaseStatistics() {
    return baseStatistics;
  }

  public void setBaseStatistics(PokemonBaseStatistic baseStatistics) {
    this.baseStatistics = baseStatistics;
  }

  public Pokemon evolutionStageEntry(PokemonEvolutionStageEntry evolutionStageEntry) {
    this.evolutionStageEntry = evolutionStageEntry;
    return this;
  }

  /**
   * Get evolutionStageEntry
   * @return evolutionStageEntry
   **/
  @Schema(description = "")
  
    @Valid
    public PokemonEvolutionStageEntry getEvolutionStageEntry() {
    return evolutionStageEntry;
  }

  public void setEvolutionStageEntry(PokemonEvolutionStageEntry evolutionStageEntry) {
    this.evolutionStageEntry = evolutionStageEntry;
  }

  public Pokemon wayToEvolvedStage(String wayToEvolvedStage) {
    this.wayToEvolvedStage = wayToEvolvedStage;
    return this;
  }

  /**
   * If the pokemon is in evolved form, what are the requirements to make it evolve to its present stage
   * @return wayToEvolvedStage
   **/
  @Schema(description = "If the pokemon is in evolved form, what are the requirements to make it evolve to its present stage")
  
    public String getWayToEvolvedStage() {
    return wayToEvolvedStage;
  }

  public void setWayToEvolvedStage(String wayToEvolvedStage) {
    this.wayToEvolvedStage = wayToEvolvedStage;
  }

  public Pokemon moves(List<String> moves) {
    this.moves = moves;
    return this;
  }

  public Pokemon addMovesItem(String movesItem) {
    if (this.moves == null) {
      this.moves = new ArrayList<String>();
    }
    this.moves.add(movesItem);
    return this;
  }

  /**
   * Get moves
   * @return moves
   **/
  @Schema(description = "")
  
    public List<String> getMoves() {
    return moves;
  }

  public void setMoves(List<String> moves) {
    this.moves = moves;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Pokemon pokemon = (Pokemon) o;
    return Objects.equals(this.entryNumber, pokemon.entryNumber) &&
        Objects.equals(this.name, pokemon.name) &&
        Objects.equals(this.description, pokemon.description) &&
        Objects.equals(this.height, pokemon.height) &&
        Objects.equals(this.weight, pokemon.weight) &&
        Objects.equals(this.sprites, pokemon.sprites) &&
        Objects.equals(this.types, pokemon.types) &&
        Objects.equals(this.ability, pokemon.ability) &&
        Objects.equals(this.baseStatistics, pokemon.baseStatistics) &&
        Objects.equals(this.evolutionStageEntry, pokemon.evolutionStageEntry) &&
        Objects.equals(this.wayToEvolvedStage, pokemon.wayToEvolvedStage) &&
        Objects.equals(this.moves, pokemon.moves);
  }

  @Override
  public int hashCode() {
    return Objects.hash(entryNumber, name, description, height, weight, sprites, types, ability, baseStatistics, evolutionStageEntry, wayToEvolvedStage, moves);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Pokemon {\n");
    
    sb.append("    entryNumber: ").append(toIndentedString(entryNumber)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    height: ").append(toIndentedString(height)).append("\n");
    sb.append("    weight: ").append(toIndentedString(weight)).append("\n");
    sb.append("    sprites: ").append(toIndentedString(sprites)).append("\n");
    sb.append("    types: ").append(toIndentedString(types)).append("\n");
    sb.append("    ability: ").append(toIndentedString(ability)).append("\n");
    sb.append("    baseStatistics: ").append(toIndentedString(baseStatistics)).append("\n");
    sb.append("    evolutionStageEntry: ").append(toIndentedString(evolutionStageEntry)).append("\n");
    sb.append("    wayToEvolvedStage: ").append(toIndentedString(wayToEvolvedStage)).append("\n");
    sb.append("    moves: ").append(toIndentedString(moves)).append("\n");
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
