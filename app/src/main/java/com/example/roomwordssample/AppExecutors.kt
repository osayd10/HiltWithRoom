package com.example.roomwordssample

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor
import java.util.concurrent.Executors


/**
 * Global executor pools for the whole application.
 *
 * Grouping tasks like this avoids the effects of task starvation (e.g. disk reads don't wait behind
 * webservice requests).
 */
object AppExecutors {

    private val diskExecutor: Executor = Executors.newSingleThreadExecutor()
    private val mainExecutor: Executor = MainThreadExecutor()

    fun diskExecutor() = diskExecutor

    fun mainExecutor() = mainExecutor

    private class MainThreadExecutor : Executor {
        private val mainThreadHandler = Handler(Looper.getMainLooper())
        override fun execute(command: Runnable) {
            mainThreadHandler.post(command)
        }
    }
}

/**
 * Runs the given code block on the background thread.
 */
fun runOnBackgroundThread(block: () -> Unit) {
    AppExecutors.diskExecutor().execute {
        block.invoke()
    }
}

