package com.example.finalprojectgigih.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.finalprojectgigih.core.R
import com.example.finalprojectgigih.core.databinding.ItemMainBinding
import com.example.finalprojectgigih.core.domain.model.Report
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.util.ArrayList

class MainAdapter: RecyclerView.Adapter<MainAdapter.ListViewHolder>() {

    private var listData = ArrayList<Report>()
    var onItemClick: ((Report) -> Unit)? = null

    fun setData(newListData: List<Report>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
//        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_main, parent, false)
        )

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bindView(data)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = ItemMainBinding.bind(itemView)

        fun bindView(data: Report) {
            with(binding) {
//                Picasso.get().load(IMAGE_URL + data.posterPath).fit()
//                    .error(R.drawable.ic_errorimage)
//                    .into(itemMovieIvPoster, object : Callback {
//                        override fun onSuccess() {
//                            itemMovieProgressbar.visibility = View.GONE
//                        }
//
//                        override fun onError(e: Exception?) {
//                            itemMovieProgressbar.visibility = View.GONE
//                        }
//                    })
                itemMovieTvTitle.text = data.reportId
//                itemMovieTvVoteaverage.text = data.voteAverage
//                itemMovieTvPopularity.text = data.popularity
//                itemMovieTvOverview.text = data.overview
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }

    }

    companion object {
        private const val IMAGE_URL = "https://image.tmdb.org/t/p/original"
    }

}