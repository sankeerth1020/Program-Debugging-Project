package com.example.bookify;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.squareup.picasso.Picasso;

public class product_list extends AppCompatActivity {
    RecyclerView book_list;
    FirebaseFirestore productDB;


    FirestoreRecyclerAdapter<PojoProduct, ProductView> adapterProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        //GridView gridView = findViewById(R.id.gridview2);

        //ProductAdapter productAdapter =new ProductAdapter(this);
        //gridView.setAdapter(productAdapter);
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("SUB_ID", Context.MODE_PRIVATE);
        String idIntent = sharedPreferences.getString("id","").trim();

        book_list = findViewById(R.id.book_List);

        book_list.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

        productDB = FirebaseFirestore.getInstance();

        final Query Cat_query = productDB.collection("products_master");

        FirestoreRecyclerOptions<PojoProduct> Cat_options = new FirestoreRecyclerOptions.Builder<PojoProduct>()
                .setQuery(Cat_query, PojoProduct.class)
                .build();


        adapterProduct = new FirestoreRecyclerAdapter<PojoProduct, ProductView>(Cat_options) {
            @NonNull
            @Override
            public ProductView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_custom,parent,false);
                return new ProductView(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull ProductView holder, int position, @NonNull PojoProduct model) {
                final String id = getSnapshots().getSnapshot(position).getId();

                Picasso.with(getApplicationContext())
                        .load(model.getProduct_image())
                        .into(holder.image_product);
                holder.product_name.setText(model.getProduct_name());
                //  holder.price.setText(model.getProduct_rates());
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent1 = new Intent(getApplicationContext(),ProductDescription.class);
                        intent1.putExtra("id",id);
                        startActivity(intent1);
                    }
                });

            }

        };
        book_list.setAdapter(adapterProduct);
    }
    private class ProductView extends RecyclerView.ViewHolder {

        ImageView image_product;
        TextView product_name,price;

        public ProductView(@NonNull View itemView) {
            super(itemView);
            image_product = itemView.findViewById(R.id.product_image);
            product_name = itemView.findViewById(R.id.txtproduct1);
            price = itemView.findViewById(R.id.txtproductprice);
        }
    }
    @Override
    public void onStart() {
        super.onStart();
        adapterProduct.startListening();
    }

}
