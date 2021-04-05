package com.example.discussion

import android.content.Intent
import android.graphics.Insets.add
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class  MainActivity : AppCompatActivity() {

    private val Discussionlist =ArrayList<Discussionlist>()
    private lateinit var discussionAdapter: DiscussionAdapter
    lateinit var search: SearchView
    lateinit var filtercard:CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView:RecyclerView=findViewById(R.id.recyclerview)
        search=findViewById(R.id.search)
        filtercard=findViewById(R.id.filtercard)
        discussionAdapter= DiscussionAdapter(Discussionlist)
        val layoutManager= LinearLayoutManager(applicationContext)
        recyclerView.layoutManager=layoutManager
        recyclerView.itemAnimator=DefaultItemAnimator()
        recyclerView.adapter=discussionAdapter
        prepareSubjectData()

        search.setOnQueryTextListener(
            object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String): Boolean {
                    return false
                }

                override fun onQueryTextChange(newText: String): Boolean {
                    discussionAdapter.getFilter()?.filter(newText)
                    return false
                }
            })
        filtercard.setOnClickListener{
          
        }
    }

    private fun prepareSubjectData() {
         var discussion = Discussionlist("1","Computer","Primary key","11/12/2021","11/01/2022","11/12/2021","11/01/2022","open")
        Discussionlist.add(discussion)
        discussion = Discussionlist("2","Science","Solar","11/12/2021","11/01/2022","11/12/2021","11/01/2022","open")
        Discussionlist.add(discussion)
        discussionAdapter.notifyDataSetChanged()
    }
}