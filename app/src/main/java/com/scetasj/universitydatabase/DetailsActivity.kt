package com.scetasj.universitydatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.scetasj.universitydatabase.adapter.DeptAdapter
import com.scetasj.universitydatabase.model.Info
import com.scetasj.universitydatabase.model.Staff
import com.scetasj.universitydatabase.viewmodel.DeptViewmodel

class DetailsActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val listItemCount: List<Staff>  = intent.getSerializableExtra("list") as List<Staff>
        Log.d("TAG", "onCreate: "+listItemCount)

    }


}