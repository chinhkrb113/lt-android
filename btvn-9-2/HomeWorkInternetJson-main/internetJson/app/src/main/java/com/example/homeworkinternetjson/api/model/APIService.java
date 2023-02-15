package com.example.homeworkinternetjson.api.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface APIService {
    APIService apiService=new Retrofit.Builder().baseUrl("https://lebavui.github.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIService.class);

    @GET("jsons/users.json?fbclid=IwAR000OhEE2TDAtCuLYO4ZQZKC3XGL-stsy19M9Ig5OYsirfhhpSaGzwYT90")
    Call<List<DataFromAPIItem>> getDataFromAPI();
}
