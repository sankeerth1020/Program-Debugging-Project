package com.example.bookify;

import android.os.Bundle;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

public class product_list extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        GridView gridView = findViewById(R.id.gridview2);

        ProductAdapter productAdapter =new ProductAdapter(this);
        gridView.setAdapter(productAdapter);

    }
}
