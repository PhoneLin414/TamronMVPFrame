package com.example.tamronmvpframe.network;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Services {

    @GET("movie/now_playing")
    Observable<String> getNowPlayingMovieList(@Query("api_key") String API_KEY, @Query("page") int PAGE);

}
