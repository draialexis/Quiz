package fr.iut.pm.data

import fr.iut.pm.R
import fr.iut.pm.model.TrueFalseQuestion

class Stub {
    fun loadQuestions(): Collection<TrueFalseQuestion> {


        return listOf(
            TrueFalseQuestion(R.string.question1, true),
            TrueFalseQuestion(R.string.question2, false),
            TrueFalseQuestion(R.string.question3, true)
        )
    }
}