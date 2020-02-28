package com.viclovsky.example.rest.assured.junit5;

import com.google.inject.Inject;
import com.viclovsky.example.module.ExampleApiModule;
import com.viclovsky.example.swagger.client.v1.ApiClient;
import name.falgout.jeffrey.testing.junit5.GuiceExtension;
import name.falgout.jeffrey.testing.junit5.IncludeModule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Map;

import static com.viclovsky.example.swagger.client.v1.ResponseSpecBuilders.shouldBeCode;
import static com.viclovsky.example.swagger.client.v1.ResponseSpecBuilders.validatedWith;
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
        Map<String, Integer> inventory = api.store().getInventory().executeAs(validatedWith(shouldBeCode(SC_OK)));
        assertThat(inventory.keySet().size(), greaterThan(0));
    }
}
