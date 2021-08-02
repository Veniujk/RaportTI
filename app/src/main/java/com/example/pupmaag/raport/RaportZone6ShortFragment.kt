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
import kotlinx.android.synthetic.main.fragment_raport_zone5.*
import kotlinx.android.synthetic.main.fragment_raport_zone6.*
import java.util.*

class  RaportZone6ShortFragment : BaseFragment() {
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
        return inflater.inflate(R.layout.fragment_raport_zone6_short, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.send_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.send_action -> {
                openReportZone6Click(arguments?.get("raport"))
                // requireActivity().finish()
            }
        }
        return false
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
      //  openReportZone6Click()
      /*  val rooms = arrayOf("1","2","3","4")
        val arrayAdapter = ArrayAdapter(requireContext(),android.R.layout.simple_spinner_item, rooms )
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        zone6_name_spinner.adapter = arrayAdapter*/
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
        /* raport.name?.let { getIndex(zone1_name_spinner, it) }?.let {
             zone1_name_spinner.setSelection(it)
         }*/
        raport.lr1?.let { zone6_report_lp1.setChecked(it) }
        raport.lr2?.let { zone6_report_lp2.setChecked(it) }
        raport.lr3?.let { zone6_report_lp3.setChecked(it) }
        raport.lr4?.let { zone6_report_lp4.setChecked(it) }
        raport.lr5?.let { zone6_report_lp5.setChecked(it) }
        raport.lr6?.let { zone6_report_lp6.setChecked(it) }
        raport.lr7?.let { zone6_report_lp1.setChecked(it) }
        raport.lr8?.let { zone6_report_lp2.setChecked(it) }
        raport.lr9a?.let { zone6_report_lp9a.setChecked(it) }
        raport.lr9b?.let { zone6_report_lp9b.setChecked(it) }
        raport.lr9c?.let { zone6_report_lp9c.setChecked(it) }
        raport.lr9d?.let { zone6_report_lp9d.setChecked(it) }
        if (raport.uid != auth.currentUser?.uid) {
            zone6_report_lp1.setEnabled(false)
            zone6_report_lp2.setEnabled(false)
            zone6_report_lp3.setEnabled(false)
            zone6_report_lp4.setEnabled(false)
            zone6_report_lp5.setEnabled(false)
            zone6_report_lp6.setEnabled(false)
            zone6_report_lp7.setEnabled(false)
            zone6_report_lp8.setEnabled(false)
            zone6_report_lp9a.setEnabled(false)
            zone6_report_lp9b.setEnabled(false)
            zone6_report_lp9c.setEnabled(false)
            zone6_report_lp9d.setEnabled(false)
        }
    }


    private fun openReportZone6Click(argumentRaport: Any?) {

        var raport : Raport? = null
        if (argumentRaport != null) {
            raport = (argumentRaport as Raport)
        }
            val data = hashMapOf<Any,Any>(
                "lr1" to zone6_report_lp1.isChecked,
                "lr2" to zone6_report_lp2.isChecked,
                "lr3" to zone6_report_lp3.isChecked,
                "lr4" to zone6_report_lp4.isChecked,
                "lr5" to zone6_report_lp5.isChecked,
                "lr6" to zone6_report_lp6.isChecked,
                "lr7" to zone6_report_lp7.isChecked,
                "lr8" to zone6_report_lp8.isChecked,
                "lr9a" to zone6_report_lp9a.isChecked,
                "lr9b" to zone6_report_lp9b.isChecked,
                "lr9c" to zone6_report_lp9c.isChecked,
                "lr9d" to zone6_report_lp9d.isChecked,
                 )
        data.put("control",control(data).toString())
        auth.currentUser?.uid?.let { it1 -> data.put("uid", it1) }
        data.put("name", "zewnątrz obiektu – w okresie 16IV - 14X")
        data.put("zone", "Strefa 5 - okres letni")
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
                       .navigate(RaportZone6ShortFragmentDirections.actionRaportZone6ShortFragmentToHomeFragment().actionId)
                   Snackbar.make(requireView(), "Raport został wysłany!", Snackbar.LENGTH_SHORT)
                       .show()
               }
            else
            {
                if (raport.uid == auth.currentUser?.uid) {
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
                    .navigate(RaportZone6ShortFragmentDirections.actionRaportZone6ShortFragmentToHomeFragment().actionId)
                Snackbar.make(requireView(), "Zmiany zostały zapisane!", Snackbar.LENGTH_SHORT)
                    .show()
                } else {
                    findNavController()
                        .navigate(RaportZone6ShortFragmentDirections.actionRaportZone6ShortFragmentToHomeFragment().actionId)
                    Snackbar.make(requireView(), "Brak uprawnień do edycji! Powrócono do podglądu raportów...", Snackbar.LENGTH_SHORT)
                        .show()
                }
            }


    }


}