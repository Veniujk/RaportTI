package com.example.pupmaag.home

import android.icu.text.SimpleDateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pupmaag.R
import com.example.pupmaag.data.Raport

class RaportAdapter(private val listener: OnRaportItemLongClick) :
    RecyclerView.Adapter<RaportAdapter.RaportViewHolder>() {

    private val raportsList = ArrayList<Raport>()

    fun setRaports(list: List<Raport>){
        raportsList.clear()
        raportsList.addAll(list)
        notifyDataSetChanged()
    }

    fun removeCar(raport: Raport, position: Int){
        raportsList.remove(raport)
        notifyItemRemoved(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RaportViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_row, parent, false)
        return RaportViewHolder(view)
    }

    override fun onBindViewHolder(holder: RaportViewHolder, position: Int) {
        bindData(holder)
    }

    private fun bindData(holder: RaportViewHolder) {
        val name = holder.itemView.findViewById<TextView>(R.id.roomName)
        val zone = holder.itemView.findViewById<TextView>(R.id.raportZone)
        val data = holder.itemView.findViewById<TextView>(R.id.raportDate)
        val control = holder.itemView.findViewById<TextView>(R.id.raportControl)
        name.text = raportsList[holder.adapterPosition].name
        zone.text = raportsList[holder.adapterPosition].zone
        data.text = SimpleDateFormat("dd/MM/yyyy HH:mm").format(raportsList[holder.adapterPosition].date?.toDate())
        control.text = "Wynik kontroli: " + raportsList[holder.adapterPosition].control + "%"

       }

    override fun getItemCount(): Int {
       return raportsList.size
    }

    inner class RaportViewHolder(view: View) : RecyclerView.ViewHolder(view){
        init {
            view.setOnLongClickListener() {
                listener.onRaportLongClick(raportsList[adapterPosition], adapterPosition)
                true
            }
        }
    }
}
interface OnRaportItemLongClick{
    fun onRaportLongClick(raport: Raport, position: Int)
}