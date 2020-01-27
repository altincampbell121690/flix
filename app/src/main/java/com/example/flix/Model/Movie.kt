
package com.example.flix.Model
/*
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import org.parceler.Parcel
import java.util.*


@Parcel
class Movie {
    var backdropPath: String? = null
    var posterPath: String? = null
    var title: String? = null
    var overView: String? = null

    constructor() {}
    constructor(jsonObject: JSONObject) {
        backdropPath = jsonObject.getString("backdrop_path")
        posterPath =   "https://image.tmdb.org/t/p/w342${jsonObject.getString("poster_path")}"
        title = jsonObject.getString("title")
        overView = jsonObject.getString("overview")
    }

    companion object {
        @Throws(JSONException::class)
        fun fromJsonArray(movieJsonArr: JSONArray): List<Movie> {
            val movies: MutableList<Movie> = ArrayList()
            for (i in 0 until movieJsonArr.length()) {
                movies.add(Movie(movieJsonArr.getJSONObject(i)))
            }
            return movies
        }
    }
}

//class Movie internal constructor(jsonObject: JSONObject) {
//    var posterPath: String
//    var title: String
//    var overView: String
//
//    companion object {
//        @Throws(JSONException::class)
//        fun fromJasonArray(movieJsonArray: JSONArray): List<Movie> {
//            val movieList: MutableList<Movie> = ArrayList()
//            for (i in 0 until movieJsonArray.length()) {
//                movieList.add(Movie(movieJsonArray.getJSONObject(i)))
//            }
//            return movieList
//        }
//    }
//
//    init {
//        posterPath = "https://image.tmdb.org/t/p/w342${jsonObject.getString("poster_path")}"
//        title = jsonObject.getString("title")
//        overView = jsonObject.getString("overView")
//    }
//}



*/
/*
data class Movie internal constructor(val jsonObject: JSONObject) : Parcelable {
   // var id: Int = jsonObject.getInt("id")
   var title: String?
    var stars: Double
    var releaseDate: String?
    var overView: String?
    var posterPath:String?

    init {
        Log.d("ALTIN", "I AM CREATED")
       // posterPath = "https://image.tmdb.org/t/p/w342${jsonObject.getString("poster_path")}"
        posterPath = "https://image.tmdb.org/t/p/w342${jsonObject.getString("poster_path")}"
        title = jsonObject.getString("title")
        overView = jsonObject.getString("overview")
        releaseDate = jsonObject.getString("release_date")
        stars = jsonObject.getString("vote_average").toDouble()
    }


    constructor(parcel: Parcel) : this(JSONObject()) {
        posterPath = parcel.readString().toString()
        title = parcel.readString()!!
        overView = parcel.readString()!!
        releaseDate = parcel.readString()!!
        stars = parcel.readDouble()
    }

//    companion object {
//        @Throws(JSONException::class)
//        fun fromJasonArray(movieJsonArray: JSONArray): List<Movie> {
//            val movieList: MutableList<Movie> = ArrayList()
//            for (i in 0 until movieJsonArray.length()) {
//                movieList.add(Movie(movieJsonArray.getJSONObject(i)))
//            }
//            return movieList
//        }
//    }

//    init {
//        posterPath = "https://image.tmdb.org/t/p/w342${jsonObject.getString("poster_path")}"
//        title = jsonObject.getString("title")
//        overView = jsonObject.getString("overview")
//        releaseDate = jsonObject.getString("release_date")
//        stars = jsonObject.getString("vote_average").toDouble()
//    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(posterPath)
        parcel.writeString(title)
        parcel.writeString(overView)
        parcel.writeString(releaseDate)
        parcel.writeDouble(stars)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Movie> {
        override fun createFromParcel(parcel: Parcel): Movie {
            return Movie(parcel)
        }

        override fun newArray(size: Int): Array<Movie?> {
            return arrayOfNulls(size)
        }
        @Throws(JSONException::class)
        fun fromJasonArray(movieJsonArray: JSONArray): List<Movie> {
            val movieList: MutableList<Movie> = ArrayList()
            for (i in 0 until movieJsonArray.length()) {
                movieList.add(Movie(movieJsonArray.getJSONObject(i)))
            }
            return movieList
        }
    }
}
*//*

*/