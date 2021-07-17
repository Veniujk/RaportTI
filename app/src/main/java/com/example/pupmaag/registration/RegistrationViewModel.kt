package com.example.pupmaag.registration

import androidx.lifecycle.ViewModel
import com.example.pupmaag.data.User
import com.example.pupmaag.repository.FirebaseRepository

class RegistrationViewModel: ViewModel() {
    private val repository = FirebaseRepository()

    fun createNewUser(user: User){
        repository.createNewUser(user)
    }

}