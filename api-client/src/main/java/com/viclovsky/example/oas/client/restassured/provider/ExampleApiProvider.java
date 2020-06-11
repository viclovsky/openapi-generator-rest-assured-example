package com.viclovsky.example.oas.client.restassured.provider;

import com.google.inject.Provider;
import com.viclovsky.example.oas.client.restassured.ApiClient;
import com.viclovsky.example.oas.client.restassured.GsonObjectMapper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ErrorLoggingFilter;

import static io.restassured.config.ObjectMapperConfig.objectMapperConfig;
import static io.restassured.config.RestAssuredConfig.config;

public class ExampleApiProvider implements Provider<ApiClient> {

    @Override
    public ApiClient get() {
        return ApiClient.api(ApiClient.Config.apiConfig().reqSpecSupplier(
                () -> new RequestSpecBuilder().setConfig(config()
                        .objectMapperConfig(objectMapperConfig()
                                .defaultObjectMapper(GsonObjectMapper.gson())))
                        .addFilter(new ErrorLoggingFilter())
                        .setBaseUri("http://petstore.swagger.io:80/v2")));
    }
}
