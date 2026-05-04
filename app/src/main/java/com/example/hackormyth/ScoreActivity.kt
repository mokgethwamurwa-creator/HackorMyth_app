package com.example.hackormyth
import android.widget.TextView
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
class ScoreActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        val score = intent.getIntExtra("score",0)
        val total = intent.getIntExtra("total",0)

        val textscore = findViewById<TextView>(R.id.textscore)
        val textmessage =findViewById<TextView>(R.id.textmessage)

        textscore.text = "You scored $score out of $total"

        textmessage.text = if(score > total / 2){
            "You are Brilliant!"
        }else {
            "Stay safe online!"
        }
    }
}