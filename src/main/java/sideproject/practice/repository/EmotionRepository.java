package sideproject.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sideproject.practice.domain.Emotion;

import java.util.List;

public interface EmotionRepository extends JpaRepository<Emotion, Long> {
    List<Emotion> findAllByDiaryId(Long diaryId);
}
