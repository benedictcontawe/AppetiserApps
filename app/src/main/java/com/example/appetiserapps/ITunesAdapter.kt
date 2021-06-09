package com.example.appetiserapps

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

public class ITunesAdapter : RecyclerView.Adapter<BaseViewHolder> {

    companion object {
        private val TAG = ITunesAdapter::class.java.getSimpleName()
    }

    private val list : MutableList<ITunesViewHolderModel> = mutableListOf<ITunesViewHolderModel>()

    constructor() : super() { Log.d(TAG,"constructor")
        setHasStableIds(false)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : BaseViewHolder {
        val layoutInflater : LayoutInflater = LayoutInflater.from(parent.getContext())
        val view : View = layoutInflater.inflate(R.layout.media_cell, parent, false)
        return ITunesViewHolder(parent.context, view)
    }

    override fun onBindViewHolder(holder : BaseViewHolder, position: Int) {
        holder.bindDataToViewHolder(list[position], position)
    }

    override fun getItemCount() : Int {
        return list.size
    }

    public fun setItems(items : List<ITunesViewHolderModel>) {
        list.clear()
        list.addAll(items)
        notifyDataSetChanged()
    }
}