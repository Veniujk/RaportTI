package com.example.pupmaag.raport

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import com.example.pupmaag.BaseFragment
import com.example.pupmaag.R
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.Timestamp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_raport_zone1.*
import kotlinx.android.synthetic.main.fragment_raport_zone3.*
import java.util.*

class  RaportZone3Fragment : BaseFragment() {
    private val Report_DEBUG = "REPORT_DEBUG"
    private val cloud = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_raport_zone3, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        openReportZone3Click()
        val rooms = arrayOf("1","2","3","4")
        val arrayAdapter = ArrayAdapter(requireContext(),android.R.layout.simple_spinner_item, rooms )
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        zone3_name_spinner.adapter = arrayAdapter
    }

    private fun openReportZone3Click() {

        zone3_report_send.setOnClickListener {
            val zone3_room = zone3_name_spinner.selectedItem
            val zone3_lr1 = zone3_report_lp1.isChecked
            val zone3_lr2 = zone3_report_lp2.isChecked
            val zone3_lr3 = zone3_report_lp3.isChecked
            val zone3_lr4 = zone3_report_lp4.isChecked
            val zone3_lr5 = zone3_report_lp5.isChecked
            val zone3_lr6 = zone3_report_lp6.isChecked
            val zone3_lr7 = zone3_report_lp7.isChecked
            val zone3_lr8 = zone3_report_lp8.isChecked
            val zone3_lr9 = zone3_report_lp9.isChecked
            val zone3_lr10 = zone3_report_lp10.isChecked
            val zone3_lr11 = zone3_report_lp11.isChecked
            val zone3_lr12 = zone3_report_lp12.isChecked
            val zone3_lr13 = zone3_report_lp13.isChecked
            val zone3_lr14 = zone3_report_lp14.isChecked
            val zone3_lr15 = zone3_report_lp15.isChecked
            val zone3_lr16 = zone3_report_lp16.isChecked
            val data = hashMapOf(
                "cid" to "NBP",
                "uid" to auth.currentUser?.uid,
                "Zone" to "Strefa 3",
                "date" to Timestamp(Date()),
                "room_name" to zone3_room,
                "lr1" to zone3_lr1,
                "lr2" to zone3_lr2,
                "lr3" to zone3_lr3,
                "lr4" to zone3_lr4,
                "lr5" to zone3_lr5,
                "lr6" to zone3_lr6,
                "lr7" to zone3_lr7,
                "lr8" to zone3_lr8,
                "lr9" to zone3_lr9,
                "lr10" to zone3_lr10,
                "lr11" to zone3_lr11,
                "lr12" to zone3_lr12,
                "lr13" to zone3_lr13,
                "lr14" to zone3_lr14,
                "lr15" to zone3_lr15,
                "lr16" to zone3_lr16
               )
               if (zone3_room != null) {

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
                .navigate(RaportZone3FragmentDirections.actionRaportFragmentz3ToHomeFragment().actionId)
            Snackbar.make(requireView(), "Raport został wysłany!", Snackbar.LENGTH_SHORT)
                .show()
           }
    }
}

