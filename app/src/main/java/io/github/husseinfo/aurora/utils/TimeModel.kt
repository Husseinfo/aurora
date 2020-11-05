package io.github.husseinfo.aurora.utils

import org.json.JSONObject

class TimeModel(val name: String?, val clock: String?)

public fun jsonToTimes(json: JSONObject?): ArrayList<TimeModel> {
    val times = ArrayList<TimeModel>()

    for (time in Times.values()) {
        times.add(TimeModel(time.name.toLowerCase(), json?.getString(time.name.toLowerCase())))
    }

    return times
}
