package edu.temple.tuh24865.recyclerapp

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.temple.tuh24865.cis3515_pre_hw02_color_activity.R

class NewColorAdapter(_layout: View, _colors: Color, _onClick: (String) -> Unit) : RecyclerView.Adapter<NewColorAdapter.ColorViewHolder>(_layout)  {
    val colors = _colors
    val onclick = _onClick
    class ColorViewHolder(_layout: View) : RecyclerView.ViewHolder (_layout) {
        val colorNameTextView = _layout.findViewById<TextView>(R.id.colorNameTextView)
        val colorPreview = _layout.findViewById<View>(R.id.colorPreviewView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorViewHolder {
        /* this time, we will inflate the existing layout */
        return ColorViewHolder(
            /* root attaches a child, but we let the layout manager do this for us */
            /* fyi: parent is passed to use its theme */
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_display, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ColorViewHolder, position: Int) {
        holder.colorNameTextView.text = colors[position].name
        holder.colorPreview.setBackgroundColor(Color.parseColor(colors[position].code))

        /* color preview will trigger callback */
        holder.colorPreview.setOnClickListener( onclick(colors[position].code) )
        /* now the text label too! */
        holder.colorNameTextView.setOnClickListener( onclick(colors[position].code) )
    }

    override fun getItemCount(): Int {
        return color.size()
    }
}