package dev.agaen.mcq.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.agaen.mcq.core.Question;
import dev.agaen.mcq.core.QuestionGroup;
import dev.agaen.mcq.core.QuestionGroupRepository;
import dev.agaen.mcq.core.QuestionRepository;
import dev.agaen.mcq.core.QuestionService;
import dev.agaen.mcq.dto.QuestionDTO;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

  private final QuestionGroupRepository questionGroupRepository;
  private final QuestionRepository questionRepository;
  private final QuestionService questionService;

  @GetMapping("/questions")
  public List<QuestionDTO> findAllQuestions() {
    return questionService.findAllQuestions();
  }

  @GetMapping("/questiongroups")
  public List<QuestionGroup> findAllQuestionGroups() {
    return questionGroupRepository.findAll();
  }
}
