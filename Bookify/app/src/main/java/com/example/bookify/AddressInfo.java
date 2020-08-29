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


public class AddressInfo extends AppCompatActivity {
    Button next;
    TextInputEditText country, province, street, firstName, lastName, zipcode;
    TextInputLayout countryLayout, provinceLayout, lisenceNumberLayout, firstNameLayout, lastNameLayout, birthDateLayout;
    CheckBox checkBox;

    String namepattern = "[a-zA-Z]+";
    String Licenepattern = "[A-Z0-9]+";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addressinfo);

        next = findViewById(R.id.nextbuttonLicense);

        country = findViewById(R.id.country);
        province = findViewById(R.id.province);
        street = findViewById(R.id.street);
        firstName = findViewById(R.id.firstname);
        lastName = findViewById(R.id.lastname);
        zipcode = findViewById(R.id.zipcode);
        checkBox = findViewById(R.id.checkBoxSaveAddress);

        countryLayout = findViewById(R.id.countryInputLayout);
        provinceLayout = findViewById(R.id.provinceInputLayout);
        lisenceNumberLayout = findViewById(R.id.numberInputLayout);
        firstNameLayout = findViewById(R.id.firstnameInputLayout);
        lastNameLayout = findViewById(R.id.lastnameInputLayout);
        birthDateLayout = findViewById(R.id.birthdateInputLayout);

        country.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (country.getText().toString().matches(namepattern) && s.length() > 0) {
                    countryLayout.setError(null);
                } else {
                    countryLayout.setError("Invalid Country Name");
                }

            }
        });

        province.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (province.getText().toString().matches(namepattern) && s.length() > 0) {
                    provinceLayout.setError(null);
                } else {
                    provinceLayout.setError("Invalid province name");
                }
            }
        });

        zipcode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (zipcode.getText().toString().matches(Licenepattern) && s.length() > 0) {
                    lisenceNumberLayout.setError(null);
                } else {
                    lisenceNumberLayout.setError("Invalid Licence");
                }
            }
        });

        firstName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (firstName.getText().toString().matches(namepattern) && s.length() > 0) {
                    firstNameLayout.setError(null);
                } else {
                    firstNameLayout.setError("Invalid name");
                }
            }
        });

        lastName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (lastName.getText().toString().matches(namepattern) && s.length() > 0) {
                    lastNameLayout.setError(null);
                } else {
                    lastNameLayout.setError("Invalid last name");
                }
            }
        });

        street.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });











        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(country.getText().toString())){
                    countryLayout.setError("Enter Country Name Plz..");
                    countryLayout.requestFocus();
                }
                else if(TextUtils.isEmpty(province.getText().toString())){
                    provinceLayout.setError("Enter Province Name Plz..");
                    provinceLayout.requestFocus();
                }
                else if(TextUtils.isEmpty(zipcode.getText().toString())){
                    lisenceNumberLayout.setError("Enter zip code Plz..");
                    lisenceNumberLayout.requestFocus();
                }
                else if(TextUtils.isEmpty(firstName.getText().toString())){
                    firstName.setError("Enter First Name Plz..");
                    firstName.requestFocus();
                }
                else if(TextUtils.isEmpty(lastName.getText().toString())){
                    lastName.setError("Enter Last Name Plz..");
                    lastName.requestFocus();
                }
                else if(TextUtils.isEmpty(street.getText().toString())){
                   street.setError("Enter street name Plz..");
                    street.requestFocus();
                }
                else {

                    //Intent intent1 = new Intent(getApplicationContext(),SummeryActivity.class);
                    //startActivity(intent1);

                }




            }
        });

    }


    @Override
    public void onStart() {
        super.onStart();




    }


}