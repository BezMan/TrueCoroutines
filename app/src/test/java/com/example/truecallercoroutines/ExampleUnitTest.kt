package com.example.truecallercoroutines

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@OptIn(ExperimentalCoroutinesApi::class)
class ExampleUnitTest {

    @Test
    fun testFetchHtml() {
        runTest {
            // Arrange
            val url = Constants.endpointUrl
            // Act
            val response = NetworkUtils().fetchHtml(url)
            // Assert
            assertTrue(response.isNotBlank())
        }
    }


    @Test
    fun testGetNthLetter() {
        assertEquals(
            "c",
            StringFormatter.showNthChar("abcdefghijklmnopqrstuvwxyz", 3)
        )
        assertEquals(
            "o",
            StringFormatter.showNthChar("abcdefghijklmnopqrstuvwxyz", 15)
        )
    }

    @Test
    fun testGetNthLetterJumpSizeSmallerThanOne() {
        assertEquals("", StringFormatter.showNthChar("abcdefghijklmnopqrstuvwxyz", 0))
        assertEquals("", StringFormatter.showNthChar("abcdefghijklmnopqrstuvwxyz", -1))
    }


    @Test
    fun testGetNthLetterFromEmptyString() {
        assertEquals("", StringFormatter.showNthChar("", 15))
    }

    @Test
    fun testGetNthLetterFromStringWithLessThan15Characters() {
        assertEquals("", StringFormatter.showNthChar("abcde", 15))
    }


    @Test
    fun testGetNthLettersArray() {
        assertEquals(
            "[a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z]",
            StringFormatter.showNthCharsArray("abcdefghijklmnopqrstuvwxyz", -1)
        )
        assertEquals(
            "[a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z]",
            StringFormatter.showNthCharsArray("abcdefghijklmnopqrstuvwxyz", 1)
        )
        assertEquals(
            "[b, d, f, h, j, l, n, p, r, t, v, x, z]",
            StringFormatter.showNthCharsArray("abcdefghijklmnopqrstuvwxyz", 2)
        )
        assertEquals("[o]", StringFormatter.showNthCharsArray("abcdefghijklmnopqrstuvwxyz", 15))
    }

    @Test
    fun testGetNthLettersArrayJumpSizeSmallerThanOne() {
        assertEquals(
            "[a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z]",
            StringFormatter.showNthCharsArray("abcdefghijklmnopqrstuvwxyz", 0)
        )
        assertEquals(
            "[a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z]",
            StringFormatter.showNthCharsArray("abcdefghijklmnopqrstuvwxyz", -1)
        )
    }

    @Test
    fun testGetNthLettersArrayFromEmptyString() {
        assertEquals("[]", StringFormatter.showNthCharsArray("", -1))
        assertEquals("[]", StringFormatter.showNthCharsArray("", 1))
        assertEquals("[]", StringFormatter.showNthCharsArray("", 15))
    }

    @Test
    fun testGetNthLettersArrayFromStringWithLessThanNCharacters() {
        assertEquals("[]", StringFormatter.showNthCharsArray("abcde", 15))
    }

    @Test
    fun testGetWordCountPerWord() {
        assertEquals("{Hello=1, world=1}", StringFormatter.showCountPerWord("Hello world"))
        assertEquals(
            "{Hello=3, world=2}",
            StringFormatter.showCountPerWord("   \t    Hello   \n    world  Hello world Hello \n\t ")
        )
    }

    @Test
    fun testGetWordCountPerWordFromBlankString() {
        assertEquals("", StringFormatter.showCountPerWord(""))
        assertEquals("", StringFormatter.showCountPerWord("   "))
    }

}