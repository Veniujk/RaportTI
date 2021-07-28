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
import kotlinx.android.synthetic.main.fragment_raport_zone6.*
import java.util.*

class  RaportZone6Fragment : BaseFragment() {
    private val cloud = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_raport_zone6, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        openReportZone6Click()
        val rooms = arrayOf("1","2","3","4")
        val arrayAdapter = ArrayAdapter(requireContext(),android.R.layout.simple_spinner_item, rooms )
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        zone6_name_spinner.adapter = arrayAdapter
    }

    private fun openReportZone6Click() {

        zone6_report_send.setOnClickListener {
            val zone6_room = zone6_name_spinner.selectedItem
            val zone6_lr1 = zone6_report_lp1.isChecked
            val zone6_lr2 = zone6_report_lp2.isChecked
            val zone6_lr3 = zone6_report_lp3.isChecked
            val zone6_lr4 = zone6_report_lp4.isChecked
            val zone6_lr5 = zone6_report_lp5.isChecked
            val zone6_lr6 = zone6_report_lp6.isChecked
            val zone6_lr7 = zone6_report_lp7.isChecked
            val zone6_lr8 = zone6_report_lp8.isChecked
            val zone6_lr9 = zone6_report_lp9.isChecked
            val zone6_lr10 = zone6_report_lp10.isChecked
            val zone6_lr11 = zone6_report_lp11.isChecked
            val zone6_lr12 = zone6_report_lp12.isChecked
            val zone6_lr13 = zone6_report_lp13.isChecked
            val zone6_lr14 = zone6_report_lp14.isChecked
            val zone6_lr15 = zone6_report_lp15.isChecked
            val zone6_lr16 = zone6_report_lp16.isChecked
            val zone6_lr17 = zone6_report_lp17.isChecked
            val zone6_lr18 = zone6_report_lp18.isChecked
            val data = hashMapOf(
                "cid" to "NBP",
                "uid" to auth.currentUser?.uid,
                "zone" to "Strefa 6",
                "date" to Timestamp(Date()),
                "name" to zone6_room,
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

                   cloud.collection("raports")
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
                   findNavController()
                       .navigate(RaportZone6FragmentDirections.actionRaportFragmentz6ToHomeFragment().actionId)
                   Snackbar.make(requireView(), "Raport został wysłany!", Snackbar.LENGTH_SHORT)
                       .show()
               }

           }
    }


