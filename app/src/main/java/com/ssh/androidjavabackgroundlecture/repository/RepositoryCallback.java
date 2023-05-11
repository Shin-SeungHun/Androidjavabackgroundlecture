package com.ssh.androidjavabackgroundlecture.repository;

import com.ssh.androidjavabackgroundlecture.Result;
public interface  RepositoryCallback<T>{
    void onComplete(Result<T> result);
}