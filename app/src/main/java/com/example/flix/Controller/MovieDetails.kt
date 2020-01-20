package com.example.flix.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.flix.Model.Movie
import com.example.flix.R
import com.example.flix.utils.EXTRA_MOVIE_DATA
import kotlinx.android.synthetic.main.activity_movie_details.*


class MovieDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        val movie:Movie = intent.getParcelableExtra(EXTRA_MOVIE_DATA)!!

//        tvDetailOverView.text = movie.overView
//        tvDetailTitle.text = movie.title
//        tvDetailsReleaseDate.text = movie.releaseDate
//        //Glide.with(this).load(movie.posterPath).into(vvTrailer)



    }
}
