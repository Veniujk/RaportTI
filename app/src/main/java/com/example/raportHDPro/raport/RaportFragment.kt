package com.example.raportHDPro.raport


import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Spinner
import androidx.navigation.fragment.findNavController
import com.example.raportHDPro.BaseFragment
import com.example.raportHDPro.R
import com.example.raportHDPro.data.Raport
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.Timestamp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_raport.*
import java.util.*

class RaportFragment : BaseFragment() {
    private val cloud = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()
    private val DEBUG = "REG_DEBUG"
    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_raport, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.send_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.send_action -> {
                openReportZone1Click(arguments?.get("raport"))}
            //  requireActivity().finish()
        }

        return false
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

   /*     val rooms = arrayOf(
            "TISO001",
            "TISO002",
            "TISO003",
            "TISO004",
            "TISO005",
            "TISO006",
            "TISO007",
            "TISO008",
            "TISO009",
            "TISO010",
            "TISO011",
            "TISO012",
            "TISO013",
            "TISO014",
            "TISO015",
            "TISO016"
        )

        val arrayAdapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, rooms)
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        zone1_name_spinner.adapter = arrayAdapter
        */

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
      /*  raport.name?.let { getIndex(zone1_name_spinner, it) }?.let {
        zone1_name_spinner.setSelection(it)
        }*/
        raport.TISO001?.let { TISO001.isChecked = it }
        raport.TISO002?.let { TISO002.isChecked = it }
        raport.TISO003?.let { TISO003.isChecked = it }
        raport.TISO004?.let { TISO004.isChecked = it }
        raport.TISO005?.let { TISO005.isChecked = it }
        raport.TISO006?.let { TISO006.isChecked = it }
        raport.TISO007?.let { TISO007.isChecked = it }
        raport.TISO008?.let { TISO008.isChecked = it }
        raport.TISO009?.let { TISO009.isChecked = it }
        raport.TISO010?.let { TISO010.isChecked = it }
        raport.TISO011?.let { TISO011.isChecked = it }
        raport.TISO012?.let { TISO012.isChecked = it }
        raport.TISO013?.let { TISO013.isChecked = it }
        raport.TISO014?.let { TISO014.isChecked = it }
        raport.TISO015?.let { TISO015.isChecked = it }
        raport.TISO016?.let { TISO016.isChecked = it }
        TISO001_edittext.setText(raport.TISO001_uwagi)
        TISO002_edittext.setText(raport.TISO002_uwagi)
        TISO003_edittext.setText(raport.TISO003_uwagi)
        TISO004_edittext.setText(raport.TISO004_uwagi)
        TISO005_edittext.setText(raport.TISO005_uwagi)
        TISO006_edittext.setText(raport.TISO006_uwagi)
        TISO007_edittext.setText(raport.TISO007_uwagi)
        TISO008_edittext.setText(raport.TISO008_uwagi)
        TISO009_edittext.setText(raport.TISO009_uwagi)
        TISO010_edittext.setText(raport.TISO010_uwagi)
        TISO011_edittext.setText(raport.TISO011_uwagi)
        TISO012_edittext.setText(raport.TISO012_uwagi)
        TISO013_edittext.setText(raport.TISO013_uwagi)
        TISO014_edittext.setText(raport.TISO014_uwagi)
        TISO015_edittext.setText(raport.TISO015_uwagi)
        TISO016_edittext.setText(raport.TISO016_uwagi)

        if (raport.uid != auth.currentUser?.uid) {
          //  zone1_name_spinner.isEnabled = false
            TISO001.isEnabled = false
            TISO002.isEnabled = false
            TISO003.isEnabled = false
            TISO004.isEnabled = false
            TISO005.isEnabled = false
            TISO006.isEnabled = false
            TISO007.isEnabled = false
            TISO008.isEnabled = false
            TISO009.isEnabled = false
            TISO010.isEnabled = false
            TISO011.isEnabled = false
            TISO012.isEnabled = false
            TISO013.isEnabled = false
            TISO014.isEnabled = false
            TISO015.isEnabled = false
            TISO016.isEnabled = false
            TISO001_edittext.isEnabled = false
            TISO002_edittext.isEnabled = false
            TISO003_edittext.isEnabled = false
            TISO004_edittext.isEnabled = false
            TISO005_edittext.isEnabled = false
            TISO006_edittext.isEnabled = false
            TISO007_edittext.isEnabled = false
            TISO008_edittext.isEnabled = false
            TISO009_edittext.isEnabled = false
            TISO010_edittext.isEnabled = false
            TISO011_edittext.isEnabled = false
            TISO012_edittext.isEnabled = false
            TISO013_edittext.isEnabled = false
            TISO014_edittext.isEnabled = false
            TISO015_edittext.isEnabled = false
            TISO016_edittext.isEnabled = false


        }
    }

    private fun openReportZone1Click(argumentRaport: Any?) {

        var raport : Raport? = null
        if (argumentRaport != null) {
            raport = (argumentRaport as Raport)
        }
        val data = hashMapOf<Any, Any>(
            "TISO001" to TISO001.isChecked,
            "TISO002" to TISO002.isChecked,
            "TISO003" to TISO003.isChecked,
            "TISO004" to TISO004.isChecked,
            "TISO005" to TISO005.isChecked,
            "TISO006" to TISO006.isChecked,
            "TISO007" to TISO007.isChecked,
            "TISO008" to TISO008.isChecked,
            "TISO009" to TISO009.isChecked,
            "TISO010" to TISO010.isChecked,
            "TISO011" to TISO011.isChecked,
            "TISO012" to TISO012.isChecked,
            "TISO013" to TISO013.isChecked,
            "TISO014" to TISO014.isChecked,
            "TISO015" to TISO015.isChecked,
            "TISO016" to TISO016.isChecked,
        )

        data.put("control", control(data).toString())
        auth.currentUser?.uid?.let { it1 -> data.put("uid", it1) }
        auth.currentUser?.email?.let { it1 -> data.put("uemail", it1) }
      //  data.put("name", zone1_name_spinner.selectedItem)
        data.put("date", Timestamp(Date()))
        data.put("cid", "Top-Info")
        data.put("TISO001_uwagi",TISO001_edittext.text.toString())
        data.put("TISO002_uwagi",TISO002_edittext.text.toString())
        data.put("TISO003_uwagi",TISO003_edittext.text.toString())
        data.put("TISO004_uwagi",TISO004_edittext.text.toString())
        data.put("TISO005_uwagi",TISO005_edittext.text.toString())
        data.put("TISO006_uwagi",TISO006_edittext.text.toString())
        data.put("TISO007_uwagi",TISO007_edittext.text.toString())
        data.put("TISO008_uwagi",TISO008_edittext.text.toString())
        data.put("TISO009_uwagi",TISO009_edittext.text.toString())
        data.put("TISO010_uwagi",TISO010_edittext.text.toString())
        data.put("TISO011_uwagi",TISO011_edittext.text.toString())
        data.put("TISO012_uwagi",TISO012_edittext.text.toString())
        data.put("TISO013_uwagi",TISO013_edittext.text.toString())
        data.put("TISO014_uwagi",TISO014_edittext.text.toString())
        data.put("TISO015_uwagi",TISO015_edittext.text.toString())
        data.put("TISO016_uwagi",TISO016_edittext.text.toString())


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
                .navigate(RaportFragmentDirections.actionRaportFragmentToHomeFragment().actionId)
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
                        .addOnFailureListener {
                            //  Log.d(REPO_DEBUG, it.message.toString())
                        }
                }
                findNavController()
                    .navigate(RaportFragmentDirections.actionRaportFragmentToHomeFragment().actionId)
                Snackbar.make(requireView(), "Zmiany zostały zapisane!", Snackbar.LENGTH_SHORT)
                    .show()
            } else {
                findNavController()
                    .navigate(RaportFragmentDirections.actionRaportFragmentToHomeFragment().actionId)
                Snackbar.make(requireView(), "Brak uprawnień do edycji! Powrócono do podglądu raportów...", Snackbar.LENGTH_SHORT)
                    .show()
            }


        }


    }


}
/*
class RaportFragment : BaseFragment() {
        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_raport, container, false)
    }


   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
       super.onViewCreated(view, savedInstanceState)
       openReportZone1()
       openReportZone2()
       openReportZone3()
       openReportZone4()
       openReportZone5()
       openReportZone6()
       openReportZone1Short()
       openReportZone2Short()
       openReportZone3Short()
       openReportZone4Short()
       openReportZone5Short()
       openReportZone6Short()

       }

    private fun openReportZone1() {
        GoTo_fragment_raport_zone1.setOnClickListener {
            findNavController()
                .navigate(RaportFragmentDirections.actionRaportFragmentToRaportFragmentz1().actionId)
        }
    }

    private fun openReportZone2() {
        GoTo_fragment_raport_zone2.setOnClickListener {
            findNavController()
                .navigate(RaportFragmentDirections.actionRaportFragmentToRaportFragmentz2().actionId)
        }

    }
    private fun openReportZone3() {
        GoTo_fragment_raport_zone3.setOnClickListener {
            findNavController()
                .navigate(RaportFragmentDirections.actionRaportFragmentToRaportFragmentz3().actionId)
        }

    }
    private fun openReportZone4() {
        GoTo_fragment_raport_zone4.setOnClickListener {
            findNavController()
                .navigate(RaportFragmentDirections.actionRaportFragmentToRaportFragmentz4().actionId)
        }

    }
    private fun openReportZone5() {
        GoTo_fragment_raport_zone5.setOnClickListener {
            findNavController()
                .navigate(RaportFragmentDirections.actionRaportFragmentToRaportFragmentz5().actionId)
        }

    }
    private fun openReportZone6() {
        GoTo_fragment_raport_zone6.setOnClickListener {
            findNavController()
                .navigate(RaportFragmentDirections.actionRaportFragmentToRaportFragmentz6().actionId)
        }

    }
    private fun openReportZone1Short() {
        GoTo_fragment_raport_zone1short.setOnClickListener {
            findNavController()
                .navigate(RaportFragmentDirections.actionRaportFragmentToRaportZone1ShortFragment().actionId)
        }
    }
    private fun openReportZone2Short() {
        GoTo_fragment_raport_zone2short.setOnClickListener {
            findNavController()
                .navigate(RaportFragmentDirections.actionRaportFragmentToRaportZone2ShortFragment().actionId)
        }

    }
    private fun openReportZone3Short() {
        GoTo_fragment_raport_zone3short.setOnClickListener {
            findNavController()
                .navigate(RaportFragmentDirections.actionRaportFragmentToRaportZone3ShortFragment().actionId)
        }

    }
    private fun openReportZone4Short() {
        GoTo_fragment_raport_zone4short.setOnClickListener {
            findNavController()
                .navigate(RaportFragmentDirections.actionRaportFragmentToRaportZone4ShortFragment().actionId)
        }

    }
    private fun openReportZone5Short() {
        GoTo_fragment_raport_zone5short.setOnClickListener {
            findNavController()
                .navigate(RaportFragmentDirections.actionRaportFragmentToRaportZone5ShortFragment().actionId)
        }

    }
    private fun openReportZone6Short() {
        GoTo_fragment_raport_zone6short.setOnClickListener {
            findNavController()
                .navigate(RaportFragmentDirections.actionRaportFragmentToRaportZone6ShortFragment().actionId)
        }

    }

        }
*/





