package com.example.pupmaag.data

import com.google.firebase.Timestamp


data class Raport (val id: String? = null,
                   val name: String? = null,
                   val zone: String? = null,
                   val date: Timestamp? = null,
                    val control: String? = null,
                   //val date: Date? = null
    )