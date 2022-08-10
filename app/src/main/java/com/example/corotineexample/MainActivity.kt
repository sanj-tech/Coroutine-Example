package com.example.corotineexample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        task1()

//        CoroutineScope(Dispatchers.IO).launch {
//            task2()
//        }

        //OR
        GlobalScope.launch { task2() }

    }


    private fun task1() {
        Thread.sleep(2000)
        println("I am from task 1")
        Log.d("msg",Thread.currentThread().name)

    }

   suspend fun task2() {

withContext(Dispatchers.IO){
    delay(1000L)
    Log.d("I am from task 2","")
    println("I am from task 2")
    Log.d("msg",Thread.currentThread().name)
}



    }
}