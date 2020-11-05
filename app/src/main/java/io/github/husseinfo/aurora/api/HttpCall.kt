package io.github.husseinfo.aurora.api

import android.util.Log
import org.json.JSONObject
import org.json.JSONTokener
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

const val PT_URL = "https://almanar.com.lb/ajax/prayer-times.php"

fun doGetPrayerTimes(): JSONObject? {
    var urlConnection: HttpURLConnection? = null
    val url: URL?
    var `object`: JSONObject? = null
    var inStream: InputStream? = null
    try {
        url = URL(PT_URL)
        urlConnection = url.openConnection() as HttpURLConnection
        urlConnection.requestMethod = "GET"
        urlConnection.doOutput = true
        urlConnection.doInput = true
        urlConnection.connect()
        inStream = urlConnection.inputStream
        val bReader = BufferedReader(InputStreamReader(inStream))
        var temp = ""
        var response: String? = ""
        while (bReader.readLine()?.also { temp = it } != null) {
            response += temp
        }
        `object` = JSONTokener(response).nextValue() as JSONObject
    } catch (e: Exception) {
        Log.e("HttpCall", e.message ?: "")
    } finally {
        if (inStream != null) {
            try {
                inStream.close()
            } catch (ignored: IOException) {
            }
        }
        urlConnection?.disconnect()
        return `object`
    }
}
