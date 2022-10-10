package fr.iut.pm

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CheatActivity : AppCompatActivity() {
    private var cheatAnswer: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cheat_activity)

        with(intent)
        {
            cheatAnswer = getBooleanExtra(CHEAT_ANSWER, false)
        }

        findViewById<Button>(R.id.btnCheat).setOnClickListener {
            findViewById<TextView>(R.id.textViewAnswerCheat).text = cheatAnswer.toString()
        }
    }
}