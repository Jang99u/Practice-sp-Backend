package sideproject.practice.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sideproject.practice.domain.Diary;
import sideproject.practice.domain.User;
import sideproject.practice.dto.diary.request.CreateDiaryRequest;
import sideproject.practice.repository.DiaryRepository;
import sideproject.practice.repository.UserRepository;

import java.util.List;

@Service
public class DiaryService {
    private final UserRepository userRepository;
    private final DiaryRepository diaryRepository;

    public DiaryService(UserRepository userRepository, DiaryRepository diaryRepository) {
        this.userRepository = userRepository;
        this.diaryRepository = diaryRepository;
    }

    @Transactional
    public void saveDiary(CreateDiaryRequest createDiaryRequest, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(IllegalAccessError::new);

        diaryRepository.save(new Diary(createDiaryRequest.getTitle(), createDiaryRequest.getContent(),user));
    }

    @Transactional(readOnly = true)
    public ResponseEntity<List<String>> getUserDiaryTitle(Long userId) {
        List<String> diaryTitleList = diaryRepository.findAllByUserId(userId).stream()
                .map(diary -> diary.getTitle())
                .toList();

        return ResponseEntity.ok().body(diaryTitleList);
    }
}
