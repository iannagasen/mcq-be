package dev.agaen.mcq.core;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.agaen.mcq.dto.ChoiceExplanationDTO;
import dev.agaen.mcq.dto.QuestionDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class QuestionService {

  private final QuestionRepository questionRepository;

  public List<QuestionDTO> findAllQuestions() {
    return questionRepository.findAll().stream()
        .map(this::toDTO)
        .toList();
  }

  public QuestionDTO toDTO(Question question) {
    log.info("LOGGING -----");
    question.getChoices().stream().map(Choice::toString).forEach(log::info);
    var dto = new QuestionDTO();
    var choices = question.getChoices().stream()
        .map(c -> new ChoiceExplanationDTO(c.getChoice(), c.getExplanation()))
        .toList();
    dto.setAnswer(question.getAnswer().getChoice());
    dto.setChoices(choices);
    dto.setQuestion(question.getQuestion());
    return dto;
  }
}
