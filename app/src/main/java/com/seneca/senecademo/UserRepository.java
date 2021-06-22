package com.seneca.senecademo;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.seneca.senecademo.api.Interface;
import com.seneca.senecademo.db.Pojo;
import com.seneca.senecademo.db.PojoDao;
import com.seneca.senecademo.db.UserDataBase;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserRepository {

    private PojoDao mWordDao;
    private LiveData<List<Pojo>> mAllWords;
    Application context;
    public UserRepository(Application application) {
        UserDataBase db = UserDataBase.getDatabase(application);
        mWordDao = db.words();
        mAllWords = mWordDao.getUserData();
        context=application;
    }

    public LiveData<List<Pojo>> getAllWords() {
        return mAllWords;
    }

    void insert(Pojo word) {
        UserDataBase.databaseWriteExecutor.execute(() -> {
            mWordDao.insert(word);
        });
    }

    public MutableLiveData<List<Pojo>> getDatafromService() {

        MutableLiveData<List<Pojo>> data = new MutableLiveData<>();

        Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.androidhive.info/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            Interface Interface = retrofit.create(Interface.class);

            Call<List<Pojo>> receivestock = Interface.getData();
            receivestock.enqueue(new Callback<List<Pojo>>() {
                @Override
                public void onResponse(Call<List<Pojo>> call, Response<List<Pojo>> response) {
                    if(response.body()!=null) {

                        List<Pojo> pojosLIST = response.body();
                        for(int i=0;i<pojosLIST.size();i++){
                            insert(pojosLIST.get(i));
                        }
                        data.postValue(pojosLIST);

                    }
                }

                @Override
                public void onFailure(Call<List<Pojo>> call, Throwable t) {
                    Toast.makeText(context,t.getLocalizedMessage().toString(),Toast.LENGTH_LONG).show();
                }
            });

     return data;
    }

}