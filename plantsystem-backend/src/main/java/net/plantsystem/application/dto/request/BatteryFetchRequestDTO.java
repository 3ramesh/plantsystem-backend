package net.plantsystem.application.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author rames on 2023-03-16
 */
@Getter
@Setter
public class BatteryFetchRequestDTO implements Serializable {


    @NotNull
    private Long initialPostcode;

    @NotNull
    private Long finalPostcode;






}
