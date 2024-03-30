package sideproject.practice.dto.diary.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CreateDiaryRequest(
        @JsonProperty("title")
        String title,

        @JsonProperty("content")
        String content
) {
}
