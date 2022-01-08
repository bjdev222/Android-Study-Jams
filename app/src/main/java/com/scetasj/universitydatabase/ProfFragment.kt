package com.scetasj.universitydatabase

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.scetasj.universitydatabase.adapter.DeptAdapter
import com.scetasj.universitydatabase.adapter.ProfAdapter
import com.scetasj.universitydatabase.model.Staff


class ProfFragment : Fragment(R.layout.fragment_prof) {

    private val navArgs: ProfFragmentArgs by navArgs()


    lateinit var rcv:RecyclerView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        rcv=view.findViewById(R.id.rcv)
        var list:List<Staff> =navArgs.staff.staff

        rcv.apply {
            layoutManager = LinearLayoutManager(context)
            adapter= ProfAdapter(requireContext(), list)

        }



/*

        view.findViewById<TextView>(R.id.txt).setText(navArgs.staff.dept)
        view.findViewById<TextView>(R.id.txt2).setText(navArgs.staff.staff.toString())*/

    }
}