package com.example.jogodavelha

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    // 0-----X
    // 1-----O
    // 2-----Null
    var st = true
    var activestate = 0
    var gamestate = intArrayOf(2, 2, 2, 2, 2, 2, 2, 2, 2)
    var winstate = arrayOf(
        intArrayOf(0, 1, 2),
        intArrayOf(3, 4, 5),
        intArrayOf(6, 7, 8),
        intArrayOf(0, 3, 6),
        intArrayOf(1, 4, 7),
        intArrayOf(2, 5, 8),
        intArrayOf(0, 4, 8),
        intArrayOf(2, 4, 6)
    )

    fun onTap(view: View) {
        val img = view as ImageView
        val tap = img.tag.toString().toInt()
        if (!st) {
            reset(view)
        }
        if (gamestate[tap] == 2) {
            gamestate[tap] = activestate
            img.translationY = -1000.0f
            val Turn: String
            if (activestate == 0) {
                img.setImageResource(R.drawable.x)
                Turn = "O's turn"
                val status = findViewById<TextView>(R.id.status)
                status.text = Turn
                activestate = 1
            } else {
                img.setImageResource(R.drawable.o)
                Turn = "X's turn"
                val status = findViewById<TextView>(R.id.status)
                status.text = Turn
                activestate = 0
            }
            img.animate().translationYBy(1000f).duration = 300
        }
        for (winPosition in winstate) {
            if (gamestate[winPosition[0]] == gamestate[winPosition[1]] && gamestate[winPosition[1]] == gamestate[winPosition[2]] && gamestate[winPosition[0]] != 2) {
                var winner: String
                st = false
                if (gamestate[winPosition[0]] == 0) {
                    winner = "X has won"
                    val status = findViewById<TextView>(R.id.status)
                    status.text = winner
                } else {
                    winner = "O has won"
                    val status = findViewById<TextView>(R.id.status)
                    status.text = winner
                }
            }
        }
    }

    fun reset(view: View?) {
        st = true
        for (i in gamestate.indices) {
            gamestate[i] = 2
        }
        (findViewById<View>(R.id.imageView1) as ImageView).setImageResource(0)
        (findViewById<View>(R.id.imageView2) as ImageView).setImageResource(0)
        (findViewById<View>(R.id.imageView3) as ImageView).setImageResource(0)
        (findViewById<View>(R.id.imageView4) as ImageView).setImageResource(0)
        (findViewById<View>(R.id.imageView5) as ImageView).setImageResource(0)
        (findViewById<View>(R.id.imageView6) as ImageView).setImageResource(0)
        (findViewById<View>(R.id.imageView7) as ImageView).setImageResource(0)
        (findViewById<View>(R.id.imageView8) as ImageView).setImageResource(0)
        (findViewById<View>(R.id.imageView9) as ImageView).setImageResource(0)
        val Turn: String
        Turn = "X's turn"
        val status = findViewById<TextView>(R.id.status)
        status.text = Turn
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}