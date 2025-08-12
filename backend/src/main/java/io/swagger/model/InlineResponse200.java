package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.Move;
import io.swagger.model.Pokemon;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * InlineResponse200
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-08-12T19:22:41.448781311+02:00[Europe/Paris]")


public class InlineResponse200   {
  @JsonProperty("pokemon")
  private Pokemon pokemon = null;

  @JsonProperty("moves")
  @Valid
  private List<Move> moves = null;

  @JsonProperty("evolutions")
  @Valid
  private List<Pokemon> evolutions = null;

  public InlineResponse200 pokemon(Pokemon pokemon) {
    this.pokemon = pokemon;
    return this;
  }

  /**
   * Get pokemon
   * @return pokemon
   **/
  @Schema(description = "")
  
    @Valid
    public Pokemon getPokemon() {
    return pokemon;
  }

  public void setPokemon(Pokemon pokemon) {
    this.pokemon = pokemon;
  }

  public InlineResponse200 moves(List<Move> moves) {
    this.moves = moves;
    return this;
  }

  public InlineResponse200 addMovesItem(Move movesItem) {
    if (this.moves == null) {
      this.moves = new ArrayList<Move>();
    }
    this.moves.add(movesItem);
    return this;
  }

  /**
   * Get moves
   * @return moves
   **/
  @Schema(description = "")
      @Valid
    public List<Move> getMoves() {
    return moves;
  }

  public void setMoves(List<Move> moves) {
    this.moves = moves;
  }

  public InlineResponse200 evolutions(List<Pokemon> evolutions) {
    this.evolutions = evolutions;
    return this;
  }

  public InlineResponse200 addEvolutionsItem(Pokemon evolutionsItem) {
    if (this.evolutions == null) {
      this.evolutions = new ArrayList<Pokemon>();
    }
    this.evolutions.add(evolutionsItem);
    return this;
  }

  /**
   * Get evolutions
   * @return evolutions
   **/
  @Schema(description = "")
      @Valid
    public List<Pokemon> getEvolutions() {
    return evolutions;
  }

  public void setEvolutions(List<Pokemon> evolutions) {
    this.evolutions = evolutions;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse200 inlineResponse200 = (InlineResponse200) o;
    return Objects.equals(this.pokemon, inlineResponse200.pokemon) &&
        Objects.equals(this.moves, inlineResponse200.moves) &&
        Objects.equals(this.evolutions, inlineResponse200.evolutions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pokemon, moves, evolutions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse200 {\n");
    
    sb.append("    pokemon: ").append(toIndentedString(pokemon)).append("\n");
    sb.append("    moves: ").append(toIndentedString(moves)).append("\n");
    sb.append("    evolutions: ").append(toIndentedString(evolutions)).append("\n");
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
