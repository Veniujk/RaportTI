package com.example.pupmaag.raport

import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.example.pupmaag.data.Car
import com.example.pupmaag.data.User
import com.example.pupmaag.data.Zone1
import com.example.pupmaag.repository.FirebaseRepository

class RaportViewModel : ViewModel() {
    private val repository = FirebaseRepository()

    fun addZone1Raport(zone1: Zone1){
        repository.addZone1Raport(zone1)
    }


}