package com.example.myapplication.Services

import com.example.myapplication.Models.MovieResponse
import retrofit2.http.GET

interface MovieApiInterface {

    @GET("/3/movie/popular?api_key=bbf5a3000e95f1dddf266b5e187d4b21")
    fun getMovieList(): retrofit2.Call<MovieResponse>
}