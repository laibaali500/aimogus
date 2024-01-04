package com.example.aimogus

class Questions {
    val questionsArray = arrayOf("What do you think of humans?",
        "Where do you see yourself in 5 years?",
        "What is your favourite game and why?",
        "What is global warming?")

    fun getRandomQuestion(): String {
        val rnds = (0..3).random()
        return(questionsArray[rnds])
    }

}