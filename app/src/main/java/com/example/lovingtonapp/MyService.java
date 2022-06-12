package com.example.lovingtonapp;

import android.content.Context;

public class MyService {
    ProductApi productApi;

    public MyService(Context context) {
        productApi = RetrofitBuilder
                .builder(context)
                .create(ProductApi.class);
    }

    public ProductApi getInstance() {
        return productApi;
    }
}
