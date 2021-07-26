package com.example.pupmaag.raport


import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.pupmaag.BaseFragment
import com.example.pupmaag.R
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.Timestamp
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_raport_zone1.*
import kotlinx.android.synthetic.main.fragment_raport_zone4.*
import java.util.*

class  RaportZone4Fragment : BaseFragment() {
    private val Report_DEBUG = "REPORT_DEBUG"
    private val cloud = FirebaseFirestore.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_raport_zone4, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        openReportZone1Click()
    }

    private fun openReportZone1Click() {

        zone4_report_send.setOnClickListener {
            val zone4_room = zone4_report_room_name.text?.trim().toString()
            val zone4_lr1 = zone4_report_lp1.isChecked
            val zone4_lr2 = zone4_report_lp2.isChecked
            val zone4_lr3 = zone4_report_lp3.isChecked
            val zone4_lr4 = zone4_report_lp4.isChecked
            val zone4_lr5 = zone4_report_lp5.isChecked
            val zone4_lr6 = zone4_report_lp6.isChecked
            val zone4_lr7 = zone4_report_lp7.isChecked
            val zone4_lr8 = zone4_report_lp8.isChecked
            val zone4_lr9 = zone4_report_lp9.isChecked
            val zone4_lr10 = zone4_report_lp10.isChecked
            val zone4_lr11 = zone4_report_lp11.isChecked
            val zone4_lr12 = zone4_report_lp12.isChecked
            val zone4_lr13 = zone4_report_lp13.isChecked
            val zone4_lr14 = zone4_report_lp14.isChecked
            val zone4_lr15 = zone4_report_lp15.isChecked
            val data = hashMapOf(
                "cid" to "NBP",
                "Zone" to "Strefa 4",
                "date" to Timestamp(Date()),
                "room_name" to zone4_room,
                "lr1" to zone4_lr1,
                "lr2" to zone4_lr2,
                "lr3" to zone4_lr3,
                "lr4" to zone4_lr4,
                "lr5" to zone4_lr5,
                "lr6" to zone4_lr6,
                "lr7" to zone4_lr7,
                "lr8" to zone4_lr8,
                "lr9" to zone4_lr9,
                "lr10" to zone4_lr10,
                "lr11" to zone4_lr11,
                "lr12" to zone4_lr12,
                "lr13" to zone4_lr13,
                "lr14" to zone4_lr14,
                "lr15" to zone4_lr15
               )
               if (zone4_room != null) {

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
            findNavController()
                .navigate(RaportZone4FragmentDirections.actionRaportFragmentz4ToHomeFragment().actionId)
            Snackbar.make(requireView(), "Raport został wysłany!", Snackbar.LENGTH_SHORT)
                .show()
           }
    }
}

