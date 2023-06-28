package dev.agaen.mcq.dto;

import java.util.List;

import lombok.Data;

@Data
public class QuestionDTO {
  private String question;
  private List<ChoiceExplanationDTO> choices;
  private String answer;
}
