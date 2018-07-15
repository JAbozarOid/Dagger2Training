package com.example.daggersample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.example.daggersample.daggersample.DaggerUserComponent;
import com.example.daggersample.daggersample.User;
import com.example.daggersample.daggersample.UserComponent;
import com.example.daggersample.daggersample.UserModule;
import com.example.daggersample.login.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.tv_hello)
    TextView tvHello;

    // برای درخواست وابستگی. هرجا وابستگی داشته باشیم با inject@ این annotation اعلام میکنیم.

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //((App) getApplication()).getComponent().inject(this);

        UserComponent component = DaggerUserComponent.builder().userModule(new UserModule()).build();
        user = component.provideUser();
        Toast.makeText(this, user.getUserContact(), Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.tv_hello)
    public void onViewClicked() {
        startActivity(new Intent(this, LoginActivity.class));
    }
}
