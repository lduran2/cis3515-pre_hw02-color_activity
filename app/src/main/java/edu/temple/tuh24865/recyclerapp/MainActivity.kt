package edu.temple.tuh24865.recyclerapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import edu.temple.tuh24865.cis3515_pre_hw02_color_activity.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val colors = arrayOf(
            ColorObject("Black", "#000000"),
            ColorObject("White", "#FFFFFF"),
            ColorObject("Gray", "#CCCCCC"),
            ColorObject("Red", "#FF00000"),
            ColorObject("Blue", "#0000FF"),
            ColorObject("Green", "#00FF00"),
            ColorObject("Pink", "#DF9FB9"),
            ColorObject("Fuchsia", "#D9027D"),
        )

        val onClick : (String) -> Unit
        onClick = {color:String -> canvas.setBackgroundColor(Color.parseColor(color))}

        /* default to orange */
        onClick("#FFA500")

        recyclerView.adapter = NewColorAdapter(colors)

        recyclerView.layoutManager = GridLayoutManager(this, 2)
    }
}