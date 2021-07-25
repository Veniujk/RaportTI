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
import kotlinx.android.synthetic.main.fragment_raport_zone2.*
import java.util.*

class  RaportZone2Fragment : BaseFragment() {
    private val Report_DEBUG = "REPORT_DEBUG"
    private val cloud = FirebaseFirestore.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_raport_zone2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        openReportZone1Click()
    }

    private fun openReportZone1Click() {

        zone2_report_send.setOnClickListener {
            val zone2_room = zone1_report_room_name.text?.trim().toString()
            val zone2_lr1 = zone2_report_lp1.isChecked
            val zone2_lr2 = zone2_report_lp1.isChecked
            val zone2_lr3 = zone2_report_lp1.isChecked
            val zone2_lr4 = zone2_report_lp1.isChecked
            val zone2_lr5 = zone2_report_lp1.isChecked
            val zone2_lr6 = zone2_report_lp1.isChecked
            val zone2_lr7 = zone2_report_lp1.isChecked
            val zone2_lr8 = zone2_report_lp1.isChecked
            val zone2_lr9 = zone2_report_lp1.isChecked
            val zone2_lr10 = zone2_report_lp1.isChecked
            val zone2_lr11 = zone2_report_lp1.isChecked
            val zone2_lr12 = zone2_report_lp1.isChecked
            val zone2_lr13 = zone2_report_lp1.isChecked
            val zone2_lr14 = zone2_report_lp1.isChecked
            val zone2_lr15 = zone2_report_lp1.isChecked
            val zone2_lr16 = zone2_report_lp1.isChecked
            val zone2_lr17 = zone2_report_lp1.isChecked
            val zone2_lr18 = zone2_report_lp1.isChecked
            val data = hashMapOf(
                "cid" to "NBP",
                "date" to Timestamp(Date()),
                "room_name" to zone2_room,
                "lr1" to zone2_lr1,
                "lr2" to zone2_lr2,
                "lr3" to zone2_lr3,
                "lr4" to zone2_lr4,
                "lr5" to zone2_lr5,
                "lr6" to zone2_lr6,
                "lr7" to zone2_lr7,
                "lr8" to zone2_lr8,
                "lr9" to zone2_lr9,
                "lr10" to zone2_lr10,
                "lr11" to zone2_lr11,
                "lr12" to zone2_lr12,
                "lr13" to zone2_lr13,
                "lr14" to zone2_lr14,
                "lr15" to zone2_lr15,
                "lr16" to zone2_lr16,
                "lr17" to zone2_lr17,
                "lr18" to zone2_lr18
               )
               if (zone2_room != null) {

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

