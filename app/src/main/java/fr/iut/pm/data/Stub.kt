package fr.iut.pm.data

import android.content.res.Resources
import fr.iut.pm.R
import fr.iut.pm.model.TrueFalseQuestion

class Stub {
    fun loadQuestions(resources: Resources): Collection<TrueFalseQuestion> {
        return listOf(
            TrueFalseQuestion(resources.getString(R.string.question1), true),
            TrueFalseQuestion(resources.getString(R.string.question2), false),
            TrueFalseQuestion(resources.getString(R.string.question3), true),
        )
    }
}