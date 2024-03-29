package sideproject.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sideproject.practice.domain.Emotion;

public interface EmotionRepository extends JpaRepository<Emotion, Long> {
}
