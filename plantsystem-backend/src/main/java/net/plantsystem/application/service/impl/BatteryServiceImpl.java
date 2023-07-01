package net.plantsystem.application.service.impl;

import lombok.extern.slf4j.Slf4j;
import net.plantsystem.application.dto.request.*;
import net.plantsystem.application.dto.response.BatteryListResponseDTO;
import net.plantsystem.application.dto.response.StatusResponseDTO;
import net.plantsystem.application.exception.BadRequestException;
import net.plantsystem.application.exception.NoContentFoundException;
import net.plantsystem.application.model.Battery;
import net.plantsystem.application.repository.BatteryRepository;
import net.plantsystem.application.service.BatteryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static net.plantsystem.application.constant.ErrorMessageConstants.FINAL_VALUE_OF_POSTCODE_RANGE_ALWAYS_GREATER_THAN_INITIAL_VALUE;
import static net.plantsystem.application.log.CommonLogConstant.*;
import static net.plantsystem.application.log.constants.BatteryLong.BATTERY;
import static net.plantsystem.application.utils.BatteryUtils.*;
import static net.plantsystem.application.utils.DateUtils.getDifferenceBetweenTwoTime;
import static net.plantsystem.application.utils.DateUtils.getTimeInMillisecondsFromLocalDate;

/**
 * @author rames on 2023-03-16
 */

@Service
@Transactional
@Slf4j
public class BatteryServiceImpl implements BatteryService {

    private final BatteryRepository batteryRepository;

    public BatteryServiceImpl(BatteryRepository batteryRepository) {
        this.batteryRepository = batteryRepository;
    }

    @Override
    public StatusResponseDTO save(BatteryRequestDTO requestDTO) {

        Long startTime = getTimeInMillisecondsFromLocalDate();

        log.info(SAVING_PROCESS_STARTED, BATTERY);

        Battery battery = saveBattery(parseToSaveBattery(requestDTO));

        log.info(SAVING_PROCESS_COMPLETED, BATTERY, getDifferenceBetweenTwoTime(startTime));

        return parseToSaveBatteryResponseDTO(battery.getId());

    }

    @Override
    public List<StatusResponseDTO> addList(BatteryListRequestDTO listRequestDTO) {

        Long startTime = getTimeInMillisecondsFromLocalDate();

        log.info(LIST_ADDING_PROCESS_STARTED, BATTERY);

        List<StatusResponseDTO> responseDTOS = new ArrayList<>();

        List<BatteryRequestDTO> batteryRequestDTOList = listRequestDTO.getBatteryRequestDTOList();

        for (BatteryRequestDTO batteryList : batteryRequestDTOList) {

            Battery battery = saveBattery(parseToSaveBattery(batteryList));
            responseDTOS.add(parseToSaveBatteryResponseDTO(battery.getId()));

        }

        log.info(LIST_ADDING_PROCESS_PROCESS_COMPLETED, BATTERY, getDifferenceBetweenTwoTime(startTime));

        return responseDTOS;
    }

    @Override
    public BatteryListResponseDTO fetchBatterList(BatteryFetchRequestDTO fetchRequestDTO) {

        Long startTime = getTimeInMillisecondsFromLocalDate();

        log.info(FETCHING_PROCESS_STARTED, BATTERY);

        if(fetchRequestDTO.getInitialPostcode() > fetchRequestDTO.getFinalPostcode())
            throw new BadRequestException(FINAL_VALUE_OF_POSTCODE_RANGE_ALWAYS_GREATER_THAN_INITIAL_VALUE);

        BatteryListResponseDTO responseDTO = batteryRepository.fetchBatteryList(fetchRequestDTO);

        log.info(FETCHING_PROCESS_PROCESS_COMPLETED, BATTERY, getDifferenceBetweenTwoTime(startTime));

        return responseDTO;
    }

    @Override
    public StatusResponseDTO update(BatteryUpdateRequestDTO updateRequestDTO) {

        Long startTime = getTimeInMillisecondsFromLocalDate();

        log.info(UPDATING_PROCESS_STARTED, BATTERY);

        Battery battery = findById(updateRequestDTO.getId());

        parseToUpdateBattery(updateRequestDTO, battery);

        log.info(UPDATING_PROCESS_COMPLETED, BATTERY, getDifferenceBetweenTwoTime(startTime));

        return parseToSaveBatteryResponseDTO(battery.getId());
    }

    @Override
    public StatusResponseDTO delete(DeleteRequestDTO deleteRequestDTO) {

        Long startTime = getTimeInMillisecondsFromLocalDate();

        log.info(DELETING_PROCESS_STARTED, BATTERY);

        Battery battery = findById((deleteRequestDTO.getId()));

        parseToDeleteBattery(deleteRequestDTO, battery);

        log.info(DELETING_PROCESS_STARTED, BATTERY, getDifferenceBetweenTwoTime(startTime));

        return parseToDeleteBatteryResponseDTO();
    }

    private Battery findById(Long batteryId) {
        return batteryRepository.findBatteryById(batteryId)
                .orElseThrow(() -> BATTERY_WITH_GIVEN_ID_NOT_FOUND.apply(batteryId));
    }


    private Battery saveBattery(Battery battery) {
        return batteryRepository.save(battery);
    }

    private Function<Long, NoContentFoundException> BATTERY_WITH_GIVEN_ID_NOT_FOUND = (id) -> {
        throw new NoContentFoundException(Battery.class, "id", id.toString());
    };
}
