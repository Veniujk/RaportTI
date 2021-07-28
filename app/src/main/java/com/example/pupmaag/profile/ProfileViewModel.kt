package com.example.pupmaag.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.example.pupmaag.data.Raport
import com.example.pupmaag.repository.FirebaseRepository

class ProfileViewModel : ViewModel() {
    private val repository = FirebaseRepository()

    val user = repository.getUserData()
    val userRaports = user.switchMap {
        repository.getFavCars(it.userRaports)
    }

    fun editProfileData(map: Map<String, String>){
        repository.editProfileData(map)
    }
    fun uploadUserPhoto(bytes: ByteArray){
        repository.uploadUserPhoto(bytes)
    }

}