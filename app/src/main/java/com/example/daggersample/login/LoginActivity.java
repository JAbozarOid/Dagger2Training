package com.example.daggersample.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.Toast;

import com.example.daggersample.R;
import com.example.daggersample.root.App;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class LoginActivity extends AppCompatActivity implements LoginActivityMVP.View {


    @BindView(R.id.edt_firstname)
    AppCompatEditText edtFirstname;
    @BindView(R.id.edt_lastname)
    AppCompatEditText edtLastname;
    @BindView(R.id.btn_login)
    AppCompatButton btnLogin;

    private Unbinder unbinder;

    @Inject
    public LoginActivityMVP.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        ((App) getApplication()).getComponent().inject(this);

        unbinder = ButterKnife.bind(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.loginButtonClicked();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
        presenter.getCurrentUser();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }


    @Override
    public String getFirstName() {
        return edtFirstname.getText().toString();
    }

    @Override
    public String getLastName() {
        return edtLastname.getText().toString();
    }

    @Override
    public void showUserNotAvailable() {
        Toast.makeText(this, "Error user not available", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showInputErro() {
        Toast.makeText(this, "FirstName or LastName can not be empty", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showUserSavedMessage() {
        Toast.makeText(this, "User Saved", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setFirstName(String fname) {
        edtFirstname.setText(fname);
    }

    @Override
    public void setLastName(String lname) {
        edtLastname.setText(lname);
    }
}
