package io.github.husseinfo.aurora.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.github.husseinfo.aurora.R
import io.github.husseinfo.aurora.api.Task
import io.github.husseinfo.aurora.utils.PT_KEY
import io.github.husseinfo.aurora.utils.getSPString
import io.github.husseinfo.aurora.utils.jsonToTimes
import org.json.JSONObject
import org.json.JSONTokener

private lateinit var timesList: RecyclerView
private val timesAdapter: TimesListAdapter = TimesListAdapter()

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        timesList = findViewById(R.id.times_list)
        timesList.layoutManager = LinearLayoutManager(this)
        timesList.adapter = timesAdapter

        try {
            updateTimes(JSONTokener(getSPString(this, PT_KEY)).nextValue() as JSONObject)
        } catch (e: Exception) {
            Log.d(this.localClassName, "No previously saved times ")
        }

        Task(this).execute()
    }


    public fun updateTimes(times: JSONObject?) {
        timesAdapter.setTimes(jsonToTimes(times))
    }
}
