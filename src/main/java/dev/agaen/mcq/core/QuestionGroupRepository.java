package dev.agaen.mcq.core;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionGroupRepository extends JpaRepository<QuestionGroup, UUID> {

}
