package com.example.flix.Model

/*
import android.os.Parcel
import android.os.Parcelable
import org.json.JSONArray
import org.json.JSONObject
import java.util.ArrayList

class MovieDetail(jsonObject: JSONObject) : Parcelable {
    val id: Int = jsonObject.getInt("id")
    val title: String = jsonObject.getString("title")
    val stars: Double = jsonObject.getString("vote_average").toDouble()
    val releaseDate: String = jsonObject.getString("release_date")
    val overView: String = jsonObject.getString("overview")
    val posterPath:String = "https://image.tmdb.org/t/p/w342${jsonObject.getString("poster_path")}"

    constructor(parcel: Parcel) : this(JSONObject()) {
    }


    fun fromJasonArray(movieJsonArray: JSONArray): List<Movie> {
        val movieList: MutableList<Movie> = ArrayList()
        for (i in 0 until movieJsonArray.length()) {
            movieList.add(Movie(movieJsonArray.getJSONObject(i)))
        }
        return movieList
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MovieDetail> {
        override fun createFromParcel(parcel: Parcel): MovieDetail {
            return MovieDetail(parcel)
        }

        override fun newArray(size: Int): Array<MovieDetail?> {
            return arrayOfNulls(size)
        }
    }
}*/
