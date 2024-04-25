package com.non.nonsensemovieapp.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import antonkozyriatskyi.circularprogressindicator.CircularProgressIndicator
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.non.nonsensemovieapp.R
import com.non.nonsensemovieapp.core.Constants
import com.non.nonsensemovieapp.models.Movie

class MovieAdapter(
    private val context: Context,
    var movieList: List<Movie>
) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cvMovie: CardView = itemView.findViewById(R.id.cvMovie)
        val ivPoster: ImageView = itemView.findViewById(R.id.ivPoster)
        val pbIndicator: CircularProgressIndicator = itemView.findViewById(R.id.circular_progress)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_rv_movie, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieAdapter.ViewHolder, position: Int) {
        val movie = movieList[position]

        Glide.with(context)
            .load("${Constants.BASE_URL_IMAGE}${movie.posterPath}")
            .apply(RequestOptions().override(Constants.IMAGE_WIDTH, Constants.IMAGE_HEIGHT))
            .into(holder.ivPoster)

        holder.pbIndicator.maxProgress = Constants.MAX_RATING
        holder.pbIndicator.setCurrentProgress(movie.voteAverage.toDouble())
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}