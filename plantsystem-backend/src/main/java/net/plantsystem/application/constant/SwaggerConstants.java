package net.plantsystem.application.constant;

/**
 * @author rames on 2023-03-15
 */
public class SwaggerConstants {

    public static String BASE_PACKAGE = "net.plantsystem.application.controller";

    public static String PATH_REGEX = "/api.*";


    public interface BatteryConstant {
        String BASE_API_VALUE = "This is Battery Resource";
        String SAVE_OPERATION = "Save new batteries";
        String UPDATE_OPERATION = "Update existing batteries";
        String DELETE_OPERATION = "Set battery status as 'D' with specific remarks";
        String SEARCH_OPERATION = "Search battery according to given request parameters";
        String FETCH_OPERATION = "Fetch battery details";

        String DETAILS_OPERATION = "Details ambulance details by id";

    }


    public interface TestConstant {
        String BASE_API_VALUE = "This is Test Resource";
        String TEST_OPERATION = "This is Test Operation";
    }


}
