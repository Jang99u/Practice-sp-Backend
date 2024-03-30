package sideproject.practice.dto.emotion.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CreateEmotionRequest {
    @JsonProperty("emotion")
    private String reaction;
}
