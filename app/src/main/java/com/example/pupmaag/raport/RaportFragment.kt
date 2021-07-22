package com.example.pupmaag.raport

import android.app.Activity.RESULT_OK
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
import com.example.pupmaag.repository.FirebaseRepository
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.fragment_raport.*
import java.io.ByteArrayOutputStream
import java.lang.Exception

class RaportFragment : BaseFragment() {
    private val PROFILE_DEBUG = "PROFILE_DEBUG"
    private val REQUEST_IMAGE_CAPTURE = 1

    private val profileVm by viewModels<RaportViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_raport, container, false)
    }
    /*  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
          super.onViewCreated(view, savedInstanceState)
          recyclerFavCars.layoutManager = LinearLayoutManager(requireContext())

      }
  */

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