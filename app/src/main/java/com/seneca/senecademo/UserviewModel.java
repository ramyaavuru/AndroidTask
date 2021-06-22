package com.seneca.senecademo;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.seneca.senecademo.db.Pojo;

import java.util.List;

public class UserviewModel extends AndroidViewModel {

    private UserRepository mRepository;

    private final LiveData<List<Pojo>> mAllWords;
    private  LiveData<List<Pojo>> musers;

    public UserviewModel(@NonNull Application application) {
        super(application);
        mRepository = new UserRepository(application);
        mAllWords = mRepository.getAllWords();
        musers = new MutableLiveData<>();
    }

    MutableLiveData<List<Pojo>> apicall(){
        return mRepository.getDatafromService();
    }

    LiveData<List<Pojo>> getAllWords() { return mAllWords; }

    public boolean isNetworkAvailable(Context context) {
        final ConnectivityManager connectivityManager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }
}
