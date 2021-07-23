package com.example.pupmaag.raport

import android.app.Activity.RESULT_OK
import android.content.ContentValues
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.pupmaag.BaseFragment
import com.example.pupmaag.R
import com.example.pupmaag.data.Car
import com.example.pupmaag.data.User
import com.example.pupmaag.home.CarAdapter
import com.example.pupmaag.home.OnCarItemLongClick
import com.example.pupmaag.registration.RegistrationViewModel
import com.example.pupmaag.repository.FirebaseRepository
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.Timestamp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.fragment_raport.*
import kotlinx.android.synthetic.main.fragment_sign_up.*
import java.io.ByteArrayOutputStream
import java.lang.Exception
import java.util.*

class RaportFragment : BaseFragment() {
    private val Report_DEBUG = "REPORT_DEBUG"
    private val storage = FirebaseStorage.getInstance()
    private val auth = FirebaseAuth.getInstance()
    private val cloud = FirebaseFirestore.getInstance()
    private val reportVm by viewModels<RaportViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_raport, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sendReportClick()
    }

    private fun sendReportClick() {

        zone1_report_send.setOnClickListener {
            val zone1_room = zone1_report_room_name.text?.trim().toString()
            val zone1_lr1 = zone1_report_lp1.isChecked
            val data = hashMapOf(
                "cid" to "NBP",
                "date" to Timestamp(Date()),
                "name" to "garaz",
                "test" to zone1_room,
                "lr1" to zone1_lr1
            )
            if (zone1_room != null) {

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
        }
    }
}


/*
class RaportFragment : BaseFragment() {
    private val PROFILE_DEBUG = "PROFILE_DEBUG"
    private val REQUEST_IMAGE_CAPTURE = 1
    lateinit var zone1_report_lp1: CheckBox
    lateinit var zone1_report_send: Button
    private val profileVm by viewModels<RaportViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        inflater.inflate(R.layout.fragment_raport, container, false)
        //zone1_report_room_name = findViewById(R.id.zone1_report_room_name)
       // zone1_report_lp1 = findViewById(R.id.zone1_report_lp1)
       // zone1_report_send = findViewById(R.id.zone1_report_send)

        zone1_report_send.setOnClickListener {
            sendReport()


        }

        return inflater.inflate(R.layout.fragment_raport, container, false)
    }


    private fun sendReport() {
        val name = zone1_report_room_name.text.toString().trim()

        if (name.isEmpty()) {
            zone1_report_room_name.error = "Wprowadź nazwę kontrolowanego pokoju!"
            return
        }
    }}

*/