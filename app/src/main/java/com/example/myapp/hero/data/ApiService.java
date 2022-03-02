package com.example.myapp.hero.data;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("/quiz.json")
   Call <ResponsedApi> getResponse ();
}
