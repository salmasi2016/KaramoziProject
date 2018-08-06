package com.example.sh.karamoziproject1.retrofit;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIInterface {

    @GET("/users")
    Call<ArrayList<User>> getUser();

    @GET("/posts")
    Call<ArrayList<Post>> getPost(@Query("userId") int userId);
}