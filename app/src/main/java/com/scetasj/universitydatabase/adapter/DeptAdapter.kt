package com.scetasj.universitydatabase.adapter

import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.icu.text.IDNA
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.scetasj.universitydatabase.DeptFragmentDirections
import com.scetasj.universitydatabase.DetailsActivity
import com.scetasj.universitydatabase.R
import com.scetasj.universitydatabase.model.Info
import java.io.Serializable

class DeptAdapter(var context: Context, private val mList: List<Info>) :
    RecyclerView.Adapter<DeptAdapter.ViewHolder>() {


    private var onClickListener: ((Info) -> Unit)? = null

    fun setClickListener(listener: (Info) -> Unit) {
        onClickListener = listener
    }

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.dept_layout, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val deptList = mList[position]

        holder.deptName.text = deptList.dept

        holder.itemView.setOnClickListener {
            onClickListener?.let { click ->
                click(deptList)
            }
        }


    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val deptName: TextView = itemView.findViewById(R.id.deptName)
    }
}
