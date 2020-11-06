package io.github.husseinfo.aurora.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.SwitchCompat
import androidx.recyclerview.widget.RecyclerView
import io.github.husseinfo.aurora.R
import io.github.husseinfo.aurora.utils.TimeModel

class TimesListAdapter :
    RecyclerView.Adapter<TimesListAdapter.ViewHolder>() {
    private val times = ArrayList<TimeModel>()

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val name: TextView = v.findViewById(R.id.time_name)
        val clock: TextView = v.findViewById(R.id.time_clock)
        val switch: SwitchCompat = v.findViewById(R.id.time_switch)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.time_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val name = times[position].name
        holder.name.text = name?.get(0)?.toUpperCase().toString() + name?.substring(1)
        holder.clock.text = times[position].clock
//        if (!BoldTimes.values().map { x -> x.name }.contains(name?.toUpperCase())) {
//            holder.itemView.setBackgroundColor(Color.RED)
//        }
    }

    override fun getItemCount(): Int {
        return times.size
    }

    public fun setTimes(times: ArrayList<TimeModel>) {
        this.times.clear()
        this.times.addAll(times)
        notifyDataSetChanged()
    }
}
