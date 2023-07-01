package net.plantsystem.application.dto.request;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

import java.util.List;

/**
 * @author rames on 2023-03-16
 */
@Getter
@Setter
public class BatteryListRequestDTO implements Serializable {

    @NotNull
    @NotEmpty
    private List<BatteryRequestDTO> batteryRequestDTOList;
}
