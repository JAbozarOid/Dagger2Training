package com.example.daggersample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.daggersample.daggersample.DaggerUserComponent;
import com.example.daggersample.daggersample.User;
import com.example.daggersample.daggersample.UserComponent;
import com.example.daggersample.daggersample.UserModule;

public class MainActivity extends AppCompatActivity {

    // برای درخواست وابستگی. هرجا وابستگی داشته باشیم با inject@ این annotation اعلام میکنیم.


    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((App) getApplication()).getComponent().inject(this);

        UserComponent component = DaggerUserComponent.builder().userModule(new UserModule()).build();
        user = component.provideUser();
        Toast.makeText(this, user.getUserContact(), Toast.LENGTH_SHORT).show();
    }
}
