package com.gigih.awarealert.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gigih.awarealert.core.R
import com.gigih.awarealert.core.databinding.ItemMainBinding
import com.gigih.awarealert.core.domain.model.Report
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

class MainAdapter : RecyclerView.Adapter<MainAdapter.ListViewHolder>() {

    private var listData = ArrayList<Report>()
    var onItemClick: ((Report) -> Unit)? = null

    fun setData(newListData: List<Report>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
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
                if (!data.imageUrl.isNullOrEmpty()) {
                    Picasso.get().load(data.imageUrl).fit()
                        .error(R.drawable.ic_errorimage)
                        .into(itemIvPoster, object : Callback {
                            override fun onSuccess() {
                                itemProgressbar.visibility = View.GONE
                            }

                            override fun onError(e: Exception?) {
                                itemProgressbar.visibility = View.GONE
                            }
                        })
                } else Picasso.get().load(R.drawable.ic_noimage).fit().into(itemIvPoster)

                itemTvDisastertype.text = data.disasterType
                itemTvOverview.text = data.description
                itemTvStatus.text = data.status
                itemTvTime.text = data.createdAt
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }

    }
}