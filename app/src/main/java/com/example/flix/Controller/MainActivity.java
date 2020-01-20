package com.example.flix.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.example.flix.Model.Movie;
import com.example.flix.R;
import com.example.flix.adapters.MovieListAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import kotlin.Unit;
import okhttp3.Headers;

import static com.example.flix.utils.ConstantsKt.EXTRA_MOVIE_DATA;
import static com.example.flix.utils.ConstantsKt.NOW_PLAYING_URL;

//import static com.example.flix.Utilities.ConstantsKt.NOW_PLAYING_URL;


public class MainActivity extends AppCompatActivity {

    public static final String TAG = "ALTIN main";
    List<Movie> movies;

//    private static Unit invoke(Movie movie) {
//        Log.d("ALTIN", movie.getTitle() + " has BEEN CLICKED");
//        Intent detailActivity = new Intent(getApplicationContext(),MovieDetails.class);
//        return null;
//    }
    // RecyclerView movieRV = findViewById(R.id.rvMovieLIst);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     //   MovieListAdapter movieListAdapter  =  new MovieListAdapter(this,movies);
       // movieRV.setAdapter(movieListAdapter);
        RecyclerView movieRV = findViewById(R.id.rvMovieLIst);
        movies = new ArrayList<>();
        final  MovieListAdapter movieListAdapter  =  new MovieListAdapter(this,movies, (Movie movie)->{
            Log.d("ALTIN", movie.getTitle() + " has BEEN CLICKED");
           Intent detailActivity = new Intent(this,MovieDetails.class);
           detailActivity.putExtra(EXTRA_MOVIE_DATA,movie); // this didnt work .. not sure why tried in java and kotlin
          // startActivity(detailActivity);
            return null;
        });
        // set a layout manager
        movieRV.setAdapter(movieListAdapter);
        movieRV.setLayoutManager( new LinearLayoutManager(this));
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(NOW_PLAYING_URL, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Headers headers, JSON json) {
                Log.d(TAG, "onSuccess");
                JSONObject jsonObject = json.jsonObject;
                try {
                    JSONArray result = jsonObject.getJSONArray("results");
                   // movies = Movie.Companion.fromJasonArray(result);
                        movies.addAll(Movie.CREATOR.fromJasonArray(result));
                        movieListAdapter.notifyDataSetChanged();
                    Log.d(TAG, "Successful");


                } catch (JSONException e) {
                    Log.d(TAG, "UNSuccessful JSON ARR");
                    Log.d(TAG, e.toString());
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {
                Log.d(TAG, "onFAIL");

            }
        });


    }
}
