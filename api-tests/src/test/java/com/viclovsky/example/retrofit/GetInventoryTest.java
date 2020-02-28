package com.viclovsky.example.retrofit;

import com.viclovsky.example.swagger.client.v2.ApiClient;
import com.viclovsky.example.swagger.client.v2.api.StoreApi;
import okhttp3.OkHttpClient;
import org.junit.Before;
import org.junit.Test;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

public class GetInventoryTest {

    private ApiClient api;

    @Before
    public void createApi() {

        final OkHttpClient client = new OkHttpClient().newBuilder().build();
        api = new ApiClient();
        Retrofit.Builder builder = new ApiClient().getAdapterBuilder().baseUrl("http://petstore.swagger.io:80/v2/");
        api.setAdapterBuilder(builder);
        api.configureFromOkclient(client);
        api.createService(StoreApi.class);
    }

    @Test
    public void shouldGetInventoryTest() throws IOException {
        StoreApi storeApi = api.createService(StoreApi.class);
        Response<Map<String, Integer>> inventory = storeApi.getInventory().execute();
        assertThat(inventory.body().keySet().size(), greaterThan(0));
    }

}
