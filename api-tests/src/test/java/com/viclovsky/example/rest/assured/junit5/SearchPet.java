package com.viclovsky.example.rest.assured.junit5;

import com.google.inject.Inject;
import com.viclovsky.example.module.ExampleApiModule;
import com.viclovsky.example.swagger.client.v1.ApiClient;
import name.falgout.jeffrey.testing.junit5.GuiceExtension;
import name.falgout.jeffrey.testing.junit5.IncludeModule;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.viclovsky.example.swagger.client.v1.ResponseSpecBuilders.shouldBeCode;
import static com.viclovsky.example.swagger.client.v1.ResponseSpecBuilders.validatedWith;
import static org.apache.http.HttpStatus.SC_NOT_FOUND;
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
