package sideproject.practice.dto.diary.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CreateDiaryRequest {
    @JsonProperty("title")
    private String title;

    @JsonProperty("content")
    private String content;
}
