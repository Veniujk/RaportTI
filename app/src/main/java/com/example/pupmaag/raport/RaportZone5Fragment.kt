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
import kotlinx.android.synthetic.main.fragment_raport_zone5.*
import java.util.*

class  RaportZone5Fragment : BaseFragment() {
    private val Report_DEBUG = "REPORT_DEBUG"
    private val cloud = FirebaseFirestore.getInstance()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_raport_zone5, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        openReportZone1Click()
    }

    private fun openReportZone1Click() {

        zone5_report_send.setOnClickListener {
            val zone5_room = zone5_report_room_name.text?.trim().toString()
            val zone5_lr1 = zone5_report_lp1.isChecked
            val zone5_lr2 = zone5_report_lp2.isChecked
            val zone5_lr3 = zone5_report_lp3.isChecked
            val zone5_lr4 = zone5_report_lp4.isChecked
            val zone5_lr5 = zone5_report_lp5.isChecked
            val zone5_lr6 = zone5_report_lp6.isChecked
            val zone5_lr7 = zone5_report_lp7.isChecked
            val zone5_lr8 = zone5_report_lp8.isChecked
            val zone5_lr9 = zone5_report_lp9.isChecked

            val data = hashMapOf(
                "cid" to "NBP",
                "Zone" to "Strefa 5",
                "date" to Timestamp(Date()),
                "room_name" to zone5_room,
                "lr1" to zone5_lr1,
                "lr2" to zone5_lr2,
                "lr3" to zone5_lr3,
                "lr4" to zone5_lr4,
                "lr5" to zone5_lr5,
                "lr6" to zone5_lr6,
                "lr7" to zone5_lr7,
                "lr8" to zone5_lr8,
                "lr9" to zone5_lr9
               )
               if (zone5_room != null) {

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
                .navigate(RaportZone5FragmentDirections.actionRaportFragmentz5ToHomeFragment().actionId)
            Snackbar.make(requireView(), "Raport został wysłany!", Snackbar.LENGTH_SHORT)
                .show()
           }
    }
}

