package com.viclovsky.example.oas.client.restassured.junit5;

import com.google.inject.Inject;
import com.viclovsky.example.oas.client.restassured.ApiClient;
import com.viclovsky.example.oas.client.restassured.module.ExampleApiModule;
import name.falgout.jeffrey.testing.junit5.GuiceExtension;
import name.falgout.jeffrey.testing.junit5.IncludeModule;
import org.junit.Ignore;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.viclovsky.example.oas.client.restassured.ResponseSpecBuilders.shouldBeCode;
import static com.viclovsky.example.oas.client.restassured.ResponseSpecBuilders.validatedWith;
import static org.apache.http.HttpStatus.SC_OK;

@ExtendWith(GuiceExtension.class)
@IncludeModule(ExampleApiModule.class)
class SearchPet {

    @Inject
    private ApiClient api;

    @Test
    @Disabled("Only for demonstration")
    void shouldSearchPet() {
        api.pet().getPetSearch().statusQuery("ok")
                .execute(validatedWith(shouldBeCode(SC_OK)));
    }
}
