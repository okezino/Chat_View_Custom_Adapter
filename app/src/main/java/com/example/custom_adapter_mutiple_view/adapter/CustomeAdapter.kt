package com.example.custom_adapter_mutiple_view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.custom_adapter_mutiple_view.R

class CustomAdapter(private val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var chat1 = Chat("Receiver", "Hi Mercy")
    var chat2 = Chat("Sender", "Hi Johnson")
    private var chat3 = Chat("Receiver", "What is good")
    var chat4 = Chat("Sender", "I am fine")
    var chat5 = Chat("Receiver", "Lets Chill Out")

    val arr: ArrayList<Chat> = arrayListOf(chat1, chat2, chat3, chat4, chat5)

    private val VIEW_TYPE_ONE = 1
    private val VIEW_TYPE_TWO = 2

    inner class ViewHolder1(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var firstText: TextView = itemView.findViewById(R.id.view_text_first)

        internal fun bind(position: Int) {

            firstText.text = arr[position].chat
        }

    }

    inner class ViewHolder2(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var secondText: TextView = itemView.findViewById(R.id.view_text_second)

        internal fun bind(position: Int) {

            secondText.text = arr[position].chat
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return if (viewType == VIEW_TYPE_ONE) {
            ViewHolder1(
                LayoutInflater.from(context).inflate(R.layout.view_first, parent, false)
            )
        } else {
            ViewHolder2(
                LayoutInflater.from(context).inflate(R.layout.view_second, parent, false)
            )
        }
    }


    override fun getItemCount(): Int {
        return arr.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (arr[position].chatPerson == "Receiver") {
            (holder as ViewHolder1).bind(position)
        } else {
            (holder as ViewHolder2).bind(position)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if(arr[position].chatPerson == "Receiver"){
            VIEW_TYPE_ONE
        }else {
            VIEW_TYPE_TWO
        }
    }
}