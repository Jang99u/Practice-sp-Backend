package sideproject.practice.exeption;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomErrorHandler {

    @ExceptionHandler(CustomException.class)
    public CustomErrorResponse CustomHandler(CustomException e) {
        return new CustomErrorResponse(
                e.getCustomErrorCode().getCode(), e.getCustomErrorCode().getMessage()
        );
    }
}
