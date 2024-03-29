package sideproject.practice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sideproject.practice.dto.emotion.request.CreateEmotionRequest;
import sideproject.practice.service.EmotionService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/emotion")
public class EmotionController {
    private final EmotionService emotionService;

    @PostMapping
    public void saveEmotion(@RequestBody CreateEmotionRequest createEmotionRequest, @RequestParam Long diaryId) {
        emotionService.saveEmotion(createEmotionRequest, diaryId);
    }
}
