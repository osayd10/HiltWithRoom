package com.example.roomwordssample.wordrecyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomwordssample.R
import com.example.roomwordssample.data.Word


class WordListAdapter internal constructor(context: Context?) :
    RecyclerView.Adapter<WordListAdapter.WordViewHolder>() {
    private val mInflater: LayoutInflater = LayoutInflater.from(context)

    private var mWords
            : List<Word>? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WordViewHolder {
        val itemView: View = mInflater.inflate(R.layout.recyclerview_item, parent, false)
        return WordViewHolder(itemView)
    }

    override fun onBindViewHolder(
        holder: WordViewHolder,
        position: Int
    ) {
        if (mWords != null) {
            val (word) = mWords!![position]
            holder.wordItemView.text = word
        } else {
            holder.wordItemView.setText(R.string.no_word)
        }
    }

    fun setWords(words: List<Word>?) {
        mWords = words
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return if (mWords != null) mWords!!.size else 0
    }

    inner class WordViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val wordItemView: TextView = itemView.findViewById(R.id.wordTextView)
    }
}
