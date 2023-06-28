package dev.agaen.mcq.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class QuestionGroupRepositoryTest {

  @Autowired
  QuestionGroupRepository repository;

  @BeforeEach
  void setup() {
    // repository.saveAllAndFlush(List.of(
    // new QuestionGroup(null, "Group 1"),
    // new QuestionGroup(null, "Group 2")));
  }

  @Test
  void findAllShouldProduceAllQuestionGroups() {
    var questionGroups = repository.findAll();
    assertEquals(2, questionGroups.size());
  }

  @Test
  void findAllShouldNotMatchSIze() {
    var questionGroups = repository.findAll();
    assertNotEquals(3, questionGroups.size());
  }
}
