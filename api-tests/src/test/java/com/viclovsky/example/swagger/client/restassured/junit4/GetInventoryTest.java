package com.viclovsky.example.swagger.client.restassured.junit4;

import com.viclovsky.example.swagger.client.restassured.ApiClient;
import com.viclovsky.example.swagger.client.restassured.GsonObjectMapper;
import com.viclovsky.example.swagger.client.restassured.ResponseSpecBuilders;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ErrorLoggingFilter;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static com.viclovsky.example.swagger.client.restassured.ResponseSpecBuilders.validatedWith;
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
                                        .defaultObjectMapper(GsonObjectMapper.gson())))
                        .addFilter(new ErrorLoggingFilter())
                        .setBaseUri("http://petstore.swagger.io:80/v2")));
    }

    @Test
    public void shouldGetInventoryTest() {
        Map<String, Integer> inventory = api.store().getInventory().executeAs(ResponseSpecBuilders.validatedWith(ResponseSpecBuilders.shouldBeCode(SC_OK)));
        assertThat(inventory.keySet().size(), greaterThan(0));
    }

}
