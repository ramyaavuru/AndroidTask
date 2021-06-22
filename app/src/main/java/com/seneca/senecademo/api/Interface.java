package com.seneca.senecademo.api;

import com.seneca.senecademo.db.Pojo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Interface {
    @GET("json/inbox.json")
    Call<List<Pojo>> getData();
}
