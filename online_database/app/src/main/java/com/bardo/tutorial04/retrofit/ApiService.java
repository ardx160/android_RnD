package com.bardo.tutorial04.retrofit;

import com.bardo.tutorial04.model.ResponseMovie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("movie/popular")
    Call<ResponseMovie> ambilDataMovie(
            @Query("api_key") String apikey
    );

}
