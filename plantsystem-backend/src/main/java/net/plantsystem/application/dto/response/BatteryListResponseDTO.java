package net.plantsystem.application.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
/**
 * @author rames on 2023-03-16
 */
@Getter
@Setter
public class BatteryListResponseDTO {

    private List<BatteryResponseDTO> batteryRequestDTOList;

    private int totalItem;

    private double totalCapacityInWatt;

    private double averageCapacityInWatt;



}
