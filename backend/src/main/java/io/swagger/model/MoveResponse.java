package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.Move;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * MoveResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-08-14T18:27:36.393621428+02:00[Europe/Paris]")


public class MoveResponse   {
  @JsonProperty("move")
  private Move move = null;

  public MoveResponse move(Move move) {
    this.move = move;
    return this;
  }

  /**
   * Get move
   * @return move
   **/
  @Schema(description = "")
  
    @Valid
    public Move getMove() {
    return move;
  }

  public void setMove(Move move) {
    this.move = move;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MoveResponse moveResponse = (MoveResponse) o;
    return Objects.equals(this.move, moveResponse.move);
  }

  @Override
  public int hashCode() {
    return Objects.hash(move);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MoveResponse {\n");
    
    sb.append("    move: ").append(toIndentedString(move)).append("\n");
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
