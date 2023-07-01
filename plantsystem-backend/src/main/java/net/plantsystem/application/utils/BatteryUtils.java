package net.plantsystem.application.utils;

import net.plantsystem.application.dto.request.BatteryRequestDTO;
import net.plantsystem.application.dto.request.BatteryUpdateRequestDTO;
import net.plantsystem.application.dto.request.DeleteRequestDTO;
import net.plantsystem.application.dto.response.StatusResponseDTO;
import net.plantsystem.application.model.Battery;

import java.util.HashMap;
import java.util.Map;

import static net.plantsystem.application.constant.StatusConstant.ACTIVE;
import static net.plantsystem.application.constant.StatusConstant.DELETED;
import static org.springframework.http.HttpStatus.OK;

/**
 * @author rames on 2023-03-16
 */
public class BatteryUtils {

    public static Battery parseToSaveBattery(BatteryRequestDTO requestDTO) {

        Battery battery = new Battery();
        battery.setName(requestDTO.getName());
        battery.setPostcode(requestDTO.getPostcode());
        battery.setCapacity(requestDTO.getCapacity());
        battery.setStatus(ACTIVE);

        return battery;
    }

    public static Battery parseToUpdateBattery(BatteryUpdateRequestDTO updateRequestDTO, Battery battery) {

        battery.setId(updateRequestDTO.getId());
        battery.setName(updateRequestDTO.getName());
        battery.setPostcode(updateRequestDTO.getPostcode());
        battery.setCapacity(updateRequestDTO.getCapacity());
        battery.setRemarks(updateRequestDTO.getRemarks());
        battery.setStatus(updateRequestDTO.getStatus());

        return battery;
    }

    public static StatusResponseDTO parseToSaveBatteryResponseDTO(Long batteryId) {

        Map<String, Object> data = new HashMap<>();
        data.put("batteryId", batteryId);

        StatusResponseDTO responseDTO = new StatusResponseDTO();
        responseDTO.setData(data);
        responseDTO.setResponseCode(OK.value());
        responseDTO.setResponseStatus(OK);

        return responseDTO;
    }

    public static void parseToDeleteBattery(DeleteRequestDTO deleteRequestDTO,
                                            Battery battery) {

        battery.setStatus(DELETED);
        battery.setRemarks(deleteRequestDTO.getRemarks());
    }

    public static StatusResponseDTO parseToDeleteBatteryResponseDTO() {

        StatusResponseDTO responseDTO = new StatusResponseDTO();
        responseDTO.setResponseCode(OK.value());
        responseDTO.setResponseStatus(OK);

        return responseDTO;
    }

}
