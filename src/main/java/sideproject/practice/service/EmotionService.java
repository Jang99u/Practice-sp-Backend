package sideproject.practice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import sideproject.practice.domain.Diary;
import sideproject.practice.domain.Emotion;
import sideproject.practice.dto.emotion.request.CreateEmotionRequest;
import sideproject.practice.exeption.CustomErrorCode;
import sideproject.practice.exeption.CustomException;
import sideproject.practice.repository.DiaryRepository;
import sideproject.practice.repository.EmotionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmotionService {
    private final DiaryRepository diaryRepository;
    private final EmotionRepository emotionRepository;

    @Transactional
    public void saveEmotion(CreateEmotionRequest createEmotionRequest, Long diaryId) {
        Diary diary = diaryRepository.findById(diaryId)
                .orElseThrow(() -> new CustomException(CustomErrorCode.DIARY_NOT_FOUND));

        emotionRepository.save(new Emotion(createEmotionRequest.reaction(), diary));
    }

    @Transactional(readOnly = true)
    public ResponseEntity<List<String>> getDiaryEmotion(@RequestParam Long diaryId) {
        if(!emotionRepository.existsByDiaryId(diaryId)) {
            throw new CustomException(CustomErrorCode.DIARY_NOT_FOUND);
        }

        List<String> emotionList = emotionRepository.findAllByDiaryId(diaryId).stream()
                .map(emotion -> emotion.getReaction())
                .toList();

        return ResponseEntity.ok().body(emotionList);
    }
}
