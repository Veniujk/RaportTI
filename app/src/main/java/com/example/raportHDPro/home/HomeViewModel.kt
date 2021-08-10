package com.example.raportHDPro.home

import androidx.lifecycle.ViewModel
import com.example.raportHDPro.data.Raport
import com.example.raportHDPro.repository.FirebaseRepository

class HomeViewModel : ViewModel() {
    private val repository = FirebaseRepository()
    val raports = repository.getRaports()

    fun adduserRaports(raport: Raport){
        repository.adduserRaports(raport)

    }
}