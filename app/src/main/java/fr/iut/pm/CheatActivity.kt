package fr.iut.pm

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

const val HAS_CHEATED: String = "hasCheated"

class CheatActivity : AppCompatActivity() {
    private var cheatAnswer: Boolean = false
    private var hasCheated: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cheat_activity)

        with(intent)
        {
            cheatAnswer = getBooleanExtra(CHEAT_ANSWER, false)
        }

        findViewById<Button>(R.id.btnCheat).setOnClickListener {
            findViewById<TextView>(R.id.textViewAnswerCheat).text = cheatAnswer.toString()
            hasCheated = true
            prepareOutIntent()
        }
    }

    private fun prepareOutIntent() {
        val outIntent: Intent = Intent().apply { putExtra(HAS_CHEATED, hasCheated) }
        setResult(Activity.RESULT_OK, outIntent)
    }
}