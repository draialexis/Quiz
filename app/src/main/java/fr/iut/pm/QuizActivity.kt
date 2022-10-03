package fr.iut.pm

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import fr.iut.pm.data.Stub
import fr.iut.pm.model.TrueFalseQuestion


class QuizActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        val questions = Stub().loadQuestions(resources)

        val textViewQuestion = findViewById<TextView>(R.id.textViewQuestion)
        val btnNext = findViewById<Button>(R.id.btnNext)
        val btnRestart = findViewById<Button>(R.id.btnRestart)

        var iterator = questions.iterator()
        nextQuestion(textViewQuestion, iterator)

        btnNext.setOnClickListener {
            nextQuestion(textViewQuestion, iterator)
        }

        btnRestart.setOnClickListener {
            iterator = questions.iterator()
            nextQuestion(textViewQuestion, iterator)
        }
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