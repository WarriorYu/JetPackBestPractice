package com.yu.jetpackbestpractice;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;

import com.alibaba.fastjson.JSONObject;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.yu.jetpackbestpractice.utils.NavGraphBuilder;
import com.yu.libnetwork.ApiResponse;
import com.yu.libnetwork.GetRequest;
import com.yu.libnetwork.JsonCallback;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.HashMap;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);

        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        NavController navController = NavHostFragment.findNavController(fragment);

        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                navController.navigate(item.getItemId());
                return !TextUtils.isEmpty(item.getTitle());
            }
        });

        NavGraphBuilder.build(navController, this, fragment.getId());

        GetRequest<JSONObject> request = new GetRequest<>("www.mooc.com");
        request.execute();

        request.execute(new JsonCallback<JSONObject>() {
            @Override
            public void onSuccess(ApiResponse<JSONObject> response) {
                super.onSuccess(response);
            }
        });

    }

}