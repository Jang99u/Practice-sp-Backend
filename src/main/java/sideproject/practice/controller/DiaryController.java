package sideproject.practice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sideproject.practice.dto.diary.request.CreateDiaryRequest;
import sideproject.practice.service.DiaryService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/diary")
public class DiaryController {
    private final DiaryService diaryService;

    @PostMapping
    public void saveDiary(@RequestBody CreateDiaryRequest createDiaryRequest, @RequestParam Long userId) {
        diaryService.saveDiary(createDiaryRequest, userId);
    }

    @GetMapping
    public ResponseEntity<List<String>> getUserDiaryTitle (@RequestParam Long userId) {
        return diaryService.getUserDiaryTitle(userId);
    }
}
