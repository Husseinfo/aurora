package io.github.husseinfo.aurora.utils

import android.content.Context

public const val PT_KEY = "pt"

fun getSPString(context: Context?, key: String?): String? {
    val pref = context?.getSharedPreferences("io.github.husseinfo.aurora", Context.MODE_PRIVATE)
    return pref?.getString(key, null)
}

fun putSPString(context: Context?, key: String?, value: String?) {
    val prefEdit =
        context?.getSharedPreferences("io.github.husseinfo.aurora", Context.MODE_PRIVATE)?.edit()
    prefEdit?.putString(key, value)
    prefEdit?.apply()
}
