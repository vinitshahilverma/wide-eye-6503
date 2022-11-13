package com.soulfood.configClasses;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(getInfo()).select().apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build();
        
    }

    private ApiInfo getInfo() {
        return new ApiInfo("SoulFood : Online Food Delivery Application", 
                            "This project is developed by Masai School Students \n"+
                             "Team Name - Wide-eye-6503 \n"+
                             " Team Members : \n"+
                             " ------------------- \n"+
                             "Sahil Verma \n"+
                             "Vinay Pathania \n"+
                             "Gaurav Pimplekar \n"+
                             "Krishna Keshav \n"+
                             "Guddu Choudhary", 
                            "1.0", "Term of Services", 
                            new springfox.documentation.service.Contact("Team Wide-Eye-6503", "http://localhost:8888/swagger-ui/#/", "abc@gmail.com"), 
                            "Lisence of API", 
                            "Api Lisence Url", 
                            Collections.emptyList());
    }

}
