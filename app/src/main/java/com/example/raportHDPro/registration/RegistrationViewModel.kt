package com.example.raportHDPro.registration

import androidx.lifecycle.ViewModel
import com.example.raportHDPro.data.User
import com.example.raportHDPro.repository.FirebaseRepository

class RegistrationViewModel: ViewModel() {
    private val repository = FirebaseRepository()

    fun createNewUser(user: User){
        repository.createNewUser(user)
    }

}