package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.Pokemon;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * PutPokemonBody
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-08-14T20:34:58.722562253+02:00[Europe/Paris]")


public class PutPokemonBody   {
  @JsonProperty("pokemon")
  private Pokemon pokemon = null;

  public PutPokemonBody pokemon(Pokemon pokemon) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PutPokemonBody putPokemonBody = (PutPokemonBody) o;
    return Objects.equals(this.pokemon, putPokemonBody.pokemon);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pokemon);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PutPokemonBody {\n");
    
    sb.append("    pokemon: ").append(toIndentedString(pokemon)).append("\n");
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
