package com.viclovsky.example;

import com.google.inject.Inject;
import name.falgout.jeffrey.testing.junit5.GuiceExtension;
import name.falgout.jeffrey.testing.junit5.IncludeModule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import com.viclovsky.example.module.ExampleApiModule;
import com.viclovsky.example.swagger.client.ApiClient;

import java.util.Map;

import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static com.viclovsky.example.swagger.client.ResponseSpecBuilders.shouldBeCode;
import static com.viclovsky.example.swagger.client.ResponseSpecBuilders.validatedWith;

@ExtendWith(GuiceExtension.class)
@IncludeModule(ExampleApiModule.class)
public class SimpleJunit5Test {

    @Inject
    private ApiClient api;

    @Test
    void simpleTest() {
        Map<String, Integer> inventory = api.store().getInventory().executeAs(validatedWith(shouldBeCode(SC_OK)));
        assertThat(inventory.keySet().size(), greaterThan(0));
    }
}
