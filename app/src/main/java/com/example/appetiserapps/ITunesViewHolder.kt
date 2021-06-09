package com.example.appetiserapps

import android.content.Context
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView

public class ITunesViewHolder : BaseViewHolder {

    companion object {
        private val TAG = ITunesViewHolder::class.java.getSimpleName()
    }
    //region media_cell
    private val avatar : AppCompatImageView
    private val name : AppCompatTextView
    private val genre : AppCompatTextView
    private val price : AppCompatTextView
    //endregion
    constructor(context : Context, itemView : View) : super(context, itemView) { LogDebug(TAG, "constructor")
        avatar = itemView.findViewById<AppCompatImageView>(R.id.avatar)
        name = itemView.findViewById<AppCompatTextView>(R.id.name)
        genre = itemView.findViewById<AppCompatTextView>(R.id.genre)
        price = itemView.findViewById<AppCompatTextView>(R.id.price)
    }

    override fun bindDataToViewHolder(item : ITunesViewHolderModel, position : Int) {
        setPhoto(avatar, item.artWork)
        name.setText(item.name)
        genre.setText(item.genre)
        price.setText(item.price)
    }
}
