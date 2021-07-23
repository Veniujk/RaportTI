package com.example.pupmaag.home

import androidx.lifecycle.ViewModel
import com.example.pupmaag.data.Car
import com.example.pupmaag.repository.FirebaseRepository

class HomeViewModel : ViewModel() {
    private val repository = FirebaseRepository()
    val cars = repository.getCars()

    fun addFavCar(car: Car){
        repository.addFavCar(car)
        //repository.addCustomClass()
        repository.addZone1Raport()
    }
}