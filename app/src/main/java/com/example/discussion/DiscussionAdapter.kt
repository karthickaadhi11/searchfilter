package com.example.discussion

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.hueint.huezaialms.helper.CustomFilter

internal class DiscussionAdapter(private var Discussionlist: List<Discussionlist>) :
RecyclerView.Adapter<DiscussionAdapter.MyViewHolder>() {
    var filter: CustomFilter? = null
    internal inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var serialnumber: TextView = view.findViewById(R.id.singletext)
        var subname: TextView = view.findViewById(R.id.subname)
        var subtitle: TextView = view.findViewById(R.id.subtitle)
        var availfrom: TextView = view.findViewById(R.id.availfrom)
        var availto: TextView = view.findViewById(R.id.availto)
        var duefrom: TextView = view.findViewById(R.id.duefrom)
        var dueto: TextView = view.findViewById(R.id.dueto)
        var status: TextView = view.findViewById(R.id.status)
    }

    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_discussion, parent, false)
        return MyViewHolder(itemView)
    }

    fun setTaskList(taskList: List<*>) {
        Discussionlist   = taskList as List<Discussionlist>
        notifyDataSetChanged()
    }
    fun getFilter(): Filter? {
        if (filter == null) {
            filter = CustomFilter(Discussionlist, this)

        }
        return filter
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val subject =Discussionlist[position]
        holder.serialnumber.text= subject.getSubname()?.substring(0)
        holder.subname.text = subject.getSubname()
        holder.subtitle.text=subject.getSubtitle()
        holder.availfrom.text=subject.getAvailfrom()
        holder.availto.text=subject.getAvailto()
        holder.duefrom.text=subject.getDuefrom()
        holder.dueto.text=subject.getDueto()
        holder.status.text=subject.getStatus()


//        holder.itemView.setOnClickListener {
//            val context=holder.subname.context
//            val intent = Intent( context, quizlist::class.java)
//            context.startActivity(intent)
//        }


    }
    override fun getItemCount(): Int {
        return Discussionlist.size
    }
}