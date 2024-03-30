package sideproject.practice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import sideproject.practice.domain.Diary;
import sideproject.practice.domain.Emotion;
import sideproject.practice.dto.emotion.request.CreateEmotionRequest;
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
                .orElseThrow(IllegalAccessError::new);

        emotionRepository.save(new Emotion(createEmotionRequest.reaction(), diary));
    }

    @Transactional
    public ResponseEntity<List<String>> getDiaryEmotion(@RequestParam Long diaryId) {
        List<String> emotionList= emotionRepository.findAllByDiaryId(diaryId).stream()
                .map(emotion -> emotion.getReaction())
                .toList();

        return ResponseEntity.ok().body(emotionList);
    }
}
