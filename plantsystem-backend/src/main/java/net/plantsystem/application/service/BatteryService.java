package net.plantsystem.application.service;

import net.plantsystem.application.dto.request.*;
import net.plantsystem.application.dto.response.BatteryListResponseDTO;
import net.plantsystem.application.dto.response.BatteryResponseDTO;
import net.plantsystem.application.dto.response.StatusResponseDTO;

import java.util.List;

/**
 * @author rames on 2023-03-16
 */
public interface BatteryService {

    StatusResponseDTO save(BatteryRequestDTO requestDTO);

    List<StatusResponseDTO> addList(BatteryListRequestDTO listRequestDTO);


    BatteryListResponseDTO fetchBatterList(BatteryFetchRequestDTO fetchRequestDTO);

    StatusResponseDTO update(BatteryUpdateRequestDTO updateRequestDTO);

    StatusResponseDTO delete(DeleteRequestDTO deleteRequestDTO);


}
