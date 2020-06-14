package km.project.localweather.api

import android.util.Log
import km.project.localweather.BuildConfig

object WLog {
    private const val TAG = "DEBUG_LOG"

    private fun addTag(tag: String, msg: String): String {
        return "$tag : $msg"
    }

    fun v(tag: String, msg: String): Int {
        if (BuildConfig.DEBUG) {
            val maxLogSize = 1000
            for (i in 0..msg.length / maxLogSize) {
                val start = i * maxLogSize
                var end = (i + 1) * maxLogSize
                end = if (end > msg.length) msg.length else end
                Log.v(TAG, addTag(tag, msg.substring(start, end)))
            }
        }

        return 0
    }

    fun d(tag: String, msg: String): Int {
        if (BuildConfig.DEBUG) {
            val maxLogSize = 1000
            for (i in 0..msg.length / maxLogSize) {
                val start = i * maxLogSize
                var end = (i + 1) * maxLogSize
                end = if (end > msg.length) msg.length else end
                Log.d(TAG, addTag(tag, msg.substring(start, end)))
            }
        }

        return 0
    }

    fun i(tag: String, msg: String): Int {
        if (BuildConfig.DEBUG) {
            val maxLogSize = 1000
            for (i in 0..msg.length / maxLogSize) {
                val start = i * maxLogSize
                var end = (i + 1) * maxLogSize
                end = if (end > msg.length) msg.length else end
                Log.i(TAG, addTag(tag, msg.substring(start, end)))
            }
        }

        return 0
    }

    fun w(tag: String, msg: String): Int {
        if (BuildConfig.DEBUG) {
            val maxLogSize = 1000
            for (i in 0..msg.length / maxLogSize) {
                val start = i * maxLogSize
                var end = (i + 1) * maxLogSize
                end = if (end > msg.length) msg.length else end
                Log.w(TAG, addTag(tag, msg.substring(start, end)))
            }
        }

        return 0
    }

    fun e(tag: String, msg: String): Int {
        if (BuildConfig.DEBUG) {
            val maxLogSize = 1000
            for (i in 0..msg.length / maxLogSize) {
                val start = i * maxLogSize
                var end = (i + 1) * maxLogSize
                end = if (end > msg.length) msg.length else end
                Log.e(TAG, addTag(tag, msg.substring(start, end)))
            }
        }

        return 0
    }

    fun wtf(tag: String, msg: String): Int {
        if (BuildConfig.DEBUG) {
            val maxLogSize = 1000
            for (i in 0..msg.length / maxLogSize) {
                val start = i * maxLogSize
                var end = (i + 1) * maxLogSize
                end = if (end > msg.length) msg.length else end
                Log.wtf(TAG, addTag(tag, msg.substring(start, end)))
            }
        }

        return 0
    }
}
