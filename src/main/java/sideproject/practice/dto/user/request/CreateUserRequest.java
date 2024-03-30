package sideproject.practice.dto.user.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CreateUserRequest(
        @JsonProperty("name") String name
) {
}
