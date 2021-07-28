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
        val rooms = arrayOf("Zespoły specjalnych pomieszczeń magazynowych",
                            "Hole rozładunkowe",
                            "Sortowanie",
                            "Pomieszczenia inne")
        val arrayAdapter = ArrayAdapter(requireContext(),android.R.layout.simple_spinner_item, rooms )
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        zone3_name_spinner.adapter = arrayAdapter
    }

    private fun openReportZone3Click() {

        zone3_report_send.setOnClickListener {
           val data = hashMapOf(
                "cid" to "NBP",
                "uid" to auth.currentUser?.uid,
                "zone" to "Strefa 3",
                "date" to Timestamp(Date()),
                "name" to zone3_name_spinner.selectedItem,
                "lr1" to zone3_report_lp1.isChecked,
                "lr2" to zone3_report_lp2.isChecked,
                "lr3" to zone3_report_lp3.isChecked,
                "lr4" to zone3_report_lp4.isChecked,
                "lr5" to zone3_report_lp5.isChecked,
                "lr6" to zone3_report_lp6.isChecked,
                "lr7" to zone3_report_lp7.isChecked,
                "lr8" to zone3_report_lp8.isChecked,
                "lr9" to zone3_report_lp9.isChecked,
                "lr10" to zone3_report_lp10.isChecked,
                "lr11" to zone3_report_lp11.isChecked,
                "lr12" to zone3_report_lp12.isChecked,
                "lr13" to zone3_report_lp13.isChecked,
                "lr14" to zone3_report_lp14.isChecked,
                "lr15" to zone3_report_lp15.isChecked,
                "lr16" to zone3_report_lp16.isChecked
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
                .navigate(RaportZone3FragmentDirections.actionRaportFragmentz3ToHomeFragment().actionId)
            Snackbar.make(requireView(), "Raport został wysłany!", Snackbar.LENGTH_SHORT)
                .show()
               }

           }
    }


