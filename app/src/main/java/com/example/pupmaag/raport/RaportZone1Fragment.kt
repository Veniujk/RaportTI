package com.example.pupmaag.raport

import android.content.ContentValues
import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.pupmaag.BaseFragment
import com.example.pupmaag.R
import com.example.pupmaag.home.HomeViewModel
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.Timestamp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_raport_zone1.*
import java.util.*


class RaportZone1Fragment : BaseFragment(){
    private val REPO_DEBUG = "REPORT_DEBUG"
    private val cloud = FirebaseFirestore.getInstance()
    private val homeVm by viewModels<HomeViewModel>()
    private val auth = FirebaseAuth.getInstance()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_raport_zone1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        openReportZone1Click()


        val rooms = arrayOf("Zespoły sekretarsko-dyrektorskie",
                              "Sala operacyjna",
                              "Hol główny z wejsciem do obiektu",
                              "Pomieszczenia inne w obrębie lokalizacji")
        val arrayAdapter = ArrayAdapter(requireContext(),android.R.layout.simple_spinner_item, rooms )
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        zone1_name_spinner.adapter = arrayAdapter
    }

    private fun openReportZone1Click() {

        zone1_report_send.setOnClickListener {
            val zone1_room = zone1_name_spinner.selectedItem
            val zone1_lr1 = zone1_report_lp1.isChecked
            val zone1_lr2 = zone1_report_lp2.isChecked
            val zone1_lr3 = zone1_report_lp3.isChecked
            val zone1_lr4 = zone1_report_lp4.isChecked
            val zone1_lr5 = zone1_report_lp5.isChecked
            val zone1_lr6 = zone1_report_lp6.isChecked
            val zone1_lr7 = zone1_report_lp7.isChecked
            val zone1_lr8 = zone1_report_lp8.isChecked
            val zone1_lr9 = zone1_report_lp9.isChecked
            val zone1_lr10 = zone1_report_lp10.isChecked
            val zone1_lr11 = zone1_report_lp11.isChecked
            val zone1_lr12 = zone1_report_lp12.isChecked
            val zone1_lr13 = zone1_report_lp13.isChecked
            val zone1_lr14 = zone1_report_lp14.isChecked
            val zone1_lr15 = zone1_report_lp15.isChecked
            val zone1_lr16 = zone1_report_lp16.isChecked
            val zone1_lr17 = zone1_report_lp17.isChecked
            val zone1_lr18 = zone1_report_lp18.isChecked
            val data = hashMapOf(
                   "id" to "tmpid",
                   "cid" to "NBP",
                   "uid" to auth.currentUser?.uid,
                   "zone" to "Strefa 1",
                   "date" to Timestamp(Date()),
                   "name" to zone1_room,
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
                   "lr18" to zone1_lr18,
               )

               if (zone1_room != null) {

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
                       .navigate(RaportZone1FragmentDirections.actionRaportFragmentz1ToHomeFragment().actionId)

               }

            Snackbar.make(requireView(), "Raport został wysłany!", Snackbar.LENGTH_SHORT)
                .show()
           }
    }
}

