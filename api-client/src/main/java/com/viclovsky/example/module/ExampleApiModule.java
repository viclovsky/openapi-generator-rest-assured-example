package com.viclovsky.example.module;

import com.google.inject.AbstractModule;
import com.viclovsky.example.provider.ExampleApiProvider;
import com.viclovsky.example.swagger.client.v1.ApiClient;

public class ExampleApiModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(ApiClient.class).toProvider(ExampleApiProvider.class);
    }
}
