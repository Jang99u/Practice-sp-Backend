package sideproject.practice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sideproject.practice.dto.emotion.request.CreateEmotionRequest;
import sideproject.practice.service.EmotionService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/emotion")
public class EmotionController {
    private final EmotionService emotionService;

    @PostMapping
    public void saveEmotion(@RequestBody CreateEmotionRequest createEmotionRequest, @RequestParam Long diaryId) {
        emotionService.saveEmotion(createEmotionRequest, diaryId);
    }

    @GetMapping
    public ResponseEntity<List<String>> getDiaryEmotion(@RequestParam Long diaryId) {
        return emotionService.getDiaryEmotion(diaryId);
    }
}
