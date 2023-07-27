package com.example.finalprojectgigih.core.ui
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.example.finalprojectgigih.core.R
//import com.example.finalprojectgigih.core.databinding.ItemAreaBinding
//import com.example.finalprojectgigih.core.domain.model.AreaCode
//
//class AreaCodeAdapter : RecyclerView.Adapter<AreaCodeAdapter.ListViewHolder>() {
//
//    private var listData = ArrayList<AreaCode>()
//    var onItemClick: ((AreaCode) -> Unit)? = null
//
//    fun setData(newListData: List<AreaCode>?) {
//        if (newListData == null) return
//        listData.clear()
//        listData.addAll(newListData)
//        notifyDataSetChanged()
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
//        ListViewHolder(
//            LayoutInflater.from(parent.context).inflate(R.layout.item_area, parent, false)
//        )
//
//    override fun getItemCount() = listData.size
//
//    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
//        val data = listData[position]
//        holder.bindView(data)
//    }
//
//    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//
//        private val binding = ItemAreaBinding.bind(itemView)
//
//        fun bindView(data: AreaCode) {
//            with(binding) {
//                tvArea.text = data.name
//            }
//        }
//
//        init {
//            binding.root.setOnClickListener {
//                onItemClick?.invoke(listData[adapterPosition])
//            }
//        }
//
//    }
//}