package net.plantsystem.application.exception;

import lombok.Getter;
import net.plantsystem.application.utils.ExceptionUtils;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

/**
 * @author rames on 2023-03-16
 */
@Getter
public class BadRequestException extends RuntimeException{


    private ExceptionResponse exception;

    public BadRequestException(String errorMessage) {
        super(errorMessage);
        setErrorResponse(errorMessage, errorMessage);
    }

    public BadRequestException(String errorMessage, String debugMessage) {
        setErrorResponse(errorMessage, debugMessage);
    }

    private void setErrorResponse(String errorMessage, String debugMessage) {
        exception = ExceptionResponse.builder()
                .errorMessage(errorMessage)
                .debugMessage(debugMessage)
                .responseStatus(BAD_REQUEST)
                .responseCode(BAD_REQUEST.value())
                .timeStamp(ExceptionUtils.getLocalDateTime())
                .build();
    }
}
