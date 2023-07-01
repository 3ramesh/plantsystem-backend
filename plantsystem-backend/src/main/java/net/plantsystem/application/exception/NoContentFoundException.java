package net.plantsystem.application.exception;

import lombok.Getter;
import org.springframework.util.StringUtils;

import static net.plantsystem.application.utils.ExceptionUtils.*;
import static org.springframework.http.HttpStatus.NOT_FOUND;

/**  public static String generateDebugMessage(Class clazz) {
 return splitByCharacterTypeCamelCase(clazz.getSimpleName()) + "(s) is empty.";
 }
 * @author rames on 2023-03-16
 */

@Getter
public class NoContentFoundException extends RuntimeException{

    private ExceptionResponse exception;

    public NoContentFoundException(Class clazz) {
        super(generateMessage(clazz));
        setErrorResponse(generateMessage(clazz), generateDebugMessage(clazz));
    }

    public NoContentFoundException(Class clazz, String... searchParamsMap) {
        super(generateMessage(clazz.getSimpleName(), toMap(String.class, String.class, searchParamsMap)));
        setErrorResponse(
                generateMessage(clazz),
                StringUtils.capitalize("Object returned empty or null for ")
                        + toMap(String.class, String.class, searchParamsMap));
    }

    private void setErrorResponse(String errorMessage, String debugMessage) {
        exception = ExceptionResponse.builder()
                .errorMessage(errorMessage)
                .responseStatus(NOT_FOUND)
                .responseCode(NOT_FOUND.value())
                .build();
    }


}
