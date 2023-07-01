package net.plantsystem.application.repository.custom.Impl;

import lombok.extern.slf4j.Slf4j;
import net.plantsystem.application.dto.request.BatteryFetchRequestDTO;
import net.plantsystem.application.dto.response.BatteryListResponseDTO;
import net.plantsystem.application.dto.response.BatteryResponseDTO;
import net.plantsystem.application.exception.NoContentFoundException;
import net.plantsystem.application.model.Battery;
import net.plantsystem.application.repository.custom.BatteryRepositoryCustom;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.function.Supplier;

import static net.plantsystem.application.query.BatteryQuery.QUERY_TO_FETCH_BATTERY_LIST;
import static net.plantsystem.application.utils.QueryUtils.createQuery;
import static net.plantsystem.application.utils.QueryUtils.transformQueryToResultList;

/**
 * @author rames on 2023-03-16
 */

@Repository
@Transactional(readOnly = true)
@Slf4j
public class BatteryRepositoryCustomImpl implements BatteryRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public BatteryListResponseDTO fetchBatteryList(BatteryFetchRequestDTO requestDTO) {

        Query query = createQuery.apply(entityManager, QUERY_TO_FETCH_BATTERY_LIST(requestDTO));


        int totalItems = query.getResultList().size();

        List<BatteryResponseDTO> results = transformQueryToResultList(query, BatteryResponseDTO.class);

        if (results.isEmpty()) {
            throw BATTERY_NOT_FOUND.get();
        } else {
            double totalCapacity = results.stream().
                    mapToDouble(BatteryResponseDTO::getBatteryCapacityInWatt)
                    .sum();
            double averageCapacity = totalCapacity / totalItems;
            BatteryListResponseDTO batteryListResponseDTO = new BatteryListResponseDTO();
            batteryListResponseDTO.setTotalItem(totalItems);
            batteryListResponseDTO.setTotalCapacityInWatt(totalCapacity);
            batteryListResponseDTO.setAverageCapacityInWatt(averageCapacity);
            batteryListResponseDTO.setBatteryRequestDTOList(results);

            return batteryListResponseDTO;
        }

    }

    private Supplier<NoContentFoundException> BATTERY_NOT_FOUND = () -> new NoContentFoundException(Battery.class);

}
