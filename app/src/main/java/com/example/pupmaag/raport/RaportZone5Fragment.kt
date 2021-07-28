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
import kotlinx.android.synthetic.main.fragment_raport_zone5.*
import java.util.*

class  RaportZone5Fragment : BaseFragment() {
    private val Report_DEBUG = "REPORT_DEBUG"
    private val cloud = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_raport_zone5, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        openReportZone5Click()
        val rooms = arrayOf("1","2","3","4")
        val arrayAdapter = ArrayAdapter(requireContext(),android.R.layout.simple_spinner_item, rooms )
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        zone5_name_spinner.adapter = arrayAdapter
    }

    private fun openReportZone5Click() {

        zone5_report_send.setOnClickListener {
            val data = hashMapOf(
                "cid" to "NBP",
                "uid" to auth.currentUser?.uid,
                "zone" to "Strefa 5",
                "date" to Timestamp(Date()),
                "name" to zone5_name_spinner.selectedItem,
                "lr1" to zone5_report_lp1.isChecked,
                "lr2" to zone5_report_lp2.isChecked,
                "lr3" to zone5_report_lp3.isChecked,
                "lr4" to zone5_report_lp4.isChecked,
                "lr5" to zone5_report_lp5.isChecked,
                "lr6" to zone5_report_lp6.isChecked,
                "lr7" to zone5_report_lp7.isChecked,
                "lr8" to zone5_report_lp8.isChecked,
                "lr9" to zone5_report_lp9.isChecked
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
                .navigate(RaportZone5FragmentDirections.actionRaportFragmentz5ToHomeFragment().actionId)
            Snackbar.make(requireView(), "Raport został wysłany!", Snackbar.LENGTH_SHORT)
                .show()
               }

           }
    }


