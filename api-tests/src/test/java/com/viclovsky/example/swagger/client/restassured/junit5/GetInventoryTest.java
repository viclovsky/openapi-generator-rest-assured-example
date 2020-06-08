package com.viclovsky.example.swagger.client.restassured.junit5;

import com.google.inject.Inject;
import com.viclovsky.example.swagger.client.restassured.ApiClient;
import com.viclovsky.example.swagger.client.restassured.ResponseSpecBuilders;
import com.viclovsky.example.swagger.client.restassured.module.ExampleApiModule;
import name.falgout.jeffrey.testing.junit5.GuiceExtension;
import name.falgout.jeffrey.testing.junit5.IncludeModule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Map;

import static com.viclovsky.example.swagger.client.restassured.ResponseSpecBuilders.validatedWith;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

@ExtendWith(GuiceExtension.class)
@IncludeModule(ExampleApiModule.class)
class GetInventoryTest {

    @Inject
    private ApiClient api;

    @Test
    void shouldGetInventoryTest() {
        Map<String, Integer> inventory = api.store().getInventory().executeAs(ResponseSpecBuilders.validatedWith(ResponseSpecBuilders.shouldBeCode(SC_OK)));
        assertThat(inventory.keySet().size(), greaterThan(0));
    }
}
