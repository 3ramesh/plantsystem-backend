package net.plantsystem.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.Map;

/**
 * @author rames on 2023-03-16
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StatusResponseDTO implements Serializable {

    private int responseCode;

    private HttpStatus responseStatus;

    private Map<String, ?> data;
}
