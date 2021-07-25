package com.example.pupmaag.raport

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pupmaag.BaseFragment
import com.example.pupmaag.R
import com.google.firebase.Timestamp
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_raport_zone1.*
import kotlinx.android.synthetic.main.fragment_raport_zone6.*
import java.util.*

class  RaportZone6Fragment : BaseFragment() {
    private val Report_DEBUG = "REPORT_DEBUG"
    private val cloud = FirebaseFirestore.getInstance()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_raport_zone6, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        openReportZone1Click()
    }

    private fun openReportZone1Click() {

        zone6_report_send.setOnClickListener {
            val zone6_room = zone6_report_room_name.text?.trim().toString()
            val zone6_lr1 = zone6_report_lp1.isChecked
            val zone6_lr2 = zone6_report_lp1.isChecked
            val zone6_lr3 = zone6_report_lp1.isChecked
            val zone6_lr4 = zone6_report_lp1.isChecked
            val zone6_lr5 = zone6_report_lp1.isChecked
            val zone6_lr6 = zone6_report_lp1.isChecked
            val zone6_lr7 = zone6_report_lp1.isChecked
            val zone6_lr8 = zone6_report_lp1.isChecked
            val zone6_lr9 = zone6_report_lp1.isChecked
            val zone6_lr10 = zone6_report_lp1.isChecked
            val zone6_lr11 = zone6_report_lp1.isChecked
            val zone6_lr12 = zone6_report_lp1.isChecked
            val zone6_lr13 = zone6_report_lp1.isChecked
            val zone6_lr14 = zone6_report_lp1.isChecked
            val zone6_lr15 = zone6_report_lp1.isChecked
            val zone6_lr16 = zone6_report_lp1.isChecked
            val zone6_lr17 = zone6_report_lp1.isChecked
            val zone6_lr18 = zone6_report_lp1.isChecked
            val data = hashMapOf(
                "cid" to "NBP",
                "date" to Timestamp(Date()),
                "room_name" to zone6_room,
                "lr1" to zone6_lr1,
                "lr2" to zone6_lr2,
                "lr3" to zone6_lr3,
                "lr4" to zone6_lr4,
                "lr5" to zone6_lr5,
                "lr6" to zone6_lr6,
                "lr7" to zone6_lr7,
                "lr8" to zone6_lr8,
                "lr9" to zone6_lr9,
                "lr10" to zone6_lr10,
                "lr11" to zone6_lr11,
                "lr12" to zone6_lr12,
                "lr13" to zone6_lr13,
                "lr14" to zone6_lr14,
                "lr15" to zone6_lr15,
                "lr16" to zone6_lr16,
                "lr17" to zone6_lr17,
                "lr18" to zone6_lr18
               )
               if (zone6_room != null) {

                   cloud.collection("rooms")
                       .add(data)

                       .addOnSuccessListener { documentReference ->
                           Log.d(
                               ContentValues.TAG,
                               "DocumentSnapshot written with ID: ${documentReference.id}"
                           )
                       }
                       .addOnFailureListener { e ->
                           Log.w(ContentValues.TAG, "Error adding document", e)
                       }
               }
           }
    }
}

