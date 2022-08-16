package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.Models.Movie
import com.example.myapplication.Models.MovieResponse
import com.example.myapplication.Services.MovieApiInterface
import com.example.myapplication.Services.MovieApiService
import kotlinx.android.synthetic.main.activity_movie.*
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MovieActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        rv_movie.layoutManager =LinearLayoutManager(this)
        rv_movie.setHasFixedSize(true)
        getMovieData {movies : List<Movie> ->
            rv_movie.adapter = MovieAdapter(movies)
        }
    }

    private fun getMovieData(callback:(List<Movie>)->Unit) {
    val apiService = MovieApiService.getInstance().create(MovieApiInterface::class.java)
                apiService.getMovieList().enqueue(object : retrofit2.Callback<MovieResponse> {
                    override fun onFailure(call: Call<MovieResponse>, t: Throwable) {

                    }

                    override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                        return callback(response.body()!!.movies)
                    }

                })
            }
        }
