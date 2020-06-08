package com.viclovsky.example.swagger.client.restassured.junit5;

import com.google.inject.Inject;
import com.viclovsky.example.swagger.client.restassured.module.ExampleApiModule;
import com.viclovsky.example.swagger.client.restassured.ApiClient;
import name.falgout.jeffrey.testing.junit5.GuiceExtension;
import name.falgout.jeffrey.testing.junit5.IncludeModule;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.viclovsky.example.swagger.client.restassured.ResponseSpecBuilders.shouldBeCode;
import static com.viclovsky.example.swagger.client.restassured.ResponseSpecBuilders.validatedWith;
import static org.apache.http.HttpStatus.SC_OK;

@ExtendWith(GuiceExtension.class)
@IncludeModule(ExampleApiModule.class)
class SearchPet {

    @Inject
    private ApiClient api;

    @Test
    @Ignore("Only for demonstration")
    void shouldSearchPet() {
        api.pet().getPetSearch().statusQuery("ok")
                .execute(validatedWith(shouldBeCode(SC_OK)));
    }
}
