package com.example.smalltalk

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class ProfileAdapter(

    private val dataSet: List<Message>
) : RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder>() {
    lateinit var context: Context

    inner class ProfileViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewName: TextView
        val textViewMessage: TextView
        val textViewTime: TextView
        lateinit var colorRound: ConstraintLayout

        init {
            textViewName = view.findViewById(R.id.textView_Name)
            textViewMessage = view.findViewById(R.id.textView_Message)
            textViewTime = view.findViewById(R.id.textView_Time)
            colorRound = view.findViewById(R.id.color_round)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        context = parent.context
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.text_row_item, parent, false)
        return ProfileViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        val content = dataSet[position]

        holder.textViewName.text = content.name
        holder.textViewMessage.text = content.message
        holder.textViewTime.text = content.time.toString()
        if (content.name.uppercase() == "sander".uppercase()) {
            holder.colorRound.background = context.getDrawable(R.drawable.my_message_background)
            //   holder.textViewName.setBackgroundColor(context.getColor(R.color.))

        }

    }

    override fun getItemCount(): Int {
        return dataSet.size

    }
}