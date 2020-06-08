package com.viclovsky.example.swagger.client.restassured.module;

import com.google.inject.AbstractModule;
import com.viclovsky.example.swagger.client.restassured.provider.ExampleApiProvider;
import com.viclovsky.example.swagger.client.restassured.ApiClient;

public class ExampleApiModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(ApiClient.class).toProvider(ExampleApiProvider.class);
    }
}
