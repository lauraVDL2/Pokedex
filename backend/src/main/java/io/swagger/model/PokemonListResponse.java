package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.Pokemon;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * PokemonListResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-08-14T18:27:36.393621428+02:00[Europe/Paris]")


public class PokemonListResponse   {
  @JsonProperty("pokemonList")
  @Valid
  private List<Pokemon> pokemonList = null;

  public PokemonListResponse pokemonList(List<Pokemon> pokemonList) {
    this.pokemonList = pokemonList;
    return this;
  }

  public PokemonListResponse addPokemonListItem(Pokemon pokemonListItem) {
    if (this.pokemonList == null) {
      this.pokemonList = new ArrayList<Pokemon>();
    }
    this.pokemonList.add(pokemonListItem);
    return this;
  }

  /**
   * Get pokemonList
   * @return pokemonList
   **/
  @Schema(description = "")
      @Valid
    public List<Pokemon> getPokemonList() {
    return pokemonList;
  }

  public void setPokemonList(List<Pokemon> pokemonList) {
    this.pokemonList = pokemonList;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PokemonListResponse pokemonListResponse = (PokemonListResponse) o;
    return Objects.equals(this.pokemonList, pokemonListResponse.pokemonList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pokemonList);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PokemonListResponse {\n");
    
    sb.append("    pokemonList: ").append(toIndentedString(pokemonList)).append("\n");
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
