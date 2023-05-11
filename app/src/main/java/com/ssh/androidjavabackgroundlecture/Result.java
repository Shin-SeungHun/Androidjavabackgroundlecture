package com.ssh.androidjavabackgroundlecture;

public abstract class Result<T> {
    private Result(){}

    public static final class Sucess<T> extends Result<T> {
        public T data;

        public Sucess(T num) {
        }

        public void Success(T data) { this.data = data;
        }
    }

    public static final class Error<T> extends  Result<T>{
        public Exception exception;

        public Error(Exception exception){this.exception = exception;}
    }

}