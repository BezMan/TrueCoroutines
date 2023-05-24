package com.example.truecallercoroutines

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
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
}