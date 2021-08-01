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
import kotlinx.android.synthetic.main.fragment_raport_zone3.*
import kotlinx.android.synthetic.main.fragment_raport_zone4.*
import kotlinx.android.synthetic.main.fragment_raport_zone5.*
import java.util.*

class  RaportZone5Fragment : BaseFragment() {
    private val Report_DEBUG = "REPORT_DEBUG"
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
        return inflater.inflate(R.layout.fragment_raport_zone5, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.send_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.send_action -> {
                openReportZone5Click(arguments?.get("raport"))
                // requireActivity().finish()
            }
        }
        return false
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
        raport.lr1?.let { zone5_report_lp1.setChecked(it) }
        raport.lr2?.let { zone5_report_lp2.setChecked(it) }
        raport.lr3?.let { zone5_report_lp3.setChecked(it) }
        raport.lr4?.let { zone5_report_lp4.setChecked(it) }
        raport.lr5?.let { zone5_report_lp5.setChecked(it) }
        raport.lr6?.let { zone5_report_lp6.setChecked(it) }
        raport.lr21?.let { zone5_report_lp21.setChecked(it) }
        raport.lr22?.let { zone5_report_lp22.setChecked(it) }
        raport.lr23?.let { zone5_report_lp23.setChecked(it) }
        raport.lr24?.let { zone5_report_lp24.setChecked(it) }
        raport.lr25?.let { zone5_report_lp25.setChecked(it) }
        raport.lr26?.let { zone5_report_lp26.setChecked(it) }
        if (raport.uid != auth.currentUser?.uid) {
            zone5_report_lp1.setEnabled(false)
            zone5_report_lp2.setEnabled(false)
            zone5_report_lp3.setEnabled(false)
            zone5_report_lp4.setEnabled(false)
            zone5_report_lp5.setEnabled(false)
            zone5_report_lp6.setEnabled(false)
            zone5_report_lp21.setEnabled(false)
            zone5_report_lp22.setEnabled(false)
            zone5_report_lp23.setEnabled(false)
            zone5_report_lp24.setEnabled(false)
            zone5_report_lp25.setEnabled(false)
            zone5_report_lp26.setEnabled(false)
        }

    }

    private fun openReportZone5Click(argumentRaport: Any?) {

        var raport : Raport? = null
        if (argumentRaport != null) {
            raport = (argumentRaport as Raport)
        }
            val data = hashMapOf<Any,Any>(
                "lr1" to zone5_report_lp1.isChecked,
                "lr2" to zone5_report_lp2.isChecked,
                "lr3" to zone5_report_lp3.isChecked,
                "lr4" to zone5_report_lp4.isChecked,
                "lr5" to zone5_report_lp5.isChecked,
                "lr6" to zone5_report_lp6.isChecked,
                "lr21" to zone5_report_lp21.isChecked, //okresowo dlatego start od 20
                "lr22" to zone5_report_lp22.isChecked,//okresowo dlatego start od 20
                "lr23" to zone5_report_lp23.isChecked,//okresowo dlatego start od 20
                "lr24" to zone5_report_lp24.isChecked, //okresowo dlatego start od 20
                "lr25" to zone5_report_lp25.isChecked,//okresowo dlatego start od 20
                "lr26" to zone5_report_lp26.isChecked,//okresowo dlatego start od 20
               )
        data.put("control",control(data).toString())
        auth.currentUser?.uid?.let { it1 -> data.put("uid", it1) }
        data.put("name", "Zewnątrz obiektu – w okresie 15X- 15IV")
        data.put("zone", "Strefa 5 - okres zimowy - okresowo")
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
                .navigate(RaportZone5FragmentDirections.actionRaportFragmentz5ToHomeFragment().actionId)
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
                .navigate(RaportZone5FragmentDirections.actionRaportFragmentz5ToHomeFragment().actionId)
            Snackbar.make(requireView(), "Zmiany zostały zapisane!", Snackbar.LENGTH_SHORT)
                .show()

        }


    }


}
