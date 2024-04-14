package sideproject.practice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sideproject.practice.domain.Diary;
import sideproject.practice.domain.User;
import sideproject.practice.dto.diary.request.CreateDiaryRequest;
import sideproject.practice.exeption.CustomErrorCode;
import sideproject.practice.exeption.CustomException;
import sideproject.practice.repository.DiaryRepository;
import sideproject.practice.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiaryService {
    private final UserRepository userRepository;
    private final DiaryRepository diaryRepository;

    @Transactional
    public void saveDiary(CreateDiaryRequest createDiaryRequest, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new CustomException(CustomErrorCode.USER_NOT_FOUND));

        diaryRepository.save(new Diary(createDiaryRequest.title(), createDiaryRequest.content(),user));
    }

    @Transactional(readOnly = true)
    public ResponseEntity<List<String>> getUserDiaryTitle(Long userId) {
        if(!diaryRepository.existsByUserId(userId)) {
            throw new CustomException(CustomErrorCode.USER_NOT_FOUND);
        }

        List<String> diaryTitleList = diaryRepository.findAllByUserId(userId).stream()
                .map(diary -> diary.getTitle())
                .toList();

        return ResponseEntity.ok().body(diaryTitleList);
    }
}
