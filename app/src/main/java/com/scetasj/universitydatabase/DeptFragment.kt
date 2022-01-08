package com.scetasj.universitydatabase

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.scetasj.universitydatabase.adapter.DeptAdapter
import com.scetasj.universitydatabase.model.Info
import com.scetasj.universitydatabase.viewmodel.DeptViewmodel

class DeptFragment : Fragment(R.layout.fragment_dept) {


    lateinit var list: LiveData<List<Info>>

    lateinit var rcv: RecyclerView
    lateinit var infoList: List<Info>
lateinit var deptAdapter: DeptAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rcv = view.findViewById<RecyclerView>(R.id.rcv)


        initUI()

        var viewModel = ViewModelProvider(this).get(DeptViewmodel::class.java)

        activity?.let {
            context?.let { it1 ->
                viewModel.getDepartment(it1, this).observe(it, {
                    Log.d("one", "readData: ${it.toString()}")
                    infoList = it
                    deptAdapter = DeptAdapter(requireContext(), infoList)

                    recyclerSet()

                })
            }
        }

    }

    private fun recyclerSet() {
        rcv.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = deptAdapter
        }
        deptAdapter.setClickListener {
            Log.d("TAG", "recyclerSet:data found -> ${it.toString()} ")
            val action = DeptFragmentDirections.actionDeptFragmentToProfFragment(it)
            findNavController().navigate(action)
        }
    }

    private fun initUI() {
    }

}