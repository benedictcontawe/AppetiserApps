package com.example.appetiserapps

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

abstract class BaseViewHolder : RecyclerView.ViewHolder {

    companion object {
        private val TAG = BaseViewHolder::class.java.simpleName
    }

    private lateinit var context : Context
    //private val iTunesListener : ITunesListener

    constructor(context : Context, itemView : View) : super(itemView) {
        Log.d(TAG, "constructor")
        this.context = context
    }

    protected fun getContext() : Context = context

    //public fun getContactListener() : ITunesListener = iTunesListener

    protected fun LogDebug(TAG : String, message : String) {
        Log.d(TAG,message)
    }

    protected fun setPhoto(imageView : ImageView, image : String?) {
        Log.d(TAG, "setPhoto $image")
        if (image?.isNotBlank() == true) {
            Glide.with(getContext())
                .asBitmap()
                .placeholder(R.mipmap.ic_launcher)
                .load(image)
                .into(imageView)
        }
    }

    abstract fun bindDataToViewHolder(item : ITunesViewHolderModel, position : Int)
}