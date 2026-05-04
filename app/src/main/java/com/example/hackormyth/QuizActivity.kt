package com.example.hackormyth

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView

class QuizActivity : AppCompatActivity() {

    // Questions
    private val hacks = listOf(
        Hack(
            "The night before an exam, you should stay up the whole night to cram everything.",
            isTrue = false,
            "Review main concepts for 30 to 60 minutes, then sleep 7 to 8 hours."
        ),
        Hack(
            "You should start studying for a major exam immidiately after the teacher gives you a study guide.",
            isTrue = true,
            "studying weeks before exams gives you less stress."
        ),
        Hack(
            "loud space with phone around is a best study environment.", isTrue = false,
            "loud space and having a cellphone around is one of the most study distraction"
        )
    )

    private var currentIndex = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        val textquestion = findViewById<TextView>(R.id.textquestion)
        val textfeedback = findViewById<TextView>(R.id.textfeedback)
        val btnhack = findViewById<Button>(R.id.btnhack)
        val btnmyth = findViewById<Button>(R.id.btnmyth)
        val btnnext = findViewById<Button>(R.id.btnnext)

        // Load first question
        loadQuestion(questionView = textquestion, feedbackView = textfeedback)

        btnhack.setOnClickListener {
            checkAnswer(userAnswer = true, feedbackView = textfeedback)
        }

        btnmyth.setOnClickListener {
            checkAnswer(userAnswer = false, feedbackView = textfeedback)
        }

        btnnext.setOnClickListener {
            currentIndex++
            if (currentIndex < hacks.size) {
                loadQuestion(questionView = textquestion, feedbackView = textfeedback)
            } else {
                // go to scoreActivity
                val intent = Intent(this, ScoreActivity::class.java)
                intent.putExtra("score", score)
                intent.putExtra("total", hacks.size)
                startActivity(intent)
                finish()
            }

        }

    }
    private fun loadQuestion(questionView: TextView, feedbackView: TextView){
        questionView.text = hacks[currentIndex].statement
        feedbackView.text = ""
    }
    private fun checkAnswer(userAnswer:Boolean, feedbackView: TextView){
        val correct = hacks[currentIndex].isTrue==userAnswer
        if(correct){
            score++
            feedbackView.text = "correct! ${hacks[currentIndex].explanation}"
        }else{
            feedbackView.text = "wrong! ${hacks[currentIndex].explanation}"
        }
    }
}