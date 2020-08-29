package com.example.bookify;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

/**
 * adapter class
 */
public class ProductAdapter extends BaseAdapter {

    Context context;

    public ProductAdapter(Context context) {
        this.context = context;
    }
    @Override
    public int getCount() {
        return pro_image.length;
    }

    @Override
    public Object getItem(int position) {
        return pro_image[position];
    }

    @Override
    public long getItemId(int position) {
        return pro_image[position];
    }

    /**
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=inflater.inflate(R.layout.product_custom,null);

        CardView cardView = convertView.findViewById(R.id.cardViewproduct_list);
        ImageView product_image = convertView.findViewById(R.id.product_image);
        TextView product_name = convertView.findViewById(R.id.txtproduct1);
        TextView product_rates = convertView.findViewById(R.id.txtproductprice);

        product_image.setImageResource(pro_image[position]);
        product_name.setText(pro_name[position]);
        product_rates.setText(rate[position]);
        final View finalConvertView = convertView;

        cardView.setOnClickListener(new View.OnClickListener() {
            /**
             * @param v
             */
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProductDescription.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                finalConvertView.getContext().startActivity(intent);

            }
        });

        return convertView;
    }

    String rate[]={"7","19","13","23","30","6","25","20","10"};
    String pro_name[]={"I have a dream" , "The 7 habits of highly effective people" , "Tata Ratan His Legacy" , "Half girlfriend" , "Arise, Awake","2 States","Touch the sky","The 3 mistakes of my Life","Ratan tata biography"};
    Integer pro_image[]={R.drawable.book,R.drawable.book1,R.drawable.book6,R.drawable.book9,R.drawable.book2,R.drawable.book8,R.drawable.book3,R.drawable.book7,R.drawable.book5};

}
