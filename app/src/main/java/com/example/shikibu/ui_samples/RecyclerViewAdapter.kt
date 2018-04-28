package com.example.shikibu.ui_samples

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import io.realm.OrderedRealmCollection
import io.realm.RealmRecyclerViewAdapter


internal class RecyclerViewAdapter(data: OrderedRealmCollection<Model>)
    : RealmRecyclerViewAdapter<Model, RecyclerViewAdapter.ViewHolder>(data, true) {

    init {
        setHasStableIds(true)
    }

    override fun getItemId(index: Int): Long {
        return getItem(index)!!.id
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.row_basic_realm_recycler, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.data = item

        holder.title.text = item!!.title
        holder.detail.text = item.detail
    }

//    internal inner class ViewHolder(val binding: FragmentBasicRealmRecyclerBinding) : RecyclerView.ViewHolder(binding.root) {
//        fun bind(item: Item) {
//            binding.item = item
//        }
//    }

    internal inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title: TextView
        var detail: TextView
        var data: Model? = null

        init {
            title = view.findViewById(R.id.row_title)
            detail = view.findViewById(R.id.row_detail)
        }
    }
}
