package com.viclovsky.example.oas.client.restassured.module;

import com.google.inject.AbstractModule;
import com.viclovsky.example.oas.client.restassured.ApiClient;
import com.viclovsky.example.oas.client.restassured.provider.ExampleApiProvider;

public class ExampleApiModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(ApiClient.class).toProvider(ExampleApiProvider.class);
    }
}
