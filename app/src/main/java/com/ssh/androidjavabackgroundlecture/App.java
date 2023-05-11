package com.ssh.androidjavabackgroundlecture;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.core.os.HandlerCompat;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App extends Application {
    private  static int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();

    // 앱 안에 백그라운드 스레드 만들기 위해
    ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_CORES);

    Handler mainThreadHandler = HandlerCompat.createAsync(Looper.getMainLooper());
}