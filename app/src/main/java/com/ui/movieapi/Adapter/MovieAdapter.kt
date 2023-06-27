package com.ui.movieapi.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.ui.movieapi.Model.Episode
import com.ui.movieapi.Model.ResponseData
import com.ui.movieapi.R

class MovieAdapter(private val item: List<Episode>) : RecyclerView.Adapter<UpdatedViewHolder>() {

    private var onclickListener: OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpdatedViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.episode_list, parent, false)

        return UpdatedViewHolder(view)

    }

    override fun onBindViewHolder(holder: UpdatedViewHolder, position: Int) {
        val currentPosition = item[position]
        holder.title.text = currentPosition.Title
        holder.eposide.text = currentPosition.Episode
        holder.rating.text = currentPosition.imdbRating
        holder.id.text = currentPosition.imdbID

        holder.itemView.setOnClickListener {
            if (onclickListener != null) {
                onclickListener!!.onClick(position)
            }
        }

    }

    override fun getItemCount(): Int {
        return item.size
    }

    fun setOnClickListener(onclickListener: OnClickListener) {
        this.onclickListener = onclickListener
    }

    interface OnClickListener {
        fun onClick(position: Int)
    }
}

class UpdatedViewHolder(itemView: View) : ViewHolder(itemView) {

    val title: TextView = itemView.findViewById(R.id.tv_title2)
    val eposide: TextView = itemView.findViewById(R.id.tv_eposide2)
    val rating: TextView = itemView.findViewById(R.id.tv_imdbRating)
    val id: TextView = itemView.findViewById(R.id.tv_imdbID)
}


