package com.example.pupmaag.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.pupmaag.R

class SpinnerActivity : AppCompatActivity() {

    lateinit var room : Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_raport_zone1)

        room = findViewById<Spinner>(R.id.zone1_name_spinner)

        val rooms = arrayOf("room1", "room2", "room3", "room4","room5")

        room.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, rooms)

        room.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val room_name = rooms.get(position)
            }
        }
    }
}