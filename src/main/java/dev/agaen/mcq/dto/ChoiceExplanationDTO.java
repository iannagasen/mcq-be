package dev.agaen.mcq.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
public class ChoiceExplanationDTO {
  private String choice;
  private String explanation;
}
