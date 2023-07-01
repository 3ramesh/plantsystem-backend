package net.plantsystem.application.repository.custom;

import net.plantsystem.application.dto.request.BatteryFetchRequestDTO;
import net.plantsystem.application.dto.response.BatteryListResponseDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * @author rames on 2023-03-16
 */
@Repository
@Qualifier("batteryRepositoryCustom")
public interface BatteryRepositoryCustom {

    BatteryListResponseDTO fetchBatteryList(BatteryFetchRequestDTO requestDTO);
}
