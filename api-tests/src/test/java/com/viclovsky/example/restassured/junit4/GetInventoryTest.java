package com.viclovsky.example.restassured.junit4;

import com.viclovsky.example.swagger.client.v1.ApiClient;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ErrorLoggingFilter;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static com.viclovsky.example.swagger.client.v1.GsonObjectMapper.gson;
import static com.viclovsky.example.swagger.client.v1.ResponseSpecBuilders.shouldBeCode;
import static com.viclovsky.example.swagger.client.v1.ResponseSpecBuilders.validatedWith;
import static io.restassured.config.ObjectMapperConfig.objectMapperConfig;
import static io.restassured.config.RestAssuredConfig.config;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

public class GetInventoryTest {

    private ApiClient api;

    @Before
    public void createApi() {
        api = ApiClient.api(ApiClient.Config.apiConfig()
                .reqSpecSupplier(() -> new RequestSpecBuilder()
                        .setConfig(config()
                                .objectMapperConfig(objectMapperConfig()
                                        .defaultObjectMapper(gson())))
                        .addFilter(new ErrorLoggingFilter())
                        .setBaseUri("http://petstore.swagger.io:80/v2")));
    }

    @Test
    public void shouldGetInventoryTest() {
        Map<String, Integer> inventory = api.store().getInventory().executeAs(validatedWith(shouldBeCode(SC_OK)));
        assertThat(inventory.keySet().size(), greaterThan(0));
    }

}
