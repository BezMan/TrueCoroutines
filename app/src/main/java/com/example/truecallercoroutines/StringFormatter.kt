package com.example.truecallercoroutines

object StringFormatter {

    internal fun showNthChar(htmlStr: String, jumpSize: Int): CharSequence {
        return if (htmlStr.count() > jumpSize) {
            htmlStr.subSequence(jumpSize - 1, jumpSize)
        } else {
            ""
        }
    }

    internal fun showNthCharsArray(htmlStr: String, jumpSize: Int): CharSequence {
        return htmlStr.subSequence(0, 20)
    }

    internal fun showCountPerWord(htmlStr: String): CharSequence {
        return htmlStr.subSequence(0, 20)
    }


}