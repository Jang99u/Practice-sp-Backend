package sideproject.practice.dto.emotion.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CreateEmotionRequest(
        @JsonProperty("reaction") String reaction
) {
}
