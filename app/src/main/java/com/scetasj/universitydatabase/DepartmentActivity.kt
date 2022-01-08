package com.scetasj.universitydatabase

import android.icu.text.IDNA
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.scetasj.universitydatabase.adapter.DeptAdapter
import com.scetasj.universitydatabase.model.Info
import com.scetasj.universitydatabase.repository.UserRepository
import com.scetasj.universitydatabase.viewmodel.DeptViewmodel

class DepartmentActivity : AppCompatActivity() {
    lateinit var list: LiveData<List<Info>>

    lateinit var rcv:RecyclerView
    lateinit var infoList: List<Info>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_department)

        initUI()

        var viewModel = ViewModelProvider(this).get(DeptViewmodel::class.java)

        viewModel.getDepartment(this, this).observe(this, {
            Log.d("one", "readData: ${it.toString()}")
            infoList = it
            recyclerSet()

        })
    }

    private fun recyclerSet() {
        rcv.apply {
            layoutManager=LinearLayoutManager(this@DepartmentActivity)
            adapter=DeptAdapter(applicationContext,infoList)
        }
    }

    private fun initUI() {
        rcv=findViewById<RecyclerView>(R.id.rcv)
    }
}