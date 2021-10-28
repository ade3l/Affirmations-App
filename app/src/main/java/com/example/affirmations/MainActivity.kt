package com.example.affirmations

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.adapter.ItemAdapter
import com.example.affirmations.data.Datasource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myDataset=Datasource().loadAffirmation()
        val recyclerView=findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter= ItemAdapter(this,myDataset)

        /*Since the layout size of your RecyclerView is fixed in the activity layout,
        set the setHasFixedSize parameter of the RecyclerView to true.
        This setting is only needed to improve performance.
        Use this setting if you know that changes in content do not change the layout size of the RecyclerView.*/
        recyclerView.setHasFixedSize(true)
    }
}