package dev.agaen.mcq.core;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mcq_questions")
public class Question {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  private String question;

  @ManyToOne
  @JoinColumn(name = "group_id", insertable = false, updatable = false)
  private QuestionGroup questionGroup;

  @OneToMany(mappedBy = "question", // question is the mapped class field name
      cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Choice> choices; // Set instead of List to make the order random for each request

  @OneToOne(cascade = CascadeType.ALL)
  @JoinTable(name = "mcq_question_answers", joinColumns = {
      @JoinColumn(name = "question_id", referencedColumnName = "id")
  }, inverseJoinColumns = {
      @JoinColumn(name = "answer_id", referencedColumnName = "id")
  })
  private Choice answer;
}
