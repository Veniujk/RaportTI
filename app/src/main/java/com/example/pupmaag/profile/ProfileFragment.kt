package com.example.pupmaag.profile

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.pupmaag.BaseFragment
import com.example.pupmaag.R
import com.example.pupmaag.data.User
import com.example.pupmaag.home.RaportAdapter
import com.example.pupmaag.home.OnRaportItemLongClick
import kotlinx.android.synthetic.main.fragment_profile.*
import java.io.ByteArrayOutputStream
import java.lang.Exception

class ProfileFragment : BaseFragment(), OnRaportItemLongClick {
    private val PROFILE_DEBUG = "PROFILE_DEBUG"
    private val REQUEST_IMAGE_CAPTURE = 1

    private val profileVm by viewModels<ProfileViewModel>()
    private val adapter = RaportAdapter(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupSubmitDataClick()
        setupTakePictureClick()
        recycleruserRaport.layoutManager = LinearLayoutManager(requireContext())
        recycleruserRaport.adapter = adapter
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        profileVm.user.observe(viewLifecycleOwner, {user ->
            bindUserData(user)
        })

        profileVm.userRaports.observe(viewLifecycleOwner, { list ->
            list?.let {
                adapter.setRaports(it)
            }
        })
    }
   /* override fun onCarLongClick(raport: Raport, position: Int) {
        profileVm.removeFavCar(raport)
        adapter.removeCar(raport, position)
    }*/

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){
            val imageBitmap = data?.extras?.get("data") as Bitmap

            Log.d(PROFILE_DEBUG, "BITMAP: " + imageBitmap.byteCount.toString())

            Glide.with(this)
                    .load(imageBitmap)
                    .circleCrop()
                    .into(userImage)

            val stream = ByteArrayOutputStream()
            val result = imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream)
            val byteArray = stream.toByteArray()

            if(result) profileVm.uploadUserPhoto(byteArray)
        }
    }

    private fun setupTakePictureClick(){
        userImage.setOnClickListener {
            takePicture()
        }
    }
    private fun takePicture() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE_SECURE)
        try {
            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE)
        }catch (exc: Exception){
            Log.d(PROFILE_DEBUG, exc.message.toString())
        }
    }
    private fun bindUserData(user: User) {
        Log.d(PROFILE_DEBUG,user.toString())
        userNameET.setText(user.name)
        userSurnameET.setText(user.surname)
        userEmailET.setText(user.email)
        Glide.with(this)
                .load(user.image)
                .circleCrop()
                .into(userImage)
    }
    private fun setupSubmitDataClick(){
        submitDataProfile.setOnClickListener {
            val name = userNameET.text.trim().toString()
            val surname = userSurnameET.text.trim().toString()

            val map = mapOf("name" to name, "surname" to surname)
            profileVm.editProfileData(map)
        }
    }


}