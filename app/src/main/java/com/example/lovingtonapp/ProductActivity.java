package com.example.lovingtonapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductActivity extends AppCompatActivity {
    MyService myService;
    ProductAdapter adapter;
    RecyclerView rv_product;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        rv_product = findViewById(R.id.rv_product);
        back = findViewById(R.id.btn_back);

        myService = new MyService(this); //instance myservice

        rv_product.setHasFixedSize(true);
        rv_product.setLayoutManager(new LinearLayoutManager(this));

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HomeFragment.class);
                startActivity(intent);
            }
        });

        getDataProduct();
    }
    public void getDataProduct(){
        myService.getInstance().getProduct().enqueue(new Callback<ProductResponse<ProductItem>>() {
            @Override
            public void onResponse(Call<ProductResponse<ProductItem>> call, Response<ProductResponse<ProductItem>> response) {
                ProductResponse resp = response.body();

                if (resp.getData() != null && resp.getData().size() > 0){

                    adapter = new ProductAdapter(resp.getData(),ProductActivity.this);
                    rv_product.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ProductResponse<ProductItem>> call, Throwable t) {
                Toast.makeText(ProductActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }

        });
    }}







