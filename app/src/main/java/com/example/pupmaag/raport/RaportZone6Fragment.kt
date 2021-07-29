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
import kotlinx.android.synthetic.main.fragment_raport_zone6.*
import java.util.*

class  RaportZone6Fragment : BaseFragment() {
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
        return inflater.inflate(R.layout.fragment_raport_zone6, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.send_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.send_action -> {
                openReportZone6Click()
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
    }

    private fun openReportZone6Click() {

       // zone6_report_send.setOnClickListener {
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
                "lr21" to zone6_report_lp21.isChecked,
                "lr22" to zone6_report_lp22.isChecked,
                "lr23" to zone6_report_lp23.isChecked,
                "lr24" to zone6_report_lp24.isChecked,
                "lr25" to zone6_report_lp25.isChecked,
                "lr26" to zone6_report_lp26.isChecked,
                "lr27" to zone6_report_lp27.isChecked,
                "lr28" to zone6_report_lp28.isChecked,
                 )
        data.put("control",control(data).toString())
        auth.currentUser?.uid?.let { it1 -> data.put("uid", it1) }
        data.put("name", "zewnątrz obiektu – w okresie od 16 IV do 14 x")
        data.put("zone", "Strefa 6")
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
                       .navigate(RaportZone6FragmentDirections.actionRaportFragmentz6ToHomeFragment().actionId)
                   Snackbar.make(requireView(), "Raport został wysłany!", Snackbar.LENGTH_SHORT)
                       .show()
               }

           }
    //}


