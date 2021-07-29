package com.example.pupmaag.raport

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import com.example.pupmaag.BaseFragment
import com.example.pupmaag.R
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.Timestamp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_raport_zone1.*
import kotlinx.android.synthetic.main.fragment_raport_zone2.*
import java.util.*

class  RaportZone2Fragment : BaseFragment() {
    private val cloud = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_raport_zone2, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.send_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.send_action -> {
                openReportZone2Click()
                // requireActivity().finish()
            }
        }
        return false
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
     //   openReportZone2Click()
        val rooms = arrayOf("Pokoje biurowe",
                            "Sale konferencyjne i konferencyjno szkoleniowe",
                            "Sanitariaty",
                            "Pomieszczenia socjalne",
                            "Pomieszczenia inne.")
        val arrayAdapter = ArrayAdapter(requireContext(),android.R.layout.simple_spinner_item, rooms )
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        zone2_name_spinner.adapter = arrayAdapter

    }
    private fun openReportZone2Click() {

       // zone2_report_send.setOnClickListener {
            val data = hashMapOf<Any,Any>(
              /*  "cid" to "NBP",
                "uid" to auth.currentUser?.uid,
                "zone" to "Strefa 2",
                "date" to Timestamp(Date()),
                "name" to zone2_name_spinner.selectedItem,*/
                "lr1" to zone2_report_lp1.isChecked,
                "lr2" to zone2_report_lp2.isChecked,
                "lr3" to zone2_report_lp3.isChecked,
                "lr4" to zone2_report_lp4.isChecked,
                "lr5" to zone2_report_lp5.isChecked,
                "lr6" to zone2_report_lp6.isChecked,
                "lr7" to zone2_report_lp7.isChecked,
                "lr8" to zone2_report_lp8.isChecked,
                "lr9" to zone2_report_lp9.isChecked,
                "lr10" to zone2_report_lp10.isChecked,
                "lr11" to zone2_report_lp11.isChecked,
                "lr12" to zone2_report_lp12.isChecked,
                "lr13" to zone2_report_lp13.isChecked,
                "lr14" to zone2_report_lp14.isChecked,
                "lr15" to zone2_report_lp15.isChecked,
                "lr21" to zone2_report_lp21.isChecked, //okresowo dlatego start od 20
                "lr22" to zone2_report_lp22.isChecked,//okresowo dlatego start od 20
                "lr23" to zone2_report_lp23.isChecked,//okresowo dlatego start od 20
                "lr24" to zone2_report_lp24.isChecked, //okresowo dlatego start od 20
                "lr25" to zone2_report_lp25.isChecked,//okresowo dlatego start od 20

               )
            data.put("control",control(data).toString())
            auth.currentUser?.uid?.let { it1 -> data.put("uid", it1) }
            data.put("name", zone2_name_spinner.selectedItem)
            data.put("zone", "Strefa 1")
            data.put("date", Timestamp(Date()))
            data.put("cid", "NBP")

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
                .navigate(RaportZone2FragmentDirections.actionRaportFragmentz2ToHomeFragment().actionId)
            Snackbar.make(requireView(), "Raport został wysłany!", Snackbar.LENGTH_SHORT)
                .show()
               }

           }
  //  }


