package com.viclovsky.example.oas.client.restassured.junit5;

import com.google.inject.Inject;
import com.viclovsky.example.oas.client.restassured.ApiClient;
import com.viclovsky.example.oas.client.restassured.model.Pet;
import com.viclovsky.example.oas.client.restassured.module.ExampleApiModule;
import com.viclovsky.example.oas.client.restassured.model.ModelApiResponse;
import name.falgout.jeffrey.testing.junit5.GuiceExtension;
import name.falgout.jeffrey.testing.junit5.IncludeModule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.viclovsky.example.oas.client.restassured.ResponseSpecBuilders.shouldBeCode;
import static com.viclovsky.example.oas.client.restassured.ResponseSpecBuilders.validatedWith;
import static org.apache.http.HttpStatus.SC_NOT_FOUND;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(GuiceExtension.class)
@IncludeModule(ExampleApiModule.class)
class GetPetByIdTest {

    private static final String NOT_EXIST_ID = "-1";

    @Inject
    private ApiClient api;

    @Test
    void shouldGetPetByIdTest() {
        long id = api.pet().addPet().body(new Pet()).execute(validatedWith(shouldBeCode(SC_OK)))
                .jsonPath().getLong("id");

        Pet pet = api.pet().getPetById().petIdPath(id)
                .executeAs(validatedWith(shouldBeCode(SC_OK)));
        assertThat(pet.getId(), equalTo(id));
    }

    @Test
    void shouldSee404WithNotExistId() {
        ModelApiResponse error = api.pet().getPetById().petIdPath(NOT_EXIST_ID)
                .reqSpec(r -> r.addHeader("x-real-ip", "0:0:0:0:0:0:0:1"))
                .execute(validatedWith(shouldBeCode(SC_NOT_FOUND)))
                .as(ModelApiResponse.class);
        assertThat(error.getCode(), equalTo(1));
        assertThat(error.getType(), equalTo("error"));
        assertThat(error.getMessage(), equalTo("Pet not found"));
    }
}
