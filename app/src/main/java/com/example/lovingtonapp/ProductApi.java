package com.example.lovingtonapp;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductApi {

    @GET("getDataProduct.json")
    Call<ProductResponse<ProductItem>> getProduct();
}
