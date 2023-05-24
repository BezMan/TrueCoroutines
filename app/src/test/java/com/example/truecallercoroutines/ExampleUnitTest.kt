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
            val response = NetworkUtils.fetchHtml(url)
            // Assert
            assertTrue(response.isNotBlank())
        }
    }


    @Test
    fun testGet15thLetter() {
        assertEquals(
            "o",
            StringFormatter.showNthChar("abcdefghijklmnopqrstuvwxyz", Constants.jumpSize)
        )
    }

    @Test
    fun testGet15thLetterFromEmptyString() {
        assertEquals("", StringFormatter.showNthChar("", Constants.jumpSize))
    }

    @Test
    fun testGet15thLetterFromStringWithLessThan15Characters() {
        assertEquals("", StringFormatter.showNthChar("abcde", Constants.jumpSize))
    }

}