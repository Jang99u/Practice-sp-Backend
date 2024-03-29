package sideproject.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sideproject.practice.domain.Diary;

import java.util.List;

public interface DiaryRepository extends JpaRepository<Diary, Long> {
    List<Diary> findAllByUserId(Long userId);
}
