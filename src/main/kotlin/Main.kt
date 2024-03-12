package org.example

fun findLines(text: String, words: String): List<String> {
    val listWords = words.split(",")
    val lines = text.trimIndent().split("\n")
    val result = mutableListOf<String>()

    for ((index, line) in lines.withIndex()) {
        if (listWords.any { word -> line.contains(word, ignoreCase = true) }) {
            result.add("Line ${index + 1}: $line")
        }
    }

    return result
}

fun main() {
    val text = """
        In computer science, big O notation is used to classify algorithms according to how their run time or space requirements grow as the input size grows.
        In analytic number theory, big O notation is often used to express a bound on the difference between an arithmetical function and
        a better understood approximation; a famous example of such a difference is the remainder term in the prime number theorem. 
        Big O notation is also used in many other fields to provide similar estimates.
    """

    listOf(
        "notation",
        "fields",
        "requirements, similar"
    ).forEach { words ->
        val result = findLines(text, words)

        println("Words to find: $words")
        println(result.joinToString("\n"))
        println()
    }
}