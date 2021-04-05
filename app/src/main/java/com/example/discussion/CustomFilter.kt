package com.hueint.huezaialms.helper

import android.util.Log
import android.widget.Filter
import com.example.discussion.DiscussionAdapter
import com.example.discussion.Discussionlist
import java.util.*


class CustomFilter internal constructor(taskList: List<Discussionlist>, adapter: DiscussionAdapter) :
    Filter() {
    private var adapter: DiscussionAdapter
    var taskList: List<Discussionlist>
    init {
        this.adapter = adapter!!
        this.taskList = taskList!!
    }
    //FILTERING OCURS
    override fun performFiltering(constraint: CharSequence): FilterResults {
        var constraint: CharSequence? = constraint
        val results = FilterResults()
        Log.d("Constraint", constraint.toString())
        if (constraint != null && constraint.length > 0) {
            constraint = constraint.toString().toLowerCase()
            val filteredPlayers: MutableList<Discussionlist> =
                ArrayList<Discussionlist>()
            for (i in taskList.indices) {
                if (taskList[i].getSubtitle()?.toLowerCase()?.contains(constraint)!!) {
                    filteredPlayers.add(taskList[i])
                }
            }
            results.count = filteredPlayers.size
            results.values = filteredPlayers
        } else {
            results.count = taskList.size
            results.values = taskList
        }
        return results
    }

    override fun publishResults(
        constraint: CharSequence,
        results: FilterResults
    ) {
        adapter.setTaskList(results.values as List<*>)

        //REFRESH
        adapter.notifyDataSetChanged()
    }

    init {
        this.taskList = taskList
    }
}