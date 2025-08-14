package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * PokemonEvolutionStageEntry
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-08-14T20:34:58.722562253+02:00[Europe/Paris]")


public class PokemonEvolutionStageEntry   {
  @JsonProperty("previous")
  private Integer previous = null;

  @JsonProperty("next")
  @Valid
  private List<Integer> next = null;

  public PokemonEvolutionStageEntry previous(Integer previous) {
    this.previous = previous;
    return this;
  }

  /**
   * Get previous
   * @return previous
   **/
  @Schema(description = "")
  
    public Integer getPrevious() {
    return previous;
  }

  public void setPrevious(Integer previous) {
    this.previous = previous;
  }

  public PokemonEvolutionStageEntry next(List<Integer> next) {
    this.next = next;
    return this;
  }

  public PokemonEvolutionStageEntry addNextItem(Integer nextItem) {
    if (this.next == null) {
      this.next = new ArrayList<Integer>();
    }
    this.next.add(nextItem);
    return this;
  }

  /**
   * Get next
   * @return next
   **/
  @Schema(description = "")
  
    public List<Integer> getNext() {
    return next;
  }

  public void setNext(List<Integer> next) {
    this.next = next;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PokemonEvolutionStageEntry pokemonEvolutionStageEntry = (PokemonEvolutionStageEntry) o;
    return Objects.equals(this.previous, pokemonEvolutionStageEntry.previous) &&
        Objects.equals(this.next, pokemonEvolutionStageEntry.next);
  }

  @Override
  public int hashCode() {
    return Objects.hash(previous, next);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PokemonEvolutionStageEntry {\n");
    
    sb.append("    previous: ").append(toIndentedString(previous)).append("\n");
    sb.append("    next: ").append(toIndentedString(next)).append("\n");
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
