package net.plantsystem.application.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author rames on 2023-03-16
 */
@Getter
@Setter
public class BatteryUpdateRequestDTO implements Serializable {

    @NotNull
    private Long id;

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    private Long postcode;

    @NotNull
    private Double capacity;

    @NotNull
    private Character status;

    private String remarks;

}
