package com.viclovsky.example.retrofit;

import com.viclovsky.example.swagger.client.v2.ApiClient;
import com.viclovsky.example.swagger.client.v2.api.PetApi;
import com.viclovsky.example.swagger.client.v2.api.StoreApi;
import okhttp3.OkHttpClient;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class SearchPet {

    private ApiClient api;

    @Before
    public void createApi() {
        final OkHttpClient client = new OkHttpClient().newBuilder().build();
        api = new ApiClient();
        Retrofit.Builder builder = new ApiClient().getAdapterBuilder()
                .baseUrl("http://petstore.swagger.io:80/v2/");
        api.setAdapterBuilder(builder);
        api.configureFromOkclient(client);
    }


    @Test
    @Ignore("Only for demonstration")
    public void shouldSearchPet() throws IOException {
        Response res = api.createService(PetApi.class)
                .getPetSearch("ok", null, null, null, null,
                        null, null, null, null, null,
                        null, null, null, null, null, null, null,
                        null, null).execute();
        assertThat(res.code(), equalTo(SC_OK));
    }
}
