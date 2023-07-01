package net.plantsystem.application.dto.request;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author rames on 2023-03-16
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BatteryRequestDTO implements Serializable {

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    private Long postcode;

    @NotNull
    private Double capacity;

}
