package sideproject.practice.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sideproject.practice.domain.Diary;
import sideproject.practice.domain.Emotion;
import sideproject.practice.dto.emotion.request.CreateEmotionRequest;
import sideproject.practice.repository.DiaryRepository;
import sideproject.practice.repository.EmotionRepository;

@Service
public class EmotionService {
    private final DiaryRepository diaryRepository;
    private final EmotionRepository emotionRepository;

    public EmotionService(DiaryRepository diaryRepository, EmotionRepository emotionRepository) {
        this.diaryRepository = diaryRepository;
        this.emotionRepository = emotionRepository;
    }

    @Transactional
    public void saveEmotion(CreateEmotionRequest createEmotionRequest, Long diaryId) {
        Diary diary = diaryRepository.findById(diaryId)
                .orElseThrow(IllegalAccessError::new);

        emotionRepository.save(new Emotion(createEmotionRequest.getReaction(), diary));
    }
}
