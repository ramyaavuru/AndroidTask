package com.seneca.senecademo;

import android.content.Context;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.seneca.senecademo.db.Pojo;

import java.util.ArrayList;

public class Mainactivity2 extends AppCompatActivity {
    DataAdapter Adapter;
    RecyclerView recyclerView;
    Context context;
    private UserviewModel mWordViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        mWordViewModel = new ViewModelProvider(this).get(UserviewModel.class);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        recyclerView = findViewById(R.id.recylclerview);
        context = this;

        mWordViewModel.getAllWords().observe(this, words -> {
            if(!mWordViewModel.isNetworkAvailable(context)) {
                Adapter = new DataAdapter(this, (ArrayList<Pojo>) words);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setAdapter(Adapter);
            }

        });
        mWordViewModel.apicall().observe(this,pojos ->{
            if(mWordViewModel.isNetworkAvailable(context)) {
                Adapter = new DataAdapter(this, (ArrayList<Pojo>) pojos);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setAdapter(Adapter);
            }else {
                Log.e("network","Network not available");
            }
        });
    }





}
