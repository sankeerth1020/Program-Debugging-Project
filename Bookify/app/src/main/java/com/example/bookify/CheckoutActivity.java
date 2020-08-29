package com.example.bookify;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class CheckoutActivity extends AppCompatActivity {
    TextInputEditText name,number,dateExpiry,cvv;
    TextInputLayout nameLayout,numberLayout,dateLayout,cvvLayout;
    CheckBox checkBox;
    Button button;
    String exDate;
    String namepattern = "[a-zA-Z]+";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        name = findViewById(R.id.nameOnCard);
        number = findViewById(R.id.cardNumber);
        dateExpiry = findViewById(R.id.expiryDate);
        cvv = findViewById(R.id.cvvNumber);

        nameLayout = findViewById(R.id.nameInputLayout);
        numberLayout = findViewById(R.id.numberInputLayout);
        dateLayout = findViewById(R.id.expiryDateLayout);
        cvvLayout = findViewById(R.id.cvvLayout);

        checkBox = findViewById(R.id.checkBoxSaveCard);
        button = findViewById(R.id.buttonPay);

        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (name.getText().toString().matches(namepattern) && s.length() > 0) {
                    nameLayout.setError(null);
                } else {
                    nameLayout.setError("Invalid Name");
                }

            }
        });
        number.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(number.getText().toString().trim().length() < 16)
                {
                    numberLayout.setError("Invalid card number");
                }

            }
        });
        dateExpiry.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(dateExpiry.getText().toString().trim().length() < 7)
                {
                    dateLayout.setError("Invalid Date");
                }
            }
        });
        cvv.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(cvv.getText().toString().trim().length() < 3)
                {
                    cvvLayout.setError("Invalid CVV");
                }

            }
        });




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(name.getText().toString())) {
                    nameLayout.setError("Enter Name Plz..");
                    nameLayout.requestFocus();
                } else if (TextUtils.isEmpty(number.getText().toString())) {
                    numberLayout.setError("Enter Number Plz..");
                    numberLayout.requestFocus();
                } else if (TextUtils.isEmpty(dateExpiry.getText().toString())) {
                    dateLayout.setError("Enter Date Plz..");
                    dateLayout.requestFocus();
                } else if (TextUtils.isEmpty(cvv.getText().toString())) {
                    cvvLayout.setError("Enter CVV Plz..");
                    cvvLayout.requestFocus();
                } else {


                }
                //Intent intent = new Intent(getApplicationContext(), ETicketActivity.class);
                //intent.putExtra("owner", owner);
               // startActivity(intent);


            }

    });
    }
    @Override
    public void onStart() {
        super.onStart();

                    }





}

