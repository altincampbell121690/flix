package com.example.flix.Model;

import com.facebook.stetho.inspector.jsonrpc.JsonRpcException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class MovieJava {
    String backdropPath;
    String posterPath;
    String title;
    String overView;
    float stars;
    String releaseDate;
    int movieId;

    public MovieJava(){
    }

    public MovieJava(JSONObject jsonObject) throws JSONException {
        backdropPath = jsonObject.getString("backdrop_path");
        posterPath= "https://image.tmdb.org/t/p/w342" + jsonObject.getString("poster_path");
        title = jsonObject.getString("title");
        overView = jsonObject.getString("overview");
        stars = Float.valueOf(jsonObject.getString("vote_average"));
        releaseDate = jsonObject.getString("release_date");
        movieId = Integer.valueOf(jsonObject.getString("id"));
    }

    public static List<MovieJava> fromJsonArray(JSONArray movieJsonArr) throws JSONException{
        List<MovieJava> movies = new ArrayList<>();
        for (int i = 0; i < movieJsonArr.length(); i++){
            movies.add(new MovieJava(movieJsonArr.getJSONObject(i)));
        }
        return movies;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getTitle() {
        return title;
    }

    public String getOverView() {
        return overView;
    }

    public Float getStars() {
        return stars;
    }

    public Integer getMovieId() {
        return movieId;
    }
    public String getReleaseDate() {
        return releaseDate;
    }
}
