package net.plantsystem.application.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static net.plantsystem.application.constant.SwaggerConstants.TestConstant.BASE_API_VALUE;
import static net.plantsystem.application.constant.SwaggerConstants.TestConstant.TEST_OPERATION;
import static net.plantsystem.application.constant.WebResourceKeyConstants.API_V1;
import static net.plantsystem.application.constant.WebResourceKeyConstants.TestResourceConstant.BASE_TEST_RESOURCE;

/**
 * @author rames on 2023-03-15
 */

@RestController
@RequestMapping(API_V1 + BASE_TEST_RESOURCE)
@Api(BASE_API_VALUE)
public class TestController {

    @GetMapping
    @ApiOperation(TEST_OPERATION)
    public String test() {
        return "Virtual Plant Power System is running successfully! ....";
    }

}
