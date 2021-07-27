package com.example.pupmaag.home

import androidx.lifecycle.ViewModel
import com.example.pupmaag.data.Raport
import com.example.pupmaag.repository.FirebaseRepository

class HomeViewModel : ViewModel() {
    private val repository = FirebaseRepository()
    val raports = repository.getRaports()

    fun adduserRaports(raport: Raport){
        repository.adduserRaports(raport)

    }
}