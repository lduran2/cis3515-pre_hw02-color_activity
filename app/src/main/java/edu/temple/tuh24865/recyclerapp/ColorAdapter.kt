package edu.temple.tu24865.recyclerapp

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ColorAdapter (_colors: Array<ColorObject>): RecyclerView.Adapter<ColorAdapter.ColorViewHolder>(){

    val colors = _colors

    class ColorViewHolder(_textView: TextView) : RecyclerView.ViewHolder (_textView) {
        val textView = _textView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorViewHolder {
        return ColorViewHolder(
            TextView(parent.context)
        )
    }

    override fun onBindViewHolder(holder: ColorViewHolder, position: Int) {
        holder.textView.text = colors[position].name
        holder.textView.setBackgroundColor(Color.parseColor(colors[position].code))
    }

    override fun getItemCount(): Int {
        return colors.size
    }

}