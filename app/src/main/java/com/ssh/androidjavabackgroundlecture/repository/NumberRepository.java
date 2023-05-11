package com.ssh.androidjavabackgroundlecture.repository;

import android.os.Handler;

import com.ssh.androidjavabackgroundlecture.Result;

import java.util.concurrent.Executor;

public class NumberRepository {
    private final Executor executor;
    private final Handler resultHandler;

    public NumberRepository(Executor executor, Handler resultHandler) {
        this.executor = executor;
        this.resultHandler = resultHandler;
    }

    public void longTask(final RepositoryCallback<Integer> callback){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    //background
                    int num=0;
                    for(int i=0; i<100; i++){
                        num++;
                        //UI 갱신을 위해서 콜백
                        Result<Integer> result = new Result.Sucess<>(num);
//                   callback.onComplete(result);
                        notifyResult(result, callback);

                    }

                    Thread.sleep(100);
                } catch (Exception e) {
                    Result<Integer> result = new Result.Error<>(e);
                    notifyResult(result, callback);
                }
            }
        });

    }

    private void notifyResult(
            final Result<Integer> result,
            final RepositoryCallback<Integer>callback
    ){
        resultHandler.post(new Runnable() {
            @Override
            public void run() {
                callback.onComplete(result);
            }
        });
    }

}