package net.plantsystem.application.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author rames on 2023-03-16
 */
@Getter
@Setter
public class BatteryResponseDTO implements Serializable {

    private Long batteryId;

    private String batteryName;

    private Long postcode;

    private Double batteryCapacityInWatt;
}
