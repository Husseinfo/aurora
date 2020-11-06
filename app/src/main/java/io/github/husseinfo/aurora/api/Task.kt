package io.github.husseinfo.aurora.api

import android.os.AsyncTask
import io.github.husseinfo.aurora.ui.MainActivity
import io.github.husseinfo.aurora.utils.FAJER
import io.github.husseinfo.aurora.utils.PT_KEY
import io.github.husseinfo.aurora.utils.putSPString
import org.json.JSONObject

class Task(private var mainActivity: MainActivity) : AsyncTask<Void, Void, JSONObject?>() {

    override fun doInBackground(vararg p0: Void): JSONObject? {
        return doGetPrayerTimes()
    }

    override fun onPostExecute(result: JSONObject?) {
        super.onPostExecute(result)
        if (result != null && result.has(FAJER)) {
            putSPString(this.mainActivity, PT_KEY, result.toString())
            this.mainActivity.updateTimes(result)
        }
    }
}
