package com.ssh.androidjavabackgroundlecture;

import android.app.Application;
import android.os.Handler;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import com.ssh.androidjavabackgroundlecture.repository.NumberRepository;
import com.ssh.androidjavabackgroundlecture.repository.RepositoryCallback;

import java.util.concurrent.Executor;

public class MainViewModel extends AndroidViewModel {
    private final NumberRepository repository;

    public MainViewModel(@NonNull Application application) {
        super(application);

        repository = new NumberRepository(
                (Executor) ((App) application).mainThreadHandler,
                (Handler) ((App) application).executorService
        );
    }


    public void longTask(RepositoryCallback<Integer> callback){
        repository.longTask(callback);
    }
}