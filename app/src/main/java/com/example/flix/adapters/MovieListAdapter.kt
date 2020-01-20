package com.example.flix.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.flix.Model.Movie
import com.example.flix.R

class MovieListAdapter(var context: Context, var movieList:List<Movie>, val movieOnClick:(Movie)->Unit): RecyclerView.Adapter<MovieListAdapter.movieVH>() {
    inner class movieVH(itemView: View,val moiveOnClick :(Movie)->Unit) : RecyclerView.ViewHolder(itemView) {

        val posterImg = itemView.findViewById<ImageView>(R.id.ivPoster)
        val titleTxt = itemView.findViewById<TextView>(R.id.tvTitle)
        val overViewTxt = itemView.findViewById<TextView>(R.id.tvOverView)

        fun bindView(movieItem: Movie, context:Context){

            titleTxt.text = movieItem.title
            overViewTxt.text = movieItem.overView
            Glide.with(context).load(movieItem.posterPath).into(posterImg)
            itemView.setOnClickListener{movieOnClick(movieItem)}

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): movieVH {
        val view = LayoutInflater.from(parent.context).inflate(
                R.layout.movie_list_item,parent,false
        )
        return movieVH(view, movieOnClick)
    }

    override fun getItemCount(): Int {
       return movieList.count()
    }

    override fun onBindViewHolder(holder: movieVH, position: Int) {
        holder.bindView(movieList[position], context) //To change body of created functions use File | Settings | File Templates.
    }
}