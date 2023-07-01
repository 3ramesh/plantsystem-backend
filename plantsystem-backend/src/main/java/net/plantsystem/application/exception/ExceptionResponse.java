package net.plantsystem.application.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

/**
 * @author rames on 2023-03-16
 */
@Getter
@Setter
@Builder
public class ExceptionResponse {

    private final HttpStatus responseStatus;

    private final int responseCode;

    private final String errorMessage;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private final LocalDateTime timeStamp;

    private final String debugMessage;
}
