package com.example.fitnesstracker

import com.example.fitnesstracker.retrofit.BitrootClient
import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun test_api(){
        runBlocking {
            val res=BitrootClient.service.getResult()
            assertNotNull(res.body()?.data)
        }
    }
}