package com.example.flix.Controller

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import com.example.flix.Model.MovieJava
//import com.example.flix.Model.Movie
import com.example.flix.R
import com.example.flix.utils.*
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import kotlinx.android.synthetic.main.activity_movie_details.*
import okhttp3.Headers
import org.json.JSONException
import org.parceler.Parcels


class MovieDetails : YouTubeBaseActivity() {
  private val YOUTUBE_API_KEY:String = "AIzaSyCbk7gI8le3S_617MS4Ke475y0tdPMF4ZI"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        val movie: MovieJava = Parcels.unwrap(intent.getParcelableExtra(EXTRA_MOVIE_DATA)!!)
        tvDetailOverView.text = movie.overView
        tvDetailOverView.movementMethod = ScrollingMovementMethod()
        tvDetailTitle.text = movie.title
        tvDetailsReleaseDate.text = "Release Date: ${movie.releaseDate.subSequence(5,7)} / ${movie.releaseDate.subSequence(8,10)} / ${movie.releaseDate.subSequence(0,4)}"
        ratingBar.rating = movie.stars/2
        val VIDEOS_URL = "https://api.themoviedb.org/3/movie/${movie.movieId}/videos?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed"

        val client = AsyncHttpClient()
        client.get(VIDEOS_URL,object : JsonHttpResponseHandler(){
            override fun onSuccess(statusCode: Int, headers: Headers?, json: JSON?) {
                try {
                    val results = json!!.jsonObject.getJSONArray("results")
                    if (results.length() == 0){
                        return
                    }
                    val key = results.getJSONObject(0).getString("key")
                    Log.d("Detial", key)
                    initializeYouTube(key)

                } catch (e: JSONException){
                    Log.d("DETAIL", "JSON ERROR \n$e\n")

                }
                }

            override fun onFailure(statusCode: Int, headers: Headers?, response: String?, throwable: Throwable?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })


        //Glide.with(this).load(movie.posterPath).into(vvTrailer)



    }

//    object youtubePlayer: YouTubePlayer.OnInitializedListener {
//        override fun onInitializationSuccess(provider: YouTubePlayer.Provider?, youTubePlayer: YouTubePlayer?, b: Boolean) {
//           Log.d("DETAIL Activity", "onInitializationSuccess")
//            youTubePlayer!!.cueVideo("fis-9Zqu2Ro");
//        }
//
//        override fun onInitializationFailure(provider: YouTubePlayer.Provider?, youTubePlayer: YouTubeInitializationResult?) {
//            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//        }
//
//    }

    fun initializeYouTube(youtubeKey:String){
        ytpvTrailer.initialize(YOUTUBE_API_KEY, object : YouTubePlayer.OnInitializedListener{
            override fun onInitializationSuccess(provider: YouTubePlayer.Provider?, youTubePlayer: YouTubePlayer?, b: Boolean) {
                Log.d("DETAIL Activity", "onInitializationSuccess")
                youTubePlayer!!.cueVideo(youtubeKey);
            }

            override fun onInitializationFailure(provider: YouTubePlayer.Provider?, youTubePlayer: YouTubeInitializationResult?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })

    }
}
