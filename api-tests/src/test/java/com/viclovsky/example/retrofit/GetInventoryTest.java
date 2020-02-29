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

import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

public class GetInventoryTest {

    private ApiClient api;

    @Before
    public void createApi() {
        final OkHttpClient client = new OkHttpClient().newBuilder().build();
        api = new ApiClient();
        Retrofit.Builder builder = new ApiClient().getAdapterBuilder()
                .baseUrl("http://petstore.swagger.io:80/v2/");
        api.setAdapterBuilder(builder).configureFromOkclient(client);
    }

    @Test
    public void shouldGetInventoryTest() throws IOException {
        Response<Map<String, Integer>> inventory =
                api.createService(StoreApi.class).getInventory().execute();
        assertThat(inventory.code(), equalTo(SC_OK));
        assertThat(inventory.body().keySet().size(), greaterThan(0));
    }
}
