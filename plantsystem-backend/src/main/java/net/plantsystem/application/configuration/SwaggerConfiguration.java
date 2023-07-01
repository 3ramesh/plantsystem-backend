package net.plantsystem.application.configuration;

import net.plantsystem.application.constant.SwaggerConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author rames on 2023-03-15
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(SwaggerConstants.BASE_PACKAGE))
                .paths(PathSelectors.regex(SwaggerConstants.PATH_REGEX))
                .build()
                .apiInfo(metaData());
    }

    private ApiInfo metaData() {
        return new ApiInfo(
                "virtual power Plant System (Application)",
                "About: " + "REST API in spring boot",
                "V1",
                "https://nexdigitalstudio.com/",
                new Contact(
                        "Developer",
                        "https://nexdigitalstudio.com/",
                        "info@nexdigitalstudio.com"),
                "Licensed to next digital studio",
                "https://nexdigitalstudio.com/",
                java.util.Collections.emptyList());
    }


}
