package fr.iut.pm

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import fr.iut.pm.data.Stub
import fr.iut.pm.model.TrueFalseQuestion

const val TAG = "MyQuizActivity"


class QuizActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.println(Log.INFO, TAG, "Creating...")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        val questions = Stub().loadQuestions(resources)

        val textViewQuestion = findViewById<TextView>(R.id.textViewQuestion)

        var iterator = questions.iterator()
        nextQuestion(textViewQuestion, iterator)

        findViewById<ImageButton>(R.id.btnNext).setOnClickListener {
            nextQuestion(textViewQuestion, iterator)
        }

        findViewById<Button>(R.id.btnRestart).setOnClickListener {
            iterator = questions.iterator()
            nextQuestion(textViewQuestion, iterator)
        }
    }

    override fun onStart() {
        Log.println(Log.INFO, TAG, "Starting...")
        super.onStart()
    }

    override fun onResume() {
        Log.println(Log.INFO, TAG, "Resuming...")
        super.onResume()
    }

    override fun onPause() {
        Log.println(Log.INFO, TAG, "Pausing...")
        super.onPause()
    }

    override fun onStop() {
        Log.println(Log.INFO, TAG, "Stopping...")
        super.onStop()
    }

    override fun onDestroy() {
        Log.println(Log.INFO, TAG, "Destroying...")
        super.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        // Save the user's current game state
        Log.println(Log.INFO, TAG, "SAVING?...")
        outState.run {
//            putInt(myVar, savedVar)
        }

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(outState)
    }


    private fun assignAnswerToButton(btn: Button, toast: String) {
        btn.setOnClickListener {
            Toast.makeText(this, toast, Toast.LENGTH_SHORT).show()
        }
    }

    private fun nextQuestion(textView: TextView, iterator: Iterator<TrueFalseQuestion>) {
        if (iterator.hasNext()) {

            val obj: TrueFalseQuestion = iterator.next()
            textView.text = obj.question

            val correct: Button
            val wrong: Button

            if (obj.answer) {
                correct = findViewById(R.id.btnTrue)
                wrong = findViewById(R.id.btnFalse)
            } else {
                correct = findViewById(R.id.btnFalse)
                wrong = findViewById(R.id.btnTrue)
            }
            assignAnswerToButton(
                correct,
                resources.getString(R.string.correct_answer)
            )
            assignAnswerToButton(
                wrong,
                resources.getString(R.string.wrong_answer)
            )
        }
    }
}