package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.Move;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * MoveListResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-08-14T20:34:58.722562253+02:00[Europe/Paris]")


public class MoveListResponse   {
  @JsonProperty("moveList")
  @Valid
  private List<Move> moveList = null;

  public MoveListResponse moveList(List<Move> moveList) {
    this.moveList = moveList;
    return this;
  }

  public MoveListResponse addMoveListItem(Move moveListItem) {
    if (this.moveList == null) {
      this.moveList = new ArrayList<Move>();
    }
    this.moveList.add(moveListItem);
    return this;
  }

  /**
   * Get moveList
   * @return moveList
   **/
  @Schema(description = "")
      @Valid
    public List<Move> getMoveList() {
    return moveList;
  }

  public void setMoveList(List<Move> moveList) {
    this.moveList = moveList;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MoveListResponse moveListResponse = (MoveListResponse) o;
    return Objects.equals(this.moveList, moveListResponse.moveList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(moveList);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MoveListResponse {\n");
    
    sb.append("    moveList: ").append(toIndentedString(moveList)).append("\n");
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
