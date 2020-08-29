package com.example.bookify;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends Fragment implements View.OnClickListener {

    private static View view;
    private static FragmentManager fragmentManager;
    private static EditText emailid, password;
    private static Button loginButton;
    private static TextView forgotPassword, signUp;
    private static CheckBox show_hide_password;
    private static LinearLayout loginLayout;
    private static Animation shakeAnimation;
    private static ProgressDialog loginProgress;
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;

    public LoginActivity() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.activity_login, container, false);
        initViews();
        setListeners();


        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    private void initViews() {
        fragmentManager = getActivity().getSupportFragmentManager();


        emailid = (EditText) view.findViewById(R.id.login_emailid);
        password = (EditText) view.findViewById(R.id.login_password);
        loginButton = (Button) view.findViewById(R.id.loginBtn);
        forgotPassword = (TextView) view.findViewById(R.id.forgot_password);
        signUp = (TextView) view.findViewById(R.id.createAccount);
        show_hide_password = (CheckBox) view.findViewById(R.id.show_show_hide_password);
        loginLayout = (LinearLayout) view.findViewById(R.id.login_layout);
        shakeAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.shake);
        loginProgress = new ProgressDialog(getActivity());
    }

    private void setListeners() {

        loginButton.setOnClickListener(this);
        //forgotPassword.setOnClickListener(this);
        signUp.setOnClickListener(this);

        show_hide_password.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    show_hide_password.setText(R.string.hidepassword);
                    password.setInputType(InputType.TYPE_CLASS_TEXT);
                    password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    show_hide_password.setText(R.string.showpassword);
                    password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_NUMBER_VARIATION_PASSWORD);
                    password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.loginBtn:
                boolean valid = checkValidation();
                if (valid) startLogin();
                break;

            case R.id.createAccount:
                fragmentManager.beginTransaction().setCustomAnimations(R.anim.right_enter, R.anim.left_out)
                        .replace(R.id.frameContainer, new SignUpActivity(), Utils.SignUp_Fragment).commit();
                break;
        }
    }

    private void startLogin() {
        loginProgress.setMessage(String.valueOf(R.string.signing));
        loginProgress.show();
        loginProgress.setCancelable(false);
        loginProgress.setCanceledOnTouchOutside(false);
        String getEmailID = emailid.getText().toString().trim();
        String getPassword = password.getText().toString().trim();


    }

    private boolean checkValidation() {

        String getEmailID = emailid.getText().toString().trim();
        String getPassword = password.getText().toString().trim();

        Pattern p = Pattern.compile(Utils.regEx);
        Matcher m = p.matcher(getEmailID);

        Pattern p1 = Pattern.compile(Utils.passregEx);
        Matcher m1 = p1.matcher(getPassword);

        if (getEmailID.equals("") || getPassword.equals("") || getEmailID.length() == 0 || getPassword.length() == 0) {
            loginLayout.startAnimation(shakeAnimation);
            new CustomToast().ShowToast(getActivity(), view, String.valueOf(R.string.enterboth));
            return false;
        } else if (!m.find()) {
            loginLayout.startAnimation(shakeAnimation);
            new CustomToast().ShowToast(getActivity(), view, String.valueOf(R.string.invalidemail));
            return false;
        } else if (!m1.find()) {
            loginLayout.startAnimation(shakeAnimation);
            new CustomToast().ShowToast(getActivity(), view, String.valueOf(R.string.passwordhint));
            return false;
        } else {
            loginuser();

            return true;
        }

    }

    public void loginuser() {
        db.collection("user")
                .whereEqualTo("email", txtloginemail)
                .whereEqualTo("password", txtloginpassword)
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        if (!queryDocumentSnapshots.isEmpty()) {
                            Toast.makeText(MainActivity.this, "Login Success", Toast.LENGTH_LONG).show();
                            SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();


                            editor.putBoolean(loginyes_no, true);
                            editor.putString(Email_shared, loginemail.getText().toString());

                            editor.commit();
                            getActivity().startActivity(new Intent(getActivity(), MainActivity.class));
                        } else {
                            Toast.makeText(LoginActivity.this, "Email or Password Not correct", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}

