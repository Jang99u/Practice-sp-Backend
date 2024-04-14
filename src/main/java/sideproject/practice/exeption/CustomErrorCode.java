package sideproject.practice.exeption;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum CustomErrorCode {
    JSON_BAD_REQUEST(40000, HttpStatus.BAD_REQUEST, "잘못된 형식의 요청입니다."),

    USER_NOT_FOUND(40400, HttpStatus.NOT_FOUND, "존재하지 않는 유저입니다."),
    DIARY_NOT_FOUND(40401, HttpStatus.NOT_FOUND, "존재하지 않는 다이어리입니다."),
    ;

    private final Integer code;
    private final HttpStatus httpStatus;
    private final String message;
}
