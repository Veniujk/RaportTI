package com.example.pupmaag.raport

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.navigation.fragment.findNavController
import com.example.pupmaag.BaseFragment
import com.example.pupmaag.R
import com.example.pupmaag.data.Raport
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
                openReportZone2Click(arguments?.get("raport"))
                // requireActivity().finish()
            }
        }
        return false
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rooms = arrayOf("Pokoje biurowe",
                            "Sale konferencyjne i konferencyjno szkoleniowe",
                            "Sanitariaty",
                            "Pomieszczenia socjalne",
                            "Pomieszczenia inne.")
        val arrayAdapter = ArrayAdapter(requireContext(),android.R.layout.simple_spinner_item, rooms )
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        zone2_name_spinner.adapter = arrayAdapter


    val arguementRaport = arguments?.get("raport")

    if (arguementRaport != null) {
        editReportZoneClick(arguementRaport as Raport)
    }

}

private fun getIndex(spinner: Spinner, myString: String): Int {
    for (i in 0 until spinner.count) {

        if (spinner.getItemAtPosition(i).toString().equals(myString, ignoreCase = true)) {

            return i
        }
    }
    return 0
}
private fun editReportZoneClick(raport: Raport) {
    raport.name?.let { getIndex(zone2_name_spinner, it) }?.let {
        zone2_name_spinner.setSelection(it)
    }
    raport.lr1?.let { zone2_report_lp1.setChecked(it) }
    raport.lr2?.let { zone2_report_lp2.setChecked(it) }
    raport.lr3?.let { zone2_report_lp3.setChecked(it) }
    raport.lr4?.let { zone2_report_lp4.setChecked(it) }
    raport.lr5?.let { zone2_report_lp5.setChecked(it) }
    raport.lr6?.let { zone2_report_lp6.setChecked(it) }
    raport.lr7?.let { zone2_report_lp7.setChecked(it) }
    raport.lr8?.let { zone2_report_lp8.setChecked(it) }
    raport.lr9?.let { zone2_report_lp9.setChecked(it) }
    raport.lr10?.let { zone2_report_lp10.setChecked(it) }
    raport.lr11?.let { zone2_report_lp11.setChecked(it) }
    raport.lr12?.let { zone2_report_lp12.setChecked(it) }
    raport.lr13?.let { zone2_report_lp13.setChecked(it) }
    raport.lr14?.let { zone2_report_lp14.setChecked(it) }
    raport.lr15?.let { zone2_report_lp15.setChecked(it) }
    raport.lr21?.let { zone2_report_lp21.setChecked(it) }
    raport.lr22?.let { zone2_report_lp22.setChecked(it) }
    raport.lr23?.let { zone2_report_lp23.setChecked(it) }
    raport.lr24?.let { zone2_report_lp22.setChecked(it) }
    raport.lr25?.let { zone2_report_lp23.setChecked(it) }

}

    private fun openReportZone2Click(argumentRaport: Any?) {
        var raport : Raport? = null
        if (argumentRaport != null) {
            raport = (argumentRaport as Raport)
        }
            val data = hashMapOf<Any,Any>(
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
            data.put("zone", "Strefa 2")
            data.put("date", Timestamp(Date()))
            data.put("cid", "NBP")
            if (raport == null) {
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
            else
            {

                raport.documentId?.let {
                    cloud.collection("raports")
                        .document(it)
                        .set(data)
                        .addOnSuccessListener {
                            // Log.d(REPO_DEBUG, "Dodana do ulubionych")
                        }
                        .addOnFailureListener{
                            //  Log.d(REPO_DEBUG, it.message.toString())
                        }
                }


                findNavController()
                    .navigate(RaportZone2FragmentDirections.actionRaportFragmentz2ToHomeFragment().actionId)
                Snackbar.make(requireView(), "Zmiany zostały zapisane!", Snackbar.LENGTH_SHORT)
                    .show()

            }
           }
    }


