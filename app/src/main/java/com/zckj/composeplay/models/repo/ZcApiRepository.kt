package com.zckj.composeplay.models.repo

import android.content.Context
import com.zcapi
import dagger.hilt.android.qualifiers.ApplicationContext
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ZcApiRepository @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val api = zcapi()

    private val calendar = Calendar.getInstance()

    init {
        api.getContext(context)
    }

    fun setOnOff(): Pair<String, String> {
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH) + 1
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)
        val onTime = intArrayOf(year, month, day, hour, minute + 10)
        val offTime = intArrayOf(year, month, day, hour, minute + 5)
        api.setPowetOnOffTime(true, onTime, offTime)
        return Pair(getTime(onTime), getTime(offTime))
    }

    private fun getTime(time: IntArray): String {
        val calendar = Calendar.getInstance()
        calendar.set(time[0], time[1] - 1, time[2], time[3], time[4])
        val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA)
        return sdf.format(calendar.time)
    }
}