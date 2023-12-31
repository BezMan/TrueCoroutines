package com.example.truecallercoroutines

object StringFormatter {

    internal fun showNthChar(htmlStr: String, jumpSize: Int): CharSequence {
        return if (jumpSize >= 1 && htmlStr.count() > jumpSize) {
            htmlStr.subSequence(jumpSize - 1, jumpSize)
        } else {
            ""
        }
    }

    internal fun showNthCharsArray(htmlStr: String, jumpSize: Int): CharSequence {
        val chars = htmlStr.toCharArray()
        val result = mutableListOf<Char>()

        val jump = if (jumpSize < 1) 1 else jumpSize

        for (i in (jump - 1) until chars.size step jump) {
            result.add(chars[i])
        }
        return result.toString()
    }

    internal fun showCountPerWord(htmlStr: String): CharSequence {
        if (htmlStr.isBlank()) return ""

        val result = mutableMapOf<String, Int>()
        val words = htmlStr.trim().split("\\s+".toRegex())

        for (word in words) {
            result[word] = result.getOrDefault(word, 0) + 1 //increment each existing word
        }
        return result.toString()

    }

}