package fr.iut.pm

import android.content.Intent
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
const val QUESTION_INDEX: String = "questionIndex"
const val CHEAT_ANSWER: String = "cheatAnswer"


class QuizActivity : AppCompatActivity() {

    private var questionIndex: Int = 0
    private var cheatAnswer: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.println(Log.INFO, TAG, "Creating...")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        val questions = Stub().loadQuestions(resources)
        val textViewQuestion = findViewById<TextView>(R.id.textViewQuestion)

        if (savedInstanceState != null) {
            with(savedInstanceState) {
                Log.println(Log.WARN, TAG, "LOADING...")
                questionIndex = getInt(QUESTION_INDEX)
                cheatAnswer = getBoolean(CHEAT_ANSWER)
            }
        }

        showQuestion(textViewQuestion, questions)

        findViewById<ImageButton>(R.id.btnNext).setOnClickListener {
            showNextQuestion(textViewQuestion, questions)
        }

        findViewById<Button>(R.id.btnCheat).setOnClickListener {
            val cheatIntent = Intent(this, CheatActivity::class.java)
            cheatIntent.putExtra(CHEAT_ANSWER, cheatAnswer)
            startActivity(cheatIntent)
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
        Log.println(Log.WARN, TAG, "SAVING...")
        outState.run {
            println("saving idx: $questionIndex")
            putInt(QUESTION_INDEX, questionIndex)
            putBoolean(CHEAT_ANSWER, cheatAnswer)
        }
        super.onSaveInstanceState(outState)
    }

    private fun assignAnswerToButton(btn: Button, toast: String) {
        btn.setOnClickListener {
            Toast.makeText(this, toast, Toast.LENGTH_SHORT).show()
        }
    }

    private fun nextIndex(size: Int) {
        if (questionIndex >= size - 1) {
            questionIndex = 0
        } else {
            questionIndex++
        }
    }


    private fun showNextQuestion(textView: TextView, questions: Collection<TrueFalseQuestion>) {
        nextIndex(questions.size)
        showQuestion(textView, questions)
    }

    private fun storeAnswer(answer: Boolean) {
        cheatAnswer = answer
    }

    private fun showQuestion(textView: TextView, questions: Collection<TrueFalseQuestion>) {
        val obj: TrueFalseQuestion = questions.elementAt(questionIndex)

        textView.text = obj.question

        storeAnswer(obj.answer)

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