package net.plantsystem.application.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.plantsystem.application.dto.request.*;
import net.plantsystem.application.service.BatteryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static java.net.URI.create;
import static net.plantsystem.application.constant.SwaggerConstants.BatteryConstant.*;
import static net.plantsystem.application.constant.WebResourceKeyConstants.API_V1;
import static net.plantsystem.application.constant.WebResourceKeyConstants.BatteryConstants.BASE_BATTERY;
import static net.plantsystem.application.constant.WebResourceKeyConstants.BatteryConstants.LIST;
import static org.springframework.http.ResponseEntity.created;
import static org.springframework.http.ResponseEntity.ok;

/**
 * @author rames on 2023-03-16
 */
@RestController
@RequestMapping(value = API_V1 + BASE_BATTERY)
@Api(BASE_API_VALUE)
public class BatteryController {

    private final BatteryService batteryService;

    public BatteryController(BatteryService batteryService) {
        this.batteryService = batteryService;
    }


    //add single item

    @PostMapping
    @ApiOperation(SAVE_OPERATION)
    public ResponseEntity<?> save(@Valid @RequestBody BatteryRequestDTO requestDTO) {
        batteryService.save(requestDTO);
        return created(create(API_V1 + BASE_BATTERY)).build();
    }

    // add list of items according to your question

    @PostMapping(LIST)
    @ApiOperation(SAVE_OPERATION)
    public ResponseEntity<?> addList(@Valid @RequestBody BatteryListRequestDTO listRequestDTO) {
        batteryService.addList(listRequestDTO);
        return created(create(API_V1 + BASE_BATTERY)).build();
    }

    //Fetch list of Item

    @PutMapping(FETCH_OPERATION)
    @ApiOperation(FETCH_OPERATION)
    public ResponseEntity<?> fetchBatterList(@Valid @RequestBody BatteryFetchRequestDTO fetchRequestDTO) {
        return ok().body(batteryService.fetchBatterList(fetchRequestDTO));
    }

    //Edit item by id if some  value was wrongly added
    @PutMapping
    @ApiOperation(UPDATE_OPERATION)
    public ResponseEntity<?> update(@Valid @RequestBody BatteryUpdateRequestDTO updateRequestDTO) {
        batteryService.update(updateRequestDTO);
        return ok().body(updateRequestDTO);

    }

    @DeleteMapping
    @ApiOperation(DELETE_OPERATION)
    public ResponseEntity<?> delete(@Valid @RequestBody DeleteRequestDTO deleteRequestDTO) {
        return ok().body(batteryService.delete(deleteRequestDTO));
    }




}
