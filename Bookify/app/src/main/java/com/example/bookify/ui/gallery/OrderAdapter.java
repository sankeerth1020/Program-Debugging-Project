package com.example.bookify.ui.gallery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class OrderAdapter extends BaseAdapter {

    Context context;

    public OrderAdapter(Context context) {
        this.context = context;
    }


    @Override
    public int getCount() {
        return pro_image.length;
    }

    @Override
    public Object getItem(int position) {
        return pro_image.length;
    }

    @Override
    public long getItemId(int position) {
        return pro_image.length;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.order_custom, null);

        ImageView product_image = convertView.findViewById(R.id.cart_image);
        TextView product_name = convertView.findViewById(R.id.cartproductname);
        TextView product_rates = convertView.findViewById(R.id.cartproductrate);
        TextView product_quantity = convertView.findViewById(R.id.cartproductqty);


        product_image.setImageResource(pro_image[position]);
        product_name.setText(pro_name[position]);
        product_rates.setText(rate[position]);
        product_quantity.setText(qty[position]);

        return convertView;

    }
    String rate[]={"7","19","13"};
    String qty[]={"2","1","10"};

    String pro_name[]={"I have a dream" , "The 7 habits of highly effective people" , "Tata Ratan His Legacy"};

    Integer pro_image[]={R.drawable.book,R.drawable.book1,R.drawable.book6};
}