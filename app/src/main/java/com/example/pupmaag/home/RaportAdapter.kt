package com.example.pupmaag.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pupmaag.R
import com.example.pupmaag.data.Raport

class CarAdapter(private val listener: OnRaportItemLongClick) :
    RecyclerView.Adapter<CarAdapter.RaportViewHolder>() {

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
        name.text = raportsList[holder.adapterPosition].name
        zone.text = raportsList[holder.adapterPosition].zone
        data.text = raportsList[holder.adapterPosition].date.toString()
       }

    override fun getItemCount(): Int {
       return raportsList.size
    }

    inner class RaportViewHolder(view: View) : RecyclerView.ViewHolder(view){
        init {
            view.setOnLongClickListener() {
              //  listener.onCarLongClick(carsList[adapterPosition], adapterPosition)
                true
            }
        }
    }
}
interface OnRaportItemLongClick{
  //  fun onRaportLongClick(raport: Raport, position: Int)
}