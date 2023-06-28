package dev.agaen.mcq.core;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "mcq_choices")
public class Choice {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  private String choice;
  private String explanation;

  @ManyToOne(fetch = FetchType.LAZY)
  private Question question;

  public String toString() {
    return String.format("[choice: %s, explanation: %s]", choice, explanation);
  }
}
