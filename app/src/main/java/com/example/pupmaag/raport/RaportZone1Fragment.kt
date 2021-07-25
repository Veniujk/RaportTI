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
import java.util.*

class  RaportZone1Fragment : BaseFragment() {
    private val Report_DEBUG = "REPORT_DEBUG"
    private val cloud = FirebaseFirestore.getInstance()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_raport_zone1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        openReportZone1Click()
    }

    private fun openReportZone1Click() {

        zone1_report_send.setOnClickListener {
            val zone1_room = zone1_report_room_name.text?.trim().toString()
            val zone1_lr1 = zone1_report_lp1.isChecked
            val zone1_lr2 = zone1_report_lp1.isChecked
            val zone1_lr3 = zone1_report_lp1.isChecked
            val zone1_lr4 = zone1_report_lp1.isChecked
            val zone1_lr5 = zone1_report_lp1.isChecked
            val zone1_lr6 = zone1_report_lp1.isChecked
            val zone1_lr7 = zone1_report_lp1.isChecked
            val zone1_lr8 = zone1_report_lp1.isChecked
            val zone1_lr9 = zone1_report_lp1.isChecked
            val zone1_lr10 = zone1_report_lp1.isChecked
            val zone1_lr11 = zone1_report_lp1.isChecked
            val zone1_lr12 = zone1_report_lp1.isChecked
            val zone1_lr13 = zone1_report_lp1.isChecked
            val zone1_lr14 = zone1_report_lp1.isChecked
            val zone1_lr15 = zone1_report_lp1.isChecked
            val zone1_lr16 = zone1_report_lp1.isChecked
            val zone1_lr17 = zone1_report_lp1.isChecked
            val zone1_lr18 = zone1_report_lp1.isChecked
               val data = hashMapOf(
                   "cid" to "NBP",
                   "date" to Timestamp(Date()),
                   "room_name" to zone1_room,
                   "lr1" to zone1_lr1,
                   "lr2" to zone1_lr2,
                   "lr3" to zone1_lr3,
                   "lr4" to zone1_lr4,
                   "lr5" to zone1_lr5,
                   "lr6" to zone1_lr6,
                   "lr7" to zone1_lr7,
                   "lr8" to zone1_lr8,
                   "lr9" to zone1_lr9,
                   "lr10" to zone1_lr10,
                   "lr11" to zone1_lr11,
                   "lr12" to zone1_lr12,
                   "lr13" to zone1_lr13,
                   "lr14" to zone1_lr14,
                   "lr15" to zone1_lr15,
                   "lr16" to zone1_lr16,
                   "lr17" to zone1_lr17,
                   "lr18" to zone1_lr18


               )
               if (zone1_room != null) {

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

