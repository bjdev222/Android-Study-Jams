package com.scetasj.universitydatabase.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.scetasj.universitydatabase.R
import com.scetasj.universitydatabase.model.Staff
import de.hdodenhof.circleimageview.CircleImageView

class ProfAdapter(var context: Context,var list: List<Staff>): RecyclerView.Adapter<ProfAdapter.viewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        return viewHolder(LayoutInflater.from(parent.context).inflate(R.layout.details_layout,parent,false))
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val profList = list[position]

        holder.profName.text = profList.name
        holder.profBio.text = profList.bio

        Glide.with(context)
            .load(profList.iUrl)
            .into(holder.profImage);

      /*  Glide
            .with(context)
            .load(profList.iUrl)
            .centerCrop()
            .into(holder.profImage)
*/
    }

    override fun getItemCount(): Int {
        return  list.size
    }


    open class viewHolder (ItemView:View):RecyclerView.ViewHolder(ItemView){

        var profImage=ItemView.findViewById<CircleImageView>(R.id.profileimage)
        var profName=ItemView.findViewById<TextView>(R.id.profName)
        var profBio=ItemView.findViewById<TextView>(R.id.profBio)

    }
}