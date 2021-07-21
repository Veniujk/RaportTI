package com.example.pupmaag.raport

import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.example.pupmaag.data.Car
import com.example.pupmaag.repository.FirebaseRepository

class RaportViewModel : ViewModel() {
    private val repository = FirebaseRepository()

    val user = repository.getUserData()
    val favCars = user.switchMap {
        repository.getFavCars(it.favCars)
    }


}