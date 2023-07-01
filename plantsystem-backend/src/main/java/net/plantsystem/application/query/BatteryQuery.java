package net.plantsystem.application.query;

import net.plantsystem.application.dto.request.BatteryFetchRequestDTO;
import org.springframework.util.ObjectUtils;

/**
 * @author rames on 2023-03-16
 */
public class BatteryQuery {

    public static final String QUERY_TO_FETCH_BATTERY_LIST(BatteryFetchRequestDTO fetchRequestDTO) {
        return " SELECT " +
                " b.id as batteryId," +
                " b.name as batteryName," +
                " b.postcode as postcode, " +
                " b.capacity as batteryCapacityInWatt" +
                " FROM Battery b" +
                GET_WHERE_CLAUSE_FOR_FETCH_BATTERY_LIST(fetchRequestDTO);


    }

    private static String GET_WHERE_CLAUSE_FOR_FETCH_BATTERY_LIST(BatteryFetchRequestDTO fetchRequestDTO) {

        String whereClause = " WHERE" +
                " b.status!='D'";

        if(!ObjectUtils.isEmpty(fetchRequestDTO.getInitialPostcode()) && !ObjectUtils.isEmpty(fetchRequestDTO.getFinalPostcode()))
            whereClause += "AND (b.postcode BETWEEN '" + fetchRequestDTO.getInitialPostcode()
                    + " ' AND ' "
                    + fetchRequestDTO.getFinalPostcode() + "')";

        return whereClause + "ORDER BY b.name ASC";
    }
    }
