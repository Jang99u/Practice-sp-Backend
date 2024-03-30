package sideproject.practice.dto.user.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CreateUserRequest {
    @JsonProperty("name")
    private String name;
}
