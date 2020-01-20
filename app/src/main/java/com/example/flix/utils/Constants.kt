package com.example.flix.utils

import org.json.JSONArray
import org.json.JSONObject

const val NOW_PLAYING_URL: String = "https://api.themoviedb.org/3/movie/now_playing?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed"

const val EXTRA_MOVIE_DATA: String = "movie"
lateinit var RESULT: JSONArray
lateinit var  JSONOBJECT : JSONObject